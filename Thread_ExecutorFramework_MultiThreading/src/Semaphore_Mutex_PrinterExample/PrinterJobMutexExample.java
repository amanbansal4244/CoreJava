package Semaphore_Mutex_PrinterExample;

/****
 * Implement a print queue for a printer that can be used by concurrent tasks to print their jobs. 
 * This print queue will be protected by a binary semaphore, so only one thread can print at a time.
 */
public class PrinterJobMutexExample
{
   public static void main(String[] args)
   {
      PrinterQueueForMutex printerQueueForMutex = new PrinterQueueForMutex();
      Thread thread[] = new Thread[10];
      for (int i = 0; i < 10; i++)
      {
         thread[i] = new Thread(new PrintingJob(printerQueueForMutex), "Thread " + i);
      }
      for (int i = 0; i < 10; i++)
      {
         thread[i].start();
      }
   }
}