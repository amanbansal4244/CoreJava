
public class ownMethod extends Thread {
	public void run()
	{
		System.out.println("run");
		task1();
		
	}
	void task1()
	{
		System.out.println("first");
	}
	void task2()
	{
		System.out.println("2nd");
	}
}

class th {
	public static void main(String[] args) {
		ownMethod om=new ownMethod();
		Thread t = new Thread(om);
		t.start();
	}
}
