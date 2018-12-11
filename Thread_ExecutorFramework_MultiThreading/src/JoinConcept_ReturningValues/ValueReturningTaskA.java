package JoinConcept_ReturningValues;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskA implements Runnable {
	private int a;
	private int b;
	private long sleepTime;
	private int sum;
	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	
	/****
	 * As this variable is read and written by the multiple threads, we need to make this variable as 'volatile' also.
	 * so that value is read accurately by the reader threads.
	 */
	private volatile boolean done = false;
	
	public ValueReturningTaskA(int a, int b, long sleepTime) {
		this.a =a;
		this.b=b;
		this.sleepTime=sleepTime;
		
		this.instanceNumber = ++count;
		this.taskId = "ValueRetunredTaskA-" + instanceNumber;
		
	}
	
	@Override
	public void run(){
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("#### [" + currentThreadName+ "] <" + taskId + "> STARTING #####");
		System.out.println("[" + currentThreadName+ "] <" + taskId + "> Sleeping for " + sleepTime + "millis");
		
		try{
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		}catch(InterruptedException e){
				e.printStackTrace();
		}
		
		sum = a+b;
		
		System.out.println("***** ["+ currentThreadName + "] <" + taskId + "> DONE *****");
		
		// after the task is completed, we should set value 'true' to done variable.
		done = true;
		
		//As soon as task is completed we should notify to waiting thread.
		synchronized (this) {
			System.out.println("***** ["+ currentThreadName + "] <" + taskId + "> NOTIFYING *****");
			this.notifyAll();
		}
	}
	
	/****
	 * We should wait till the each and respective thread completed successfully
	 * and to achieve this we should use wait and notify or notifyAll method of Object class.
	 * @return
	 */
	public int getSum(){
		/*if(!done){
			synchronized(this){
				try{
					System.out.println("***** ["+ Thread.currentThread().getName() + "] ==== WAITING for result from" + taskId+" *****");
					this.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			
			System.out.println("***** ["+ Thread.currentThread().getName() + "] < WOKEN UP " + taskId +"*****");
		}*/
		return sum;
	}
	
}
