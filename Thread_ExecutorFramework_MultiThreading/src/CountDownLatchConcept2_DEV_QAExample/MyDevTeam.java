package CountDownLatchConcept2_DEV_QAExample;

import java.util.concurrent.CountDownLatch;

class MyDevTeam extends Thread {   
	
	CountDownLatch countDownLatch;
	public MyDevTeam (CountDownLatch countDownLatch, String name) {
		super(name);
		this.countDownLatch = countDownLatch;       
	}   

	@Override
	public void run() {
		System.out.println("Task assigned to development team " + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Task finished by development team Thread.currentThread().getName()):");
		this.countDownLatch.countDown();
	}
}