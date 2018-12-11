package Semaphore_Mutex_PrinterExample;
class PrintingJob implements Runnable
{
   private PrinterQueueForMutex printerQueue;
 
   public PrintingJob(PrinterQueueForMutex printerQueue)
   {
      this.printerQueue = printerQueue;
   }
 
   @Override
   public void run()
   {
      System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
      printerQueue.printJob(new Object());
   }
}