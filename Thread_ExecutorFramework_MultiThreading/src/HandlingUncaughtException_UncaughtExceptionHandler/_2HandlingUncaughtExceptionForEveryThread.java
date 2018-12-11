package HandlingUncaughtException_UncaughtExceptionHandler;

public class _2HandlingUncaughtExceptionForEveryThread {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();

		System.out.println("[" + currentThreadName + "] Main thead starts here.....");

		/*** Way1 : Registering our ThreadExceptionHandler to the JVM
		 * By doing this approach, we are setting the same handler for all the threads in the system.
		 */
		Thread.setDefaultUncaughtExceptionHandler(new CustomThreadExceptionHandler("DEFAULT_HANDLER"));

		/****
		 * By setting UncaughtExceptionHandler, we won't need try-catch block any more.
		 * and we won't see stack trace any more
		 * and we will see that name of the threads whose exception has been caught along with handler name.
		 * By doing this we save our application to shut down.
		 */
		new Thread(new ExceptionLeakingTask(), "My Thread-1").start();
		new Thread(new ExceptionLeakingTask(), "My Thread-2").start();
		new Thread(new ExceptionLeakingTask(), "My Thread-3").start();
		new Thread(new ExceptionLeakingTask(), "My Thread-4").start();

		System.out.println("[" + currentThreadName + "] Main thead ends here.....");

	}
}
