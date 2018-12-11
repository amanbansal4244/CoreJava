package CountDownLatchConcept1_UsingExecutorFramework;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _2CountDownLatchDemoMain
{
	public static void main(String args[]) 
			throws InterruptedException
	{
		
		ExecutorService  executorService = Executors.newFixedThreadPool(4);
		
		// Let us create task that is going to wait for four threads before it starts.
		CountDownLatch latch = new CountDownLatch(4);

		executorService.execute(new WorkerThread(4000, latch, "WORKER-1"));
		executorService.execute(new WorkerThread(2000, latch, "WORKER-2"));
		executorService.execute(new WorkerThread(500, latch, "WORKER-3"));
		executorService.execute(new WorkerThread(1000, latch, "WORKER-4"));
		
		executorService.shutdown();
		
		// The main task waits for four threads.CountDownLatch.await() will wait until count reaches zero or it's interrupted by another Thread.
		latch.await();//Here await() method waits for count down latch flag 'latch' to become 0.
		
		// Main thread has started
		System.out.println(Thread.currentThread().getName() +" has finished");
	}
}