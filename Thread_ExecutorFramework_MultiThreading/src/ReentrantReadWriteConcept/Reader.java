package ReentrantReadWriteConcept;

public class Reader extends Thread{
    private final _2Dictionary_ReentrantReadWriteLock dictionary;
    private boolean keepRunning = true;
 
    public Reader(_2Dictionary_ReentrantReadWriteLock dictionary, String name) {
        this.dictionary = dictionary;
        this.setName(name);
    }
 
    @Override
    public void run() {
        while (keepRunning) {
            String [] keys = dictionary.getKeys();
            for (String key : keys) {
                //reading from dictionary with READ LOCK
                String value = dictionary.get(key);
 
                //make what ever you want with the value.
                System.out.println(key + " : " + value);
            }
 
            //update every seconds
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
 
    public void stopReader() {
        this.keepRunning = false;
        this.interrupt();
    }
}