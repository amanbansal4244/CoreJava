package ThreadPoolImplementation;

import java.util.concurrent.LinkedBlockingQueue;
/****
 * Thread pool represents a group of worker threads which execute tasks, each thread can be reused many times. 
 * If a new task is submitted when all threads are active, they will wait in the queue until a thread is available. 
 * Thread pool implementation internally uses LinkedBlockingQueue for adding and removing tasks to the queue.
 * What we usually want is a work queue combined with a fixed group of worker threads, which uses wait()and notify() 
 * to signal waiting threads that new work has arrived. The following example shows a simple work queue which 
 * is queue of Runnable objects. This is a common convention for schedulers and work queues, although there is 
 * no particular need imposed by the Thread API to use the Runnable interface.
 * @author bansal
 *
 */
public class Main {
	public static void main(String[] args) {

		LinkedBlockingQueue queue = new LinkedBlockingQueue();

		ThreadPool pool = new ThreadPool(7,queue);
		for (int i = 0; i < 5; i++) {
			Task task = new Task(i);
			pool.execute(task);
		}
	}
}
