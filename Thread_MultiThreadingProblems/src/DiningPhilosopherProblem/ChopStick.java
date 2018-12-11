package DiningPhilosopherProblem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {

	/****
	 * There might be the situation where two Philosopher tries to acquire the same ChopStick in order to be able to eat.
	 * That's why we have to store the reference to a Lock. 
	 */
	private Lock lock;
	
	/*Every single ChopStick is going to have individual ID, this is how we are going to identify the single ChopStick */
	private int id;
	
	public ChopStick(int id){
		this.id = id;
		this.lock = new ReentrantLock();
	}
	
	/****
	 * Because we have to tell the given Philosopher whether that given ChopStick can be picked up or not.
	 * and we are going to have State whether that given Philosopher tries to pick up the right ChopStick or left ChopStick.
	 * @param philosopher
	 * @param state
	 * @return
	 * @throws InterruptedException
	 */
	public boolean pickUp(Philosopher philosopher, State state) throws InterruptedException{
	
		/****tryLock(long time, TimeUnit unit)- > Acquires the lock if it is free within the given waiting time and the current thread
		 *  has not been interrupted.
		 * 
		 * That given Philosopher tries to pickup that given ChopStick in 10 MILLISECONDS. If that given Philosopher manage to pick up the 
		 * given ChopStick , we are indicating to the console.
		 */
		if( this.lock.tryLock(10, TimeUnit.MILLISECONDS)){
			System.out.println(philosopher+" picked up "+state.toString()+" "+this);
			return true;
		}
		
		/* Returning false if Philosopher did not manage to pick up the given ChopStick or
		 *  Acquires the lock if it is free within the given waiting time i.e. 10 MILLISECONDS. */ 
		return false;
	}
	
	
	/****
	 * This method unlock on that given lock, by doing this -> ChopStick can be picked up by other Philosophers.
	 * So we will put down the ChopStick after the given Philosopher has eaten.
	 * @param philosopher
	 * @param state
	 */
	public void putDown(Philosopher philosopher, State state) {
		this.lock.unlock();
		System.out.println(philosopher+" put down "+this);
	}
	
	@Override
	public String toString() {
		return "Chopstick-"+this.id;
	}
}
