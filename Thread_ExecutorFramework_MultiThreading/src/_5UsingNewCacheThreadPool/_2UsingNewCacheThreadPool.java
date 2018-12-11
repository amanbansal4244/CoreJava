package _5UsingNewCacheThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import common.LoopTask;

public class _2UsingNewCacheThreadPool {

	public static void main(String[] args) {
		System.out.println("Main thread starts here");
		
		ExecutorService executerService = Executors.newCachedThreadPool(); // Created 3 threads in thread pool
		
		/*Submitting three task to service.
		*/
		executerService.execute(new LoopTask()); 
		executerService.execute(new LoopTask());
		executerService.execute(new LoopTask());
		
		/*Submitting three more new task to service ,All these 6 tasks would run concurrently.
		 * since we know that no of thread would be equal to no of submitted task but we also know that any of thread gets finished early, that
		 * thread can be reused instead of creating new thread.
		*/
		executerService.execute(new LoopTask()); 
		executerService.execute(new LoopTask());
		executerService.execute(new LoopTask());
		
		
		/* If we don't call shutDown() method , then program would be running in background and 
		 * it will cause the memory leak when you shut your application down
		
		*/
		executerService.shutdown();
		System.out.println("Main thread ends here");
	}
}
