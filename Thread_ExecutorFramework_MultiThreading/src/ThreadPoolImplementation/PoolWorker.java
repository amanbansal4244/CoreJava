package ThreadPoolImplementation;

import java.util.concurrent.LinkedBlockingQueue;

class PoolWorker extends Thread {
	
	private LinkedBlockingQueue queue;
	
	public PoolWorker( LinkedBlockingQueue queue) {
		 this.queue = queue;
	}
	
	public void run() {
		Runnable task;
		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						System.out.println("An error occurred while queue is waiting: " + e.getMessage());
					}
				}
				task = (Runnable) queue.poll();
			}
			// If we don't catch RuntimeException,
			// the pool could leak threads
			try {
				task.run();
			} catch (RuntimeException e) {
				System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
			}
		}
	}
}