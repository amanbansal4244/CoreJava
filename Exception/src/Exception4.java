

public class Exception4 {

	void checkExcp(String name,int num)
	{
		System.out.println("start");
		
		try {
			//System.out.println(20/num);
			System.out.println(name.charAt(9));
		} catch (ArithmeticException e) {
			
			e.printStackTrace();
		}
		/*catch(NullPointerException e1)
		{
			System.out.println("something is null");
		}*/
		finally{
			System.out.println("finally");
		}
		
		System.out.println("shdh"); // this line will not execute if error are not being handled
	}
	public static void main(String[] args) {
		Exception4 ex=new Exception4();
		ex.checkExcp(null,0);
	}
}
