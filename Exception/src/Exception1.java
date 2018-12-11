
public class Exception1 {
	public static void main(String[] args) {
		try
		{
			System.out.println("file open");
		int n=0;
	
		int b[]={10,20,30};
		b[50]=80;
		//int a=30/n;
		//System.out.println(a);
		
		}
		catch(ArithmeticException ae)
		{
			System.out.println(ae);
		}
		catch(ArrayIndexOutOfBoundsException aie)
		{
			aie.printStackTrace();
			System.out.println(aie);
		}
		/*catch(Exception e)
		{
			
		}*/
		finally
		{
			System.out.println("finally");
		}
		
	}
}

