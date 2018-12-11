
public class CreatingThreadWithExtendThread extends Thread {
	public void run()
	{
		for(int i=0;i<=10;i++){
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		CreatingThreadWithExtendThread obj = new CreatingThreadWithExtendThread();
		//Thread t = new Thread();
		obj.start();
	}
}

