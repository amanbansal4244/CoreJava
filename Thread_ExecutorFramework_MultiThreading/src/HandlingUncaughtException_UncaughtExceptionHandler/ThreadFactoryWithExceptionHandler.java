package HandlingUncaughtException_UncaughtExceptionHandler;

public class ThreadFactoryWithExceptionHandler extends NamedThreadsFactory{

	public Thread newThread(Runnable r) {
		Thread t = super.newThread(r);
		t.setUncaughtExceptionHandler(new CustomThreadExceptionHandler());
		return t;
	}
}
