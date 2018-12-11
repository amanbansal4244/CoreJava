package BlockingQueueConcept_OneProducerMultipleConsumer;

import java.util.*;
import java.util.concurrent.*;
 
/**
 * Consumer using BlockingQueue example
 *
 */
class Consumer implements Runnable{

	private final BlockingQueue<Integer> sharedQueue;
	private int threadNo;
	public Consumer (BlockingQueue<Integer> sharedQueue,int threadNo) {
		this.sharedQueue = sharedQueue;
		this.threadNo = threadNo;
	}

	@Override
	public void run() {
		while(true){
			try {
				int num = sharedQueue.take();
				System.out.println("Consumed: "+ num + ":by thread:"+threadNo);
			} catch (Exception err) {
				err.printStackTrace();
			}
		}
	}   
}
