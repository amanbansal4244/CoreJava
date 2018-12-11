package _4UsingNewFixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import common.LoopTask;

public class _3UsingNewFixedThreadPool {

	public static void main(String[] args) {
		System.out.println("Main thread starts here");
		
		ExecutorService executerService = Executors.newFixedThreadPool(6); // Created 6 threads in thread pool
		
		/*Submitting 6 task to service , since no of threads are 6 in thread pool. All these 6 tasks would run concurrently.
		*/
		executerService.execute(new LoopTask()); 
		executerService.execute(new LoopTask());
		executerService.execute(new LoopTask());
		
		
		executerService.execute(new LoopTask()); 
		executerService.execute(new LoopTask());
		executerService.execute(new LoopTask());
		
		
		/* If we don't call shutDown() method , then program would be running in background and 
		 * it will cause the memory leak when you shut your application down
		
		*/
		executerService.shutdown();
		
		/*Submitting new task after called shutDown() API , we will get "Exception in thread "main" java.util.concurrent.RejectedExecutionExceptio"
		because service has been shutdown.
		*/
		executerService.execute(new LoopTask()); 
		System.out.println("Main thread ends here");
	}
}
