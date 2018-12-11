import java.lang.ArrayIndexOutOfBoundsException;
public class indexOutOfArray 
{
	int a[]={1,2,3,4,5};
	
	public void show()
	{
		try
		{
		System.out.println(a[7]);
	
		}
	
	catch(ArrayIndexOutOfBoundsException e)
	{
		System.out.println("you are tring to accessing out of range");
	}
	
	finally
	{
		System.out.println("in finally");
		
	}

	}
		public static void main(String[] args)
	{
		indexOutOfArray obj=new indexOutOfArray();
		obj.show();
	}
}
