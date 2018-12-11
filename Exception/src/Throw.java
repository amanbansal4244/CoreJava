
public class Throw {
	
	static void demo()
	{
		try{
			System.out.println("inside demo");
			throw new NullPointerException("eeeeeee");
			}
		catch(NullPointerException ae){
			System.out.println(ae);			
		}
	}
}

class ee
{
	public static void main(String[] args) {
	Throw.demo();	
	}
}
