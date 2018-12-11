
public class CreatingThredWithRunnable implements Runnable {
	public void run()
	{
		for(int i=0;i<=10;i++){
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		CreatingThredWithRunnable obj = new CreatingThredWithRunnable();
		Thread t = new Thread(obj);
		t.start();
	}
}

