package BlockingQueueConcept_MultipleProducerAndMultipleConsumer;
import java.util.*;
import java.util.concurrent.*;
 
/**
 * Producer-Consumer test example (1 producer thread - 1 consumer thread)
 * @author www.codejava.net
 *
 */
public class ProducerConsumerMain {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(20);
 
        Thread producer = new Thread(new Producer(queue));
 
        Thread consumer = new Thread(new Consumer(queue));
 
        producer.start();
        consumer.start();
 
    }
}