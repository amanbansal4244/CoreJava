package CountDownLatchConcept1_UsingExecutorFramework;

import java.util.concurrent.CountDownLatch;

// A class to represent threads for which the main thread waits.
class WorkerThread extends Thread
{
	private int delay;

	private CountDownLatch latch;

	public WorkerThread(int delay, CountDownLatch latch, String name)
	{
		super(name);
		this.delay = delay;
		this.latch = latch;
	}

	@Override
	public void run()
	{
		try
		{
			Thread.sleep(delay);
			/****All other threads are required to do count down by calling CountDownLatch.countDown() once they are completed
			 *  or ready to the job. as soon as count reaches zero, the Thread awaiting starts running.
			 *  
			 *  countDown() method decrements count down latch flag 'latch' by 1.
			 */
			if(latch != null) {
				System.out.println("latch count: " + latch.getCount() + " and decrementing latch count by 1");
				latch.countDown();
				System.out.println(Thread.currentThread().getName()
						+ " finished");
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
