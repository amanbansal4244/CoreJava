package ReentrantReadWriteConcept;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class _1ReadWriteLockConncept {
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
   private static final ReentrantReadWriteLock reentrantReadWriteLockObj = new ReentrantReadWriteLock(true);
   private static String message = "a";

   public static void main(String[] args) throws InterruptedException {
      Thread t1 = new Thread(new WriterA());
      t1.setName("Writer-A");
      
      Thread t2 = new Thread(new WriterB());
      t2.setName("Writer-B");
      
      Thread t3 = new Thread(new Reader());
      t3.setName("Reader-1");
      
      Thread t4 = new Thread(new Reader());
      t4.setName("Reader-2");
      
      t1.start();
      t2.start();
      t3.start();
      t4.start();
      t1.join();
      t2.join();
      t3.join();
      t4.join();
      
   }

   static class Reader implements Runnable {

      public void run() {
         
         if(reentrantReadWriteLockObj.isWriteLocked()) {
            System.out.println("Write Lock Present.");
         }
         
         reentrantReadWriteLockObj.readLock().lock();

         try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() 
               + " Time Taken " + (duration / 1000) + " seconds.");
            Thread.sleep(duration);
         } catch (InterruptedException e) {
            e.printStackTrace();
         } finally {
            System.out.println(Thread.currentThread().getName() +": "+ message );
            reentrantReadWriteLockObj.readLock().unlock();
         }
      }
   }

   static class WriterA implements Runnable {

      public void run() {
         reentrantReadWriteLockObj.writeLock().lock();
         
         try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() 
               + " Time Taken " + (duration / 1000) + " seconds.");
            Thread.sleep(duration);
         } catch (InterruptedException e) {
            e.printStackTrace();
         } finally {
            message = message.concat("a");
            reentrantReadWriteLockObj.writeLock().unlock();
         }
      }
   }

   static class WriterB implements Runnable {

      public void run() {
         reentrantReadWriteLockObj.writeLock().lock();
         
         try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() 
               + "  Time Taken " + (duration / 1000) + " seconds.");
            Thread.sleep(duration);
         } catch (InterruptedException e) {
            e.printStackTrace();
         } finally {
            message = message.concat("b");
            reentrantReadWriteLockObj.writeLock().unlock();
         }
      }
   }
}