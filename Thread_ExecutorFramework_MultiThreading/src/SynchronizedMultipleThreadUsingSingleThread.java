
public class SynchronizedMultipleThreadUsingSingleThread  extends Thread {
	String str;
	public SynchronizedMultipleThreadUsingSingleThread (String str) {
		this.str=str;
	}

	 synchronized public void run()
	{
		//synchronized (this) {
		for(int i=0;i<3;i++)
		{
			System.out.println(str+ " " + i);
			try{
				Thread.sleep(1000);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	//}
}

class Multi2
{
	public static void main(String[] args) {
		SynchronizedMultipleThreadUsingSingleThread  obj1=new SynchronizedMultipleThreadUsingSingleThread("Cut the ticket");
		//MultiTaskingThread obj2=new MultiTaskingThread("show the ticket");
		Thread t1=new Thread(obj1);
		Thread t2=new Thread(obj1);
		t1.start();
		System.out.println(t1.getState());
		System.out.println(t1.isDaemon());
		System.out.println(t1.isAlive());
	//	t1.setDaemon(false);  will give java.lang.IllegalThreadStateException
	//	System.out.println(t1.isAlive());
		t2.start();
		//System.out.println(t1.isAlive());
	}
}

