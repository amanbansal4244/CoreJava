package DelayQueueConcept_ProcuderConsumerProblem;
import java.util.concurrent.*;
 
/****
 * Delay queue keeps the elements internally until a certain delay has expired.
 * and an object can only be taken from the queue when its delay has expired.
 * 
 * We can't place null item in the queue. The queue is sorted so that the object at the head
 * head a delay that has expired for the longest time.
 *  
 * If no delay has expired, then there is no head element and poll() will return null.
 * 
 * size() returns the count of both expired and unexpired items!!
 * 
 * @author bansal
 *
 */
public class DelayQueueMain {
    static int CONSUMER_THREADS = 3;
 
    public static void main(String[] args) {
        DelayQueue<DelayTask> queueTasks = new DelayQueue<>();
 
        Producer producer = new Producer(queueTasks);
        producer.start();
 
        Consumer[] consumers = new Consumer[CONSUMER_THREADS];
 
        for (int i = 0; i < CONSUMER_THREADS; i++) {
            consumers[0] = new Consumer(queueTasks);
            consumers[0].start();
        }
 
    }
}