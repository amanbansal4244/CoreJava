package HandlingUncaughtException_UncaughtExceptionHandler;

public class ThreadFactoryWithExceptionHandlerAlternator extends NamedThreadsFactory{

	private int count = 0;

	public Thread newThread(Runnable r) {
		Thread t = super.newThread(r);

		int sequenceNumber = ++count;
		/****
		 * we are configuring different handler for those threads whose sequence no. is even.
		 */
		if(sequenceNumber % 2 == 0) {
			t.setUncaughtExceptionHandler(new CustomThreadExceptionHandler());
		}
		return t;
	}
}
