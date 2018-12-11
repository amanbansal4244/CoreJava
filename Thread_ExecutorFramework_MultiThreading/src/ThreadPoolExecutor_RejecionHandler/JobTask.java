package ThreadPoolExecutor_RejecionHandler;

import java.util.TimerTask;

/*Asyncchrounous Task Should extend TimerTask*/
	class JobTask extends TimerTask
	{
		private String jobId="";

		public JobTask(String jobId)
		{
			this.jobId=jobId;
		}

		public String getJobId() {
			return jobId;
		}

		@Override
		public void run() {

			System.out.println("JobId:"+jobId+" Running through Thread:"+Thread.currentThread().getName());
			/*Make the Task to sleep for 5 seconds,so that the task will be busy*/
			try {
				Thread.sleep(5*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}