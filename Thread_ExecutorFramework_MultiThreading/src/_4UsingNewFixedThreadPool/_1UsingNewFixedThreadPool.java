package _4UsingNewFixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import common.LoopTask;

public class _1UsingNewFixedThreadPool {

	public static void main(String[] args) {
		System.out.println("Main thread starts here");
		
		ExecutorService executerService = Executors.newFixedThreadPool(3); // Created 3 threads in thread pool
		
		/*Submitting three task to service , since no of threads are 3 in thread pool. All these 3 tasks would run concurrently.
		*/
		executerService.execute(new LoopTask());
		executerService.execute(new LoopTask());
		executerService.execute(new LoopTask());
		
		
		
		/* If we don't call shutDown() method , then program would be running in background and 
		 * it will cause the memory leak when you shut your application down.
		
		*/
		executerService.shutdown();
		System.out.println("Main thread ends here");
	}
}
