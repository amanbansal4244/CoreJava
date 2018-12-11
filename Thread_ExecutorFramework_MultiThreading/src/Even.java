
class MyThread1 extends Thread
{
	Thread th;
	MyThread1(String aman)
	{
		th=new Thread(this,aman);
		th.start();
		
		
	}
	 public void run()
	{
		if(th.getName().equals("bansal"))
		{
		this.task1();
		}
		if(th.getName().equals("anand"))
		{
		this.task2();
		}
		if(th.getName().equals("krishna"))
		{
		this.task3();
		}
		if(th.getName().equals("akshun"))
		{
		this.task4();
		}
	}
	
	synchronized public void task1()
	{
		for(int i=2;i<50;i+=2)
		{
			System.out.println("Even No: "+i);
		}
	}
	synchronized public void task2()
	{
		for(int i=1;i<50;i+=2)
		{
			System.out.println("Odd No: "+i);
			
			
		}
	}
	synchronized public void task3()
	{
		for(int i=0;i<50;i++)
		{
			System.out.println("Whole No: "+i);
			
			
		}
	}
	synchronized public void task4()
	{
		for(int i=2;i<50;i++)
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

public class Even 
{
	public static void main(String[] args) 
	{
		MyThread1 t1=new MyThread1("bansal");
		MyThread1 t2=new MyThread1("anand");
		MyThread1 t3=new MyThread1("krishna");
		MyThread1 t4=new MyThread1("akshun");
		//t1.start();
	}
}
