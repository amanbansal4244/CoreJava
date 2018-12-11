package VolatileConcept;

public class VolatileProblemSolvedUsingSynchronizedKeyword {
	/**** If we don't use 'volatile' then system may stored the count  value as 0 in cache,
	 * and we will always get 0 when ever we access 'count' even though we changed the value of count in anywhere
	 * but with 'volatile' keyword, we make sure that value of count variable read from RAM only, not from cache.
	 ****/
	private volatile int count = 0;
	private int limit = 10000;

	//using synchronized block
	/*public void method1(){
		synchronized (this) {
			count++;
			//Thread.currentThread() .interrupt();
			
		}
		
	}*/
	
	//using synchronized keyword
	public synchronized void method1(){
			count++;
	}

	public static void main(String[] args) {
		VolatileProblemSolvedUsingSynchronizedKeyword worker = new VolatileProblemSolvedUsingSynchronizedKeyword();
		worker.doWork();
	}

	public void doWork() {
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < limit; i++)
					method1();
			}
		});
		
		thread1.start();
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < limit; i++)
					method1();
			}
		});

		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException ignored) {
		}
		System.out.println("Count is: " + count);
	}
}
