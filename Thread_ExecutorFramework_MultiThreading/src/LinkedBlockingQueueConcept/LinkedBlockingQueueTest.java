package LinkedBlockingQueueConcept;
import java.util.*;
import java.util.concurrent.*;
 
/**
 * A producer-consumer test program for LinkedBlockingQueue
 * @author www.codejava.net
 */
public class LinkedBlockingQueueTest {
 
    public static void main(String[] args) {
 
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
 
        Thread producer = new Thread(new Producer(queue));
 
        Thread consumer = new Thread(new Consumer(queue));
 
        producer.start();
 
        consumer.start();
 
    }
}