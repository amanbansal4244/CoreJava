package VolatileConcept;
/*Why is the final value of the "count" coming sometime less then 20000. 
 * I have used volatile hence the system should not cache "count" variable and the value should always be 20000.
 * When I used synchronized method it work fine but not in the case of volatile keyword.
 * 
 * Note : Memory Visibility and Atomicity are two different but common problem in Multithreading. 
 * 		  When you use synchronized keyword, it ensures both by acquiring the locks. Whereas volatile only solves the memory visibility issue
 * */
public class VolatileProbelm {

	/**** If we don't use 'volatile' then system may stored the count  value as 0 in cache,
	 * and we will always get 0 when ever we access 'count' even though we changed the value of count in anywhere
	 * but with 'volatile' keyword, we make sure that value of count variable read from RAM only, not from cache.
	 ****/
	private volatile int count = 0;
	private int limit = 10000;

	void method1(){
		count++;
	}

	public static void main(String[] args) {
		VolatileProbelm worker = new VolatileProbelm();
		worker.doWork();
	}

	public void doWork() {
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < limit; i++) {
					method1();
				}
			}
		});
		
		thread1.start();
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < limit; i++) {

					method1();

				}
			}
		});
		
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException ignored) {}
		System.out.println("Count is: " + count);
	}
}