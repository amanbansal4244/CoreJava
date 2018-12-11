package BasicMultithreadingConcept;

class RunnerJoin1 extends Thread {
	
	@Override
	public void run() {
		for(int i=0;i<5;++i){
			System.out.println("RunnerJoin1: "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class RunnerJoin2 extends Thread {
	
	@Override
	public void run() {
		for(int i=0;i<5;++i){
			System.out.println("RunnerJoin2: "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class _4Join {

	public static void main(String[] args) {
		
//		Thread t1 = new Thread(new Runner1());
//		Thread t2 = new Thread(new Runner2());
		
		RunnerJoin1 t1 = new RunnerJoin1();
		RunnerJoin2 t2 = new RunnerJoin2();
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finished the tasks...");
	}
}
