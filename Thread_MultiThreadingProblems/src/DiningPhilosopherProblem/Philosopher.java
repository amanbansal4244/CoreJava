package DiningPhilosopherProblem;

import java.util.Random;

public class Philosopher implements Runnable {
	
	/*Every single Philosopher is going to have individual ID, this is how we are going to identify the single Philosopher */
	private int id;
	private ChopStick leftChopStick;
	private ChopStick rightChopStick;
	
	/* When we want to stop the given thread for running, when the Philosopher is full,
	 *  then we are going to stop that given algorithm as per the SIMULATION_RUNNING_TIME */
	private volatile boolean isFull = false;
	
	/*Because every Philosopher is thinking or eating for random amount of time*/
	private Random random;
	
	/*At the end of the algorithm, we will count the how many times a given Philosopher has eaten*/
	private int eatingCounter;
	
	public Philosopher(int id, ChopStick leftChopStick, ChopStick rightChopStick){
		this.id = id;
		this.leftChopStick = leftChopStick;
		this.rightChopStick = rightChopStick;
		this.random = new Random();
	}
	
	@Override
	public void run() {
		try{
			/*We are going to run simulation till the 'isFull' variable is set to true. */
			while( !isFull ){
				/*Philosopher thinks for a moment and then Philosopher tries to eat */
				think();
				
				if( leftChopStick.pickUp(this, State.LEFT) ){
					if( rightChopStick.pickUp(this, State.RIGHT)){
						eat();
						rightChopStick.putDown(this, State.RIGHT);
					}
					
					leftChopStick.putDown(this, State.LEFT);
				}	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void think() throws InterruptedException {
		System.out.println(this+" is thinking...");
		Thread.sleep(this.random.nextInt(1000)); // going to sleep for some time while thinking.
	}
	
	private void eat() throws InterruptedException {
		System.out.println(this+" is eating...");
		this.eatingCounter++;
		Thread.sleep(this.random.nextInt(1000));// going to sleep for some time while eating.
	}
	
	public int getEatingCounter(){
		return this.eatingCounter;
	}
	
	public void setFull(boolean isFull){
		this.isFull = isFull;
	}
	
	@Override
	public String toString() {
		return "Philosopher-"+this.id;
	}
}
