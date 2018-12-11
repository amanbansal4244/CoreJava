class Reserve  extends Thread
{
	int available=5;
	int wanted;
	Reserve(int i)
	{
		wanted=i;
	}
	//synchronized public void run() // synchronized the method
	 public void run()
	 	{
		 synchronized(this) // synchronized block
		 {
		System.out.println("available: "+available);
		if(available>=wanted)
		{
			String name=Thread.currentThread().getName();
			System.out.println(wanted +" berth reserved for "+name);
			try
			{
				Thread.sleep(1500);
				available=available-wanted;
			}
			catch(InterruptedException e )
			{
				System.out.println(e.getMessage());
			}
			
		}
		else
		{
			System.out.println("sorry no berths");
		}
		}
		
	}
	
}
public class synchronize 
{
	public static void main(String[] args)
	{
		Reserve obj=new Reserve(2);
		Thread t=new Thread(obj);
		Thread t1=new Thread(obj);
		Thread t2=new Thread(obj);
		
		
		t.setName("Aman");
		t1.setName("Anand");
		t2.setName("Krishna");
		t1.start();
		t2.start();
		t.start();
	}

}
