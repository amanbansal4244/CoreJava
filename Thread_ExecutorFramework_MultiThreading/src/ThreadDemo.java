                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
 class Thread1 extends Thread
{
	public void run()
	{
		for(int i=0;i<100;i++)
		{
			System.out.println("Thread 1: "+i);
			if(i<200)
			{
				System.out.println("sleeping");
				try
				{
					sleep(3000);
				}
				catch(InterruptedException e)
				{
					System.out.println(e.getMessage());
				}
			}	
			else
				{
					System.out.println("thread 1 is Not Sleeping");
				}
			}
		}
 }


 class Thread2 extends Thread
{
	 public void run()
		{
			for(int i=500;i<600;i++)
			{
				System.out.println("Thread 2: "+i);
			}
		} 
}
 
 class Thread3 implements Runnable
 {
	 
	 public void run()
		{
			for(int i=1000;i<1100;i++)
			{
				System.out.println("Thread 3: "+i);
			}
		} 
}

 public class ThreadDemo
 {
	 public static void main(String[] args)
	 {
		 //Creating obj of Thread1
		Thread1 t1 = new Thread1();
		t1.start();
		 //Creating obj of Thread1
		Thread2 t2 = new Thread2();
		t2.start();
		 //Creating obj of Thread3 which is implementing runnable interface
		Thread3 t3 = new Thread3();
		Thread t=new Thread(t3); // passing the obj of thread into InBuilt Thread Class 
		t.start();
		//t1.destroy();
		//t2.destroy();
		
		
	 }
 }