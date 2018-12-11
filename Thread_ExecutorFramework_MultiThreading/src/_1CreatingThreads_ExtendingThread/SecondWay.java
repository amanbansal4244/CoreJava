package _1CreatingThreads_ExtendingThread;

 public class SecondWay {

	public static void main(String[] args) {
		System.out.println("Main thread starts here");
		 new SecondTask().start(); // this technique gives you more control on thread  
		 
		 SecondTask thread2 = new SecondTask();// creating Thread in main , not in constructor of class
												// by doing this , we are capturing the Thread referenc and 
												//enabling the manipulate the behavior of the Thread class in future
		
		thread2.start();
		System.out.println("Main thread ends here");
	}
}

 class SecondTask  extends Thread{
	
	public SecondTask(){
	//	this.start();
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
