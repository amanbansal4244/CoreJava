package PriorityBlockingQueue;
import java.util.concurrent.BlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/****
 * The PriorityBlockingQueue class implements the BlockingQueue interface. Read the BlockingQueue text for more information about the interface.
 * 
 * The PriorityBlockingQueue is an unbounded concurrent queue. It uses the same ordering rules as the java.util.PriorityQueue class. 
 * You cannot insert null into this queue.
 * 
 * All elements inserted into the PriorityBlockingQueue must implement the java.lang.Comparable interface. 
 * The elements thus order themselves according to whatever priority you decide in your Comparable implementation.
 * 
 * Notice that the PriorityBlockingQueue does not enforce any specific behavior for elements that have equal priority (compare() == 0).
 * 
 * Also notice, that in case you obtain an Iterator from a PriorityBlockingQueue, the Iterator does not guarantee to iterate the elements 
 * in priority order.
 *
 */
public class Main {
	public static void main(String[] args) {
		final ExecutorService service = Executors.newFixedThreadPool(2);
		
		final BlockingQueue<Document> bqueue = new PriorityBlockingQueue<Document>();
		
		service.execute(new AddDocumentThread(bqueue));
		service.execute(new PrintDocumentThread(bqueue));		
		service.shutdown();
	}
} 