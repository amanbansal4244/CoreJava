
class MyThread extends Thread
{
	public void run()
	{
		task1();
		task2();
		task3();
		task4();
	}
	
	public void task1()
	{
		for(int i=2;i<50;i+=2)
		{
			System.out.println("Even No: "+i);
		}
	}
	public void task2()
	{
		for(int i=1;i<50;i+=2)
		{
			System.out.println("Odd No: "+i);
			
			
		}
	}
	public void task3()
	{
		for(int i=0;i<50;i++)
		{
			System.out.println("Whole No: "+i);
			
			
		}
	}
	public void task4()
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

public class PrimeAssignment 
{
	public static void main(String[] args) 
	{
		MyThread t1=new MyThread();
		t1.start();
	}
}
