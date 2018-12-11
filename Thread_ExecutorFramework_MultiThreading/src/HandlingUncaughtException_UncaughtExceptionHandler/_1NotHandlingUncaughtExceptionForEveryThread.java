package HandlingUncaughtException_UncaughtExceptionHandler;

public class _1NotHandlingUncaughtExceptionForEveryThread {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();

		System.out.println("[" + currentThreadName + "] Main thead starts here.....");

		/****
		 * By handling RuntimeException using try-catch block, we will see that all 4 threads would run and 
		 * still see exception stack trace and we won't be able to see our catch block print statement because in Java, 
		 * exception can't be caught by try-catch block or directly.
		 */
		try {
			new Thread(new ExceptionLeakingTask(), "My Thread-1").start();
			new Thread(new ExceptionLeakingTask(), "My Thread-2").start();
			new Thread(new ExceptionLeakingTask(), "My Thread-3").start();
			new Thread(new ExceptionLeakingTask(), "My Thread-4").start();
		}catch(RuntimeException re) {
			System.out.println("[" + currentThreadName + "] caught exception" + re);
		}

		System.out.println("[" + currentThreadName + "] Main thead ends here.....");

	}
}
