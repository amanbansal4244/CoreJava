package DelayQueueConcept_ProcuderConsumerProblem;
import java.util.concurrent.*;
 
/**
 * A consumer thread that takes delayed tasks from a DelayQueue
 * and processes them.
 * @author www.codejava.net
 */
public class Consumer extends Thread {
    private DelayQueue<DelayTask> queue;
    private int taskCount;
 
    public Consumer(DelayQueue<DelayTask> queue) {
        this.queue = queue;
    }
 
    public void run() {
        while(true) {
            try {
                DelayTask task = queue.take();
                consume(task);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
 
    private void consume(DelayTask task) {
        System.out.println(getName() + ": prepare to process " + task);
        task.run();
    }
}