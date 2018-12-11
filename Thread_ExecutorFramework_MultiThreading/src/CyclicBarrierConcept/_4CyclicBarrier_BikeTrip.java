package CyclicBarrierConcept;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
 /****
  * Here is an easy example to remember its behavior: "4 bikers have started driving from Manali to Leh. 
  * As all of them are driving at different speed, they have decided some checkpoints in their route. 
  * After reaching to first checkpoint, everybody waits for others to reach that checkpoint. 
  * Once all 4 arrives, they will refill the petrol tanks and resume their rides and drive until their next checkpoint. "
  * 
  * In above example, bikers are worker threads or parties. checkpoint is barrier. 
  * Once all bikers reaches the checkpoint/barrier they will refill the petrol (barrierAction) and reset the barrier.
  * @author bansal
  *
  */
public class _4CyclicBarrier_BikeTrip {
 
    public static void main(String args[]) 
    {
 
        // creating CyclicBarrier (checkPoint) with 
        // 4 parties (Bikers) threads that need to call await()
        final CyclicBarrier checkPoint = new CyclicBarrier(4, new Runnable(){
            @Override
            public void run(){
            	/****
            	 * New CyclicBarrier is created where parties number of thread wait for each other to reach common barrier point,
            	 *  when all threads have reached common barrier point, 
            	 * parties number of waiting threads are released and barrierAction (event) is triggered in Java.
            	 * 
            	 * So,This task will be executed once all biker threads will reach barrier.
            	 */
                System.out.println("\nAll bikers have arrived to checkpoint. Let's refill the petrol\n");
            }
        });
 
        //starting each of thread
        Thread biker1 = new Thread(new Biker(checkPoint), "Biker Thread 1");
        Thread biker2 = new Thread(new Biker(checkPoint), "Biker Thread 2");
        Thread biker3 = new Thread(new Biker(checkPoint), "Biker Thread 3");
        Thread biker4 = new Thread(new Biker(checkPoint), "Biker Thread 4");
 
        biker1.start();
        biker2.start();
        biker3.start();
        biker4.start();
         
       
    }
}
 
class Biker implements Runnable 
{
 
    private CyclicBarrier checkPoint;
 
    public Biker(CyclicBarrier checkPoint) {
        this.checkPoint = checkPoint;
    }
 
    // Code to be executed by each biker
    @Override
    public void run() 
    {
        try
        {
            System.out.println(Thread.currentThread().getName() + " has left Manali");
             
            checkPoint.await();
            System.out.println(Thread.currentThread().getName() + " has left the first checkpoint / barrier");
             
            checkPoint.await();
            System.out.println(Thread.currentThread().getName() + " has left the second checkpoint / barrier");
             
            checkPoint.await();
            System.out.println(Thread.currentThread().getName() + " has reached Leh");
             
        } 
        catch (InterruptedException |  BrokenBarrierException ex) 
        {
            ex.printStackTrace();
        }
    }
}