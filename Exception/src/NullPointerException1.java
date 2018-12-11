
import java.lang.NullPointerException;
import java.util.Scanner;

public class NullPointerException1 
{
	Scanner s=new Scanner(System.in);
	int x;
	
	
	public void show()
	{
	try
	{
		s=null;
		x=s.nextInt();
		
	}
	catch(NullPointerException e)
	{
		System.out.println("remove dangling pointer");
		e.printStackTrace();
	}
	}	
	public static void main(String[] args)
	{
	NullPointerException1 obj=new NullPointerException1();
	obj.show();
	}
	
}
