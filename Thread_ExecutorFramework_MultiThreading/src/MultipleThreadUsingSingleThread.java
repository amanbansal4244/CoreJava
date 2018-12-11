
public class MultipleThreadUsingSingleThread  extends Thread {
	String str;
	public MultipleThreadUsingSingleThread (String str) {
		this.str=str;
	}

	public void run()
	{
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

}

class Multi1
{
	public static void main(String[] args) {
		MultipleThreadUsingSingleThread  obj1=new MultipleThreadUsingSingleThread("Cut the ticket");
		//MultiTaskingThread obj2=new MultiTaskingThread("show the ticket");
		Thread t1=new Thread(obj1);
		Thread t2=new Thread(obj1);
		t1.start();
		t2.start();
	}
}
