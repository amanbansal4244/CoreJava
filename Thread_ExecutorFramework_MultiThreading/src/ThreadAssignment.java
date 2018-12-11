
class Thread11 extends Thread
{
	public void run()
	{
		for(int i=2;i<500;i+=2)
		{
			System.out.println("Even No: "+i);
			/*if(i<26)
			{
				try
				{
				
					System.out.println("Thread is about to sleep...");
					sleep(5000);
					
				}
				catch(InterruptedException ie)
				{
					System.out.println("Exception Occured While trying to sleep a method...");
				}
				finally
				{
				
				}
			}*/
		}
	}
}

class Thread13 implements Runnable
{
	public void run()
	{
		for(int i=1;i<500;i+=2)
		{
			System.out.println("Odd No: "+i);
			
			
		}
	}
}

class Thread14 extends Thread
{
	public void run()
	{
		for(int i=0;i<500;i++)
		{
			System.out.println("Whole No: "+i);
			
			
		}
	}

}

class Thread15 implements Runnable
{
	public void run()
	{
		for(int i=2;i<500;i++)
		{
			int flag=1;
			for(int j=2;j<i/2+1;j++)
				//for(int j=2;j<i;j++)
			{
				if(i%j==0)
					flag=0;
			}
			if(flag==1)
				System.out.println("Prime Number :"+i);
			
		}
	}
}


public class ThreadAssignment 
{
	
	public static void main(String[] args) 
	{
	Thread11 t1=new Thread11();
	System.out.println("main thread name: "+Thread.currentThread().getName());
	t1.setName("First Thread");
	t1.start();
	System.out.println(t1.getName());
	//System.out.println("main thread name: "+Thread.currentThread().getName());
	
	Thread13 t2=new Thread13();
	Thread t=new Thread(t2);
	//System.out.println(t.isAlive());
	t.setName("2nd Thread");
	System.out.println(t.getName());
	t.start();
	
	
	
	Thread14 t3=new Thread14();
	t3.setName("3rd Thread");
	System.out.println(t3.getName());
	//System.out.println(t3.isAlive());
	t3.start();
	
	Thread15 t4=new Thread15();
	Thread t5=new Thread(t4);
	t5.setName("4th Thread");
	System.out.println(t5.getName());
	//System.out.println(t5.isAlive());
	t5.start();
	
	
	System.out.println(t1.isAlive());
	System.out.println(t.isAlive());
	System.out.println(t3.isAlive());
	System.out.println(t5.isAlive());
	
	try
	{
		System.out.println("inside join");
		t1.join();
		t.join();
		t3.join();
		t5.join();
	}
	catch(InterruptedException ex)
	{
		System.out.println(ex.getMessage());
	}
	
	System.out.println(t1.isAlive());
	System.out.println(t.isAlive());
	System.out.println(t3.isAlive());
	System.out.println(t5.isAlive());
	int i=0;

	
	}
}

