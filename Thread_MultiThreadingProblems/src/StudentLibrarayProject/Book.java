package StudentLibrarayProject;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
	
	/*Every single ChopStick is going to have individual ID, this is how we are going to identify the single ChopStick */
	private int id;
	
	/****
	 * There might be the situation where two Student tries to acquire the same Book in order to be able to read.
	 * That's why we have to store the reference to a Lock. 
	 */
	private Lock lock;

	public Book(int id) {
		this.lock = new ReentrantLock();
		this.id = id;
	}

	/****
	 * Because we have to tell the given Student whether that given Book can be picked up or not to read.
	 * @param student
	 * @return
	 * @throws InterruptedException
	 */
	public void readBook(Student student) throws InterruptedException {
		/****tryLock(long time, TimeUnit unit)- > Acquires the lock if it is free within the given waiting time and the current 
		 * thread has not been interrupted.
		 * 
		 * That given Student tries to pickup that given Book in 10 MILLISECONDS. If that given Student manage to pick up the 
		 * given Book , we are indicating to the console.
		 */
		//lock.lock();
		//lock.tryLock();
		try {
			if(lock.tryLock(10, TimeUnit.MINUTES)) {
				System.out.println(student + " starts reading " + this);
				Thread.sleep(2000);// Let's suppose reading takes 2 second to read then we unlock the lock.
			}
		}finally {
			lock.unlock();
			System.out.println(student + " has finished reading " + this);
		}
	}

	public String toString() {
		return "Book" + id;
	}

}