package HandlingUncaughtException_UncaughtExceptionHandler;

public class _3HandlingUncaughtExceptionDifferentlyPerThread {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();

		System.out.println("[" + currentThreadName + "] Main thead starts here.....");
		
		/****
		 *Way2 :  We are configuring different handler for all the threads in our system.
		 * We will see the different handler are handling the RuntimeExeception.
		 * 
		 * Q. Why we need to use the different handler for all the threads in our system.? Why not we simply use one handler ?
		 * Ans.: In real life based application , we can have multiple implementation or way to handle the exception or 
		 * handles different exception all together.
		 */
		Thread t1 = new Thread(new ExceptionLeakingTask(), "My Thread-1");
		t1.setUncaughtExceptionHandler(new CustomThreadExceptionHandler());
		
		
		Thread t2 = new Thread(new ExceptionLeakingTask(), "My Thread-2");
		t2.setUncaughtExceptionHandler(new CustomThreadExceptionHandler());
		
		
		Thread t3 = new Thread(new ExceptionLeakingTask(), "My Thread-3");
		t3.setUncaughtExceptionHandler(new CustomThreadExceptionHandler());
		
		
		Thread t4 = new Thread(new ExceptionLeakingTask(), "My Thread-4");
		t4.setUncaughtExceptionHandler(new CustomThreadExceptionHandler());

		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		System.out.println("[" + currentThreadName + "] Main thead ends here.....");

	}
}
