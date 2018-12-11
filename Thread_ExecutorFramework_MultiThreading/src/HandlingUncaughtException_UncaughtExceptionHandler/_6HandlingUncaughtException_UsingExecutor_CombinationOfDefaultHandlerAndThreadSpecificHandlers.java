package HandlingUncaughtException_UncaughtExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _6HandlingUncaughtException_UsingExecutor_CombinationOfDefaultHandlerAndThreadSpecificHandlers {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();

		System.out.println("[" + currentThreadName + "] Main thead starts here.....");
		
		/*** Way3 : To set the different handlers for different threads: we need to follow below steps:
		 * 	Step1: Implement a Thread Factory.
		 * 	Step2: Use void setUncaughtExceptionHandler(UncaughtExceptionHandler eh).
		 * 
		 * By doing this approach, we are configuring different handler for those threads whose sequence no. is even.
		 * and configuring default handler for those threads whose sequence no. is odd.
		 */

		Thread.setDefaultUncaughtExceptionHandler(new CustomThreadExceptionHandler("DEFAULT_HANDLER_EXECUTOR_ONE"));
		
		ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactoryWithExceptionHandlerAlternator());
		executorService.execute(new ExceptionLeakingTask());
		executorService.execute(new ExceptionLeakingTask());
		executorService.execute(new ExceptionLeakingTask());
		executorService.execute(new ExceptionLeakingTask());
		executorService.execute(new ExceptionLeakingTask());
		executorService.execute(new ExceptionLeakingTask());
		
		executorService.shutdown();
		
		System.out.println("[" + currentThreadName + "] Main thead ends here.....");

	}
}
