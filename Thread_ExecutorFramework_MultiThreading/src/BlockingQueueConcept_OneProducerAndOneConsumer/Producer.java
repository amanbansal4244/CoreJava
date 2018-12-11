package BlockingQueueConcept_OneProducerAndOneConsumer;

import java.util.*;
import java.util.concurrent.*;
 
/**
 * Producer using BlockingQueue example
 * @author www.codejava.net
 *
 */
public class Producer implements Runnable {
    private BlockingQueue<Integer> queue;
 
    public Producer (BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
 
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                queue.put(produce());
 
                Thread.sleep(500);
            }
 
            queue.put(-1);  // indicates end of producing
 
            System.out.println("Producer STOPPED.");
 
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
 
    private Integer produce() {
        Integer number = new Integer((int) (Math.random() * 100));
 
 
        System.out.println("Producing number => " + number);
 
        return number;
    }
}