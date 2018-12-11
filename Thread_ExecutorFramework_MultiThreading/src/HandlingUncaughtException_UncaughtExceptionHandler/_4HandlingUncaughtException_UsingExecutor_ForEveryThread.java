package HandlingUncaughtException_UncaughtExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _4HandlingUncaughtException_UsingExecutor_ForEveryThread {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();

		System.out.println("[" + currentThreadName + "] Main thead starts here.....");
		
		/*** Way1 : Registering our ThreadExceptionHandler to the JVM
		 * By doing this approach, we are setting the same handler for all the threads in the system.
		 */
		Thread.setDefaultUncaughtExceptionHandler(new CustomThreadExceptionHandler("DEFAULT_HANDLER_EXECUTOR"));
		
		ExecutorService executorService1 = Executors.newCachedThreadPool();
		executorService1.execute(new ExceptionLeakingTask());
		executorService1.execute(new ExceptionLeakingTask());
		executorService1.execute(new ExceptionLeakingTask());
		
		ExecutorService executorService2 = Executors.newCachedThreadPool();
		executorService2.execute(new ExceptionLeakingTask());
		executorService2.execute(new ExceptionLeakingTask());
		executorService2.execute(new ExceptionLeakingTask());
		
		executorService1.shutdown();
		executorService2.shutdown();
		
		System.out.println("[" + currentThreadName + "] Main thead ends here.....");

	}
}
