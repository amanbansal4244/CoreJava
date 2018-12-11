package StaicExample;

public class Test2 extends Test1 {
	static int x=10;
 

static void access()
{
	System.out.println(x);
}



	public static void main(String[] args) {
		Test2.access();
		System.out.println(Test1.kk);
		
		
	
}
}