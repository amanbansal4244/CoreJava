package BlockingQueueConcept_OneProducerMultipleConsumer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
 
/**
 * Producer-Consumer test example (N producer thread - N consumer threads)
 * Different producers will generate different output instead of same output. Producer Thread 1 generates numbers from 11-15 
 * and Producer Thread 2 generates numbers from 21-25
 * 
 * Any of Consumer thread can consume data from any of Producers. Unlike Producers, Consumers don't have constraints to consume the data.
 * 
 * I have added Thread number in both Producer and Consumer.
 *
 */
public class ProducerConsumerMain {
    public static void main(String[] args) {
    	BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();

        Thread prodThread1 = new Thread(new Producer(sharedQueue,1));
        Thread prodThread2 = new Thread(new Producer(sharedQueue,2));
        Thread consThread1 = new Thread(new Consumer(sharedQueue,1));
        Thread consThread2 = new Thread(new Consumer(sharedQueue,2));

        prodThread1.start();
        prodThread2.start();
        consThread1.start();
        consThread2.start();
 
    }
}