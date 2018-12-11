package _6UsingNewSingleThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import common.LoopTask;

public class _1UsingNewSingleThreadPool {

	public static void main(String[] args) {
		System.out.println("Main thread starts here");
		
		ExecutorService executerService = Executors.newSingleThreadExecutor();
		
		/*Submitting three task to service ,we will see that first first thread starts executed then its ends.
		 * All 100 tasks are submitted, they will run only one by one in this case.
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
