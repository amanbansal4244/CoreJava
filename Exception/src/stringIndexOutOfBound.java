import java.lang.StringIndexOutOfBoundsException;
public class stringIndexOutOfBound
{
	String a="amansa";
	
	public void show()
	{
		try
		{
		System.out.println(a.indexOf('u'));
		System.out.println(a.charAt(4));
		System.out.println(a.charAt('4'));
		}
		
		catch(StringIndexOutOfBoundsException e)
		{
			//e.printStackTrace();
			System.out.println("care");
		}
		finally
		{
			System.out.println("in finally");
		}
		
		//System.out.println(a.lastIndexOf('a'));
		//System.out.println(a.substring(3));
		//System.out.println(a.substring(2,5));
		
		
	}
	
	public static void main(String[] args) {
	
		stringIndexOutOfBound obj =new stringIndexOutOfBound();
		obj.show();
	}
}
