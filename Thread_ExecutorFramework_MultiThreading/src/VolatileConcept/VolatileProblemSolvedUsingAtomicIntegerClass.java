package VolatileConcept;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileProblemSolvedUsingAtomicIntegerClass {
	private AtomicInteger count = new AtomicInteger(0);
	private int limit = 10000;

	void method1(){
		count.getAndIncrement();
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
