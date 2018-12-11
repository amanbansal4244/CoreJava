package BasicMultithreadingConcept;

class Runner11 implements Runnable {
	
	@Override
	public void run() {
		for(int i=0;i<10;++i)
			System.out.println("Runner1: "+i);
	}
}

class Runner22 implements Runnable {
	
	@Override
	public void run() {
		for(int i=0;i<10;++i)
			System.out.println("Runner2: "+i);
	}
}

public class _2StartingThread_Runnable {

	public static void main(String[] args) {
		
		//Thread t1 = new Thread(new Runner1());
		//Thread t2 = new Thread(new Runner2());
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1000;++i)
					System.out.println("Runner11: "+i);
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1000;++i)
					System.out.println("Runner22: "+i);
			}
		});
		
		t1.start();
		t2.start();
	}
}
