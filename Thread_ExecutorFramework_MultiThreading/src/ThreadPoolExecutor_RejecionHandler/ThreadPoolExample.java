package ThreadPoolExecutor_RejecionHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {

	private ThreadPoolExecutor threadPoolExecutor=null;

	public static void main(String[] args) {
		ThreadPoolExample threadPoolExample= new ThreadPoolExample();
		threadPoolExample.createThreadPool();//To create the ThreadPool
		threadPoolExample.submitTask();//To submit the Task
	}

	private void createThreadPool() {
		int poolSize=2;
		int maxPoolSize=5;
		int queueSize=3;
		long aliveTive=1000;
		ArrayBlockingQueue<Runnable> queue= new ArrayBlockingQueue<Runnable>(queueSize);
		threadPoolExecutor= new ThreadPoolExecutor(poolSize,maxPoolSize,aliveTive,
				TimeUnit.MILLISECONDS,queue,new JobRejectionHandler());
	}

	private void submitTask()
	{
		/*Submit 10 AsunchronousTask to ThreadPool */
		for (int i=1;i<=10;i++)
		{
			threadPoolExecutor.execute(new JobTask("Job"+i));
		}
	}

	

}