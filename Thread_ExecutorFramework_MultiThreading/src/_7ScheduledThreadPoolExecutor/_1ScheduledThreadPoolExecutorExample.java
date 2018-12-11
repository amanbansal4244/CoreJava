package _7ScheduledThreadPoolExecutor;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
 
public class _1ScheduledThreadPoolExecutorExample
{
    public static void main(String[] args) 
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        Task task1 = new Task ("Demo Task 1");
        Task task2 = new Task ("Demo Task 2");
         
        System.out.println("The time is : " + new Date());
         
        //First two tasks would get started in 5 seconds simultaneously.
        executor.schedule(task1, 5 , TimeUnit.SECONDS);
        executor.schedule(task2, 5 , TimeUnit.SECONDS);
        //Third one task would get started in 10 seconds simultaneously.
        executor.schedule(task2, 10 , TimeUnit.SECONDS);
        
        try {
              executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
              e.printStackTrace();
        }
         
        executor.shutdown();
    }
}