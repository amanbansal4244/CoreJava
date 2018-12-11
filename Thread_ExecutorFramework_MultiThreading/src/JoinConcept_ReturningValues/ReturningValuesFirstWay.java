package JoinConcept_ReturningValues;

/****
 * In this way, main thread is blocked if worker thread has not yet completed.
 * @author bansal
 *
 */
public class ReturningValuesFirstWay {

	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("[" + currentThreadName + "] Main thead starts here.....");
		
		ValueReturningTaskA task1 = new ValueReturningTaskA(2,3,2000);
		Thread t1 = new Thread(task1, "Thread-1");
		
		ValueReturningTaskA task2 = new ValueReturningTaskA(3,4,1000);
		Thread t2 = new Thread(task2, "Thread-2");
		
		ValueReturningTaskA task3 = new ValueReturningTaskA(4,5,500);
		Thread t3 = new Thread(task3, "Thread-3");
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join(); // Thread 1 will complete first and print its result.
		System.out.println("Result: 1 =" + task1.getSum());
		
		t2.join();// Thread 2 will complete first and print its result.
		System.out.println("Result: 2 =" + task2.getSum());
		
		t3.join();// Thread 3 will complete first and print its result.
		System.out.println("Result: 3 =" + task3.getSum());
		
		System.out.println("[" + currentThreadName + "] Main thead ends here.....");
		
	}
}
