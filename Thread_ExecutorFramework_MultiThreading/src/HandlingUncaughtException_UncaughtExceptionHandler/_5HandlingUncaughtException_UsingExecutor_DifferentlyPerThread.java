package HandlingUncaughtException_UncaughtExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _5HandlingUncaughtException_UsingExecutor_DifferentlyPerThread {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();

		System.out.println("[" + currentThreadName + "] Main thead starts here.....");
		
		/*** Way2 : To set the different handlers for different threads: we need to follow below steps:
		 * 	Step1: Implement a Thread Factory
		 * 	Step2: Use void setUncaughtExceptionHandler(UncaughtExceptionHandler eh)
		 * 
		 * By doing this approach, this thread will have different handler to handle the exception.
		 */
		
		ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactoryWithExceptionHandler());
		executorService.execute(new ExceptionLeakingTask());
		executorService.execute(new ExceptionLeakingTask());
		executorService.execute(new ExceptionLeakingTask());
		
		executorService.shutdown();
		
		System.out.println("[" + currentThreadName + "] Main thead ends here.....");

	}
}
