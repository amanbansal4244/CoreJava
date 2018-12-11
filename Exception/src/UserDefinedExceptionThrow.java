
public class UserDefinedExceptionThrow extends Exception {
	private static int bal[]={1000,1200,100};
	public UserDefinedExceptionThrow() {
		// TODO Auto-generated constructor stub
	}
	UserDefinedExceptionThrow(String str)
	{
		super(str);
	}
	
	public static void main(String[] args) {
		try{
			for(int i=0;i<3;i++)
			{
				System.out.println(bal[i]);
			if(bal[i]<1000)
			{
			throw new UserDefinedExceptionThrow("Ur bal is less than 1000");
			/*UserDefinedExceptionThrow ud=new UserDefinedExceptionThrow("Ur bal is less than 1000");
			throw ud;*/
		}
			}
		}
		catch(UserDefinedExceptionThrow ud)
		{
			ud.printStackTrace();
		}
	}
}

