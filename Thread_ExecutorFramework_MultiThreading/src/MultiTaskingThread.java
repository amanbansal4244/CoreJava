
public class MultiTaskingThread extends Thread {
	String str;
	public MultiTaskingThread(String str) {
		this.str=str;
	}

	public void run()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println(str+ i);
			try{
				Thread.sleep(1000);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}

class Multi
{
	public static void main(String[] args) {
		MultiTaskingThread obj1=new MultiTaskingThread("Cut the ticket");
		MultiTaskingThread obj2=new MultiTaskingThread("show the ticket");
		Thread t1=new Thread(obj1);
		Thread t2=new Thread(obj2);
		t1.start();
		t2.start();
	}
}
