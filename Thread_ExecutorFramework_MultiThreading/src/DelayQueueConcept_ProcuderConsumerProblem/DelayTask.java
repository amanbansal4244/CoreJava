package DelayQueueConcept_ProcuderConsumerProblem;
import java.util.Random;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
 
/**
 * A task that has a delay time, which can be used in a DelayQueue.
 *
 * @author www.codejava.net
 */
public class DelayTask implements Delayed {
    private String name;
    private long delayTime;
 
    public DelayTask(String name, long delayTime) {
        this.name = name;
        this.delayTime = System.currentTimeMillis() + delayTime;
    }
 
    public long getDelay(TimeUnit timeUnit) {
        long difference = delayTime - System.currentTimeMillis();
        return timeUnit.convert(delayTime, TimeUnit.MILLISECONDS);
    }
 
    public void run() {
        long executionTime = new Random().nextInt(10000);
     
        try {
            Thread.sleep(executionTime);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
     
        System.out.println("Task " + name + " has been done.");}
     
    public String toString() {
        return this.name;
    }
    
    public int compareTo(Delayed another) {
    	System.out.println("In compare method");
        DelayTask anotherTask = (DelayTask) another;
 
        if (this.delayTime < anotherTask.delayTime) {
            return -1;
        }
 
        if (this.delayTime > anotherTask.delayTime) {
            return 1;
        }
 
        return 0;
    }
 
}