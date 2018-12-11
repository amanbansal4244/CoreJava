package MultiRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
 
/****
 * It’s not necessary that each Runnable should be executed in a separate thread. Sometimes,
 *  we need to do multiple jobs in a single thread and each job is instance of Runnable. 
 *  To design this type of solution, a multi runnable should be used. 
 *  This multi runnable is nothing but a collection of runnables which needs to be executed. 
 *  Only addition is that this multi runnable is also a Runnable itself.
 *  
 *  		Below is the list of tasks which needs to be executed in a single thread.
 *  			TaskOne TaskTwo TaskThree
 */
public class MultiTaskExecutor {
 
    public static void main(String[] args) {
         
        BlockingQueue<Runnable> worksQueue = new ArrayBlockingQueue<Runnable>(10);
        
        RejectedExecutionHandler rejectionHandler = new RejectedExecutionHandelerImpl();
        
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, worksQueue, rejectionHandler);
 
        executor.prestartAllCoreThreads();
         
        List<Runnable> taskGroup = new ArrayList<Runnable>();
        
        taskGroup.add(new TestOne());
        taskGroup.add(new TestTwo());
        taskGroup.add(new TestThree());
  
        worksQueue.add(new MultiRunnable(taskGroup));
    }
}