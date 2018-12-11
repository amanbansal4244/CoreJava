
public class throwUserDefined extends Exception 
{
	 static int bal[]={1000,2000,300,400};
	
	throwUserDefined()
	{
		System.out.println("this is my own exception");
	}
	
	public static void main(String[] args)
	{
		try
		{
			for(int i=0;i<4;i++)
			{
				System.out.println("balance : "+bal[i]);
				if(bal[i]<400)
				{
					throwUserDefined my = new throwUserDefined();
					throw my;
				}		
			}
	
		}
		catch(throwUserDefined e)
		{
			System.out.println("own excep. handled");
		}
		
		
		finally
		{
			System.out.println("in finally");
		}
	}	
}

 