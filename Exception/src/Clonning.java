
import java.lang.CloneNotSupportedException;
public class Clonning implements Cloneable
{
	int x=34;
	public int add(int a)
	{
		x=x+a;
		return x;
	}
	
	public static void main(String[] args)
	{
		Clonning obj=new Clonning();
		System.out.println(" Ist x="+" "+obj.x);
		System.out.println("x="+" "+obj.add(23));
		System.out.println(" 2nd x="+" "+obj.x);
		Clonning obj2=new Clonning();
		System.out.println("x="+" "+obj2.x);
		System.out.println("x="+" "+obj2.add(25));
		
		
	try
	{
		 Object obj1=obj.clone();
		 Clonning cobj=(Clonning)obj1; //passing the ref of Object class to Clonning Class
		 System.out.println("after clonning value: "+obj.x);
		 System.out.println("x:"+" "+obj.add(200));
	}
	catch(CloneNotSupportedException e)
	{
		//e.printStackTrace();
		System.out.println("pls correct input");
	}
	finally
	{
		System.out.println("in finally");
	}
	}
	
	
}
