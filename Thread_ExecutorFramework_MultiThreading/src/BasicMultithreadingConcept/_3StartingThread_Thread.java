package BasicMultithreadingConcept;

class Runner extends Thread {
	
	@Override
	public void run() {
		for(int i=0;i<5;++i){
			System.out.println("Runner: "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Runner3 extends Thread {
	
	@Override
	public void run() {
		for(int i=0;i<5;++i){
			System.out.println("Runner3: "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class _3StartingThread_Thread {

	public static void main(String[] args) {
		
//		Thread t1 = new Thread(new Runner1());
//		Thread t2 = new Thread(new Runner2());
		
		Runner t1 = new Runner();
		Runner3 t2 = new Runner3();
		
		t1.start();
		t2.start();
	}
}
