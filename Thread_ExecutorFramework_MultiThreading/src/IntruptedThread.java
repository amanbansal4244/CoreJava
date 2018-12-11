
public class IntruptedThread extends Thread {
	
	public void run(){
		for(int i=1;i<=5;i++)
		{
			System.out.println(i);
		}
	}
	
	public void run(String s){
		for(int i=1;i<=5;i++)
		{
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		IntruptedThread it=new IntruptedThread();
		it.start();
		//it.interrupt();
	}
}
