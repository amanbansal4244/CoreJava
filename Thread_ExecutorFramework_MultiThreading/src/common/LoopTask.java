package common;

public class LoopTask implements Runnable {

	private static int count = 0;
	int id;
	
	public LoopTask() {
		this.id = count ++;
	}
	
	@Override
	public void run() {
		System.out.println("Task Id: "+ id + " :" + "Start Loop Task for:" + Thread.currentThread().getName());
		for(int i=0 ; i<3; i++){
			System.out.println(" Thread Name :" + Thread.currentThread().getName() + " : Tick Tick :" + i);
			try {
				Thread.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("Task Id: "+  id + " :" +"Ends Loop Task for :" + Thread.currentThread().getName());
	}

}
