package Semaphore_Mutex_PrinterExample;

import java.util.Date;
import java.util.concurrent.Semaphore;

class PrinterQueueForMutex
{
   private final Semaphore semaphore;
 
   public PrinterQueueForMutex()
   {
      semaphore = new Semaphore(1); // Mutex
   }
 
   /****
    * Look at the printJob() method. This method shows the three steps you must follow when you use a semaphore
    * to implement a critical section, and protect the access to a shared resource:
    * 		-First, you acquire the semaphore, with the acquire() method.
    * 		-Then, you do the necessary operations with the shared resource
    * 		-Finally, release the semaphore with the release() method.
    * @param document
    */
   public void printJob(Object document)
   {
      try
      {
         semaphore.acquire();
          
         Long duration = (long) (Math.random() * 10000);
         System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + 
        		 		(duration / 1000) + " seconds :: Time - " + new Date());
         Thread.sleep(duration);
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
      finally
      {
         System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
          
         semaphore.release();
      }
   }
}
