package _1CreatingThreads_ExtendingThread;

public class FirstWay {

	public static void main(String[] args) {
		System.out.println("Main thread starts here");
	    new FirstThread();
	    new FirstThread();
	
		System.out.println("Main thread ends here");
	}
}

 class FirstThread  extends Thread{
	
	public FirstThread(){
		this.start();
	}
	
	@Override
	public void run() {
		for(int i=0 ; i< 10; i++){
			System.out.println(" Thread Name :" + Thread.currentThread().getName() + " : Tick Tick :" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
