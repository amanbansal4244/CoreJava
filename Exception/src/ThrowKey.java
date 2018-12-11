
public class ThrowKey 
{
	public void demo()
	{
		try
		{
			System.out.println("inside demo");
			throw new NullPointerException("2nd throw");
			// you cant throw more than one explicitly error
			//throw new ArrayIndexOutOfBoundsException("2nd throw");
		}
		catch(NullPointerException e)
		//catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("null care");
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("array care");
		}
		finally
		{
			System.out.println("in finally");
		}
	}
	
	public static void main(String[] args) {
		ThrowKey obj=new ThrowKey();
		obj.demo();
				
	}
}
