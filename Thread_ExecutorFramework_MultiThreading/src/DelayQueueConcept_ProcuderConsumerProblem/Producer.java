package DelayQueueConcept_ProcuderConsumerProblem;
import java.util.*;
import java.util.concurrent.*;
 
/**
 * A consumer thread that creates random DelayTask objects.
 *
 * @author www.codejava.net
 */
public class Producer extends Thread {
	
    private DelayQueue<DelayTask> queue;
    private static int taskCount;
 
    public Producer(DelayQueue<DelayTask> queue) {
        this.queue = queue;
    }
 
    public void run() {
        while(true) {
            queue.put(produce());
        }
    }
 
    private DelayTask produce() {
        String taskName = "Task " + (++taskCount);
        long delayTime = new Random().nextInt(10000);
 
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
 
        System.out.println(getName() + ": produced " + taskName);
 
        return new DelayTask(taskName, delayTime);
    }
}