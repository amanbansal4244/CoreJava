package HandlingUncaughtException_UncaughtExceptionHandler;

public class ExceptionLeakingTask implements Runnable {

	@Override
	public void run() {
		/****
		 * Why we are throwing RuntimeException ? Why not Checked Exception?
		 * This is because : run method of Runnable inteface does not declare any checked exception
		 */
		throw new RuntimeException();
	}
	
}
