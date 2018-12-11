package BasicMultithreadingConcept;

class Worker implements Runnable {

	/**** If we don't use 'volatile' then system may stored the 'isTerminated'  value as false in cache,
	 * and we will always get false when ever we access 'isTerminated' even though we changed/set the value of 'isTerminated 
	 * in anywhere but with 'volatile' keyword, we make sure that value of isTerminated variable read from RAM only, not from cache.
	 ****/
	private boolean isTerminated = false;
	
	@Override
	public void run() {
		
		while(!isTerminated) {
			
			System.out.println("Hello from worker class...");
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isTerminated() {
		return isTerminated;
	}

	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}
}

public class _5Deadlock {

	public static void main(String[] args) {
		
		Worker worker = new Worker();
		Thread t1 = new Thread(worker);
		t1.start();
			
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		worker.setTerminated(true);
		System.out.println("Finished...");
	}
}
