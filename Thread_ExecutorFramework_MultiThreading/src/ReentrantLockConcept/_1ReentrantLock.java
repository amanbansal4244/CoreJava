package ReentrantLockConcept;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*ReentrantLock
 *			 1. Java Lock API provides more visibility and options for locking, unlike synchronized where a thread might end up waiting 
 * 				indefinitely for the lock, we can use tryLock() to make sure thread waits for specific time only.
 * 
 * 			 2. new ReentrantLock(boolean fairnessParameter)
 * 					- fairness parameter : if it is set to be true --> the longest waiting thread will get the lock.
 * 					- fairness parameter : if it is set to be false --> there is no access order!!!
 * 
 * 			 IMPORTANT: we have to use try-catch when doing critical section that may throw exceptions.	
 * 						- we should call unlock() in the finally block!!!
 * 
 * 			 3. we have to use both lock and unlock in-order to make the as synchronized.
 * 
 */

public class _1ReentrantLock {

	private static volatile int counter = 0;
	private static Lock lock = new ReentrantLock();
	
	public static void increment(){
		try {
			//Acquiring lock.
			lock.lock(); // this is kind of similar like synchronized block.
			counter++;
		} finally{
			//Release lock
			lock.unlock(); // this is kind of similar like synchronized block.
		}
	}
	
	public static void firstThread(){
		for(int i=0;i<1000;i++){
			increment();
		}
	}
	
	public static void secondThread(){
		for(int i=0;i<1000;i++){
			increment();
		}
	}
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				firstThread();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				firstThread();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(counter);
		
	}
}
