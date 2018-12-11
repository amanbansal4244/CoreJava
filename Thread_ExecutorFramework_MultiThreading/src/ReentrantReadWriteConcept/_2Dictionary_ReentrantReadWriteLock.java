package ReentrantReadWriteConcept;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/****
 * A ReadWriteLock maintains a pair of associated locks, one for read-only operations and one for writing. 
 * The read lock may be held simultaneously by multiple reader threads, so long as there are no writers.
 *  The write lock is exclusive.
 *  
 *  It provided more flexibility as it exploits the fact that only a single thread can modify whereas 
 *  multiple threads can read at same time. The actual performance depends upon frequency of read-writes, 
 *  duration of each operation, and the contention for the data i.e. no of threads that will try to read-write
 *   the data at same time.
 */
public class _2Dictionary_ReentrantReadWriteLock {
	
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Map<String,String> dictionary = new HashMap<>();
 
    public void set(String key, String value) {
        readWriteLock.writeLock().lock();
        try {
            dictionary.put(key, value);
        } finally {
             readWriteLock.writeLock().unlock();
        }
    }
 
    public String get(String key) {
        readWriteLock.readLock().lock();
        try{
            return dictionary.get(key);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
 
    public String[] getKeys() {
    	readWriteLock.readLock().lock();
    	try {
    		//return (String[]) dictionary.keySet().toArray();
    		String keys[] = new String[dictionary.size()];
    		return dictionary.keySet().toArray(keys);
    	} finally {
    		readWriteLock.readLock().unlock();
    	}
    }
    
    
    public static void main(String[] args) {
        _2Dictionary_ReentrantReadWriteLock dictionary = new _2Dictionary_ReentrantReadWriteLock();
        dictionary.set("java",  "object oriented");
        dictionary.set("linux", "rules");
        Writer writer  = new Writer(dictionary, "Writer");
        Reader reader1 = new Reader(dictionary ,"ReaderOne");
        Reader reader2 = new Reader(dictionary ,"ReaderTwo");
        Reader reader3 = new Reader(dictionary ,"ReaderThree");
        Reader reader4 = new Reader(dictionary ,"ReaderFour");
        writer.start();
        reader1.start();
        reader2.start();
        reader3.start();
        reader4.start();
    }
}
