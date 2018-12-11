package ThreadPoolExecutor_RejecionHandler;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/*RejectionHandler to handle any rejected Task*/
 class JobRejectionHandler implements RejectedExecutionHandler{

  @Override
  public void rejectedExecution(Runnable arg0, ThreadPoolExecutor arg1) {
   JobTask jobTask=(JobTask)arg0;
      System.out.println("JobId:"+jobTask.getJobId()+" Running through RejectionHandler,Since "
                   +"there are no ideal threads in ThreadPool");
  }

 }
