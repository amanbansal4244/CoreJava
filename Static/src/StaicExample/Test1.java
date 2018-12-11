package StaicExample;


public class Test1 {
	
	static int kk = 13;
	final int mm=9;
	static void total(int a, int b)
	{
		int x=a+b;
		final int k=-0;
		System.out.println(x);
	}
	static void aa()
	{
		
		System.out.println("aman");
	}
	
	static void total(int x, int f, int s){
		System.out.println("Overrided static method");
	}
	public void method()
	{
	//	static int y = 9;  // Illegal modifier for parameter y; only final is permitted
	}
}

class Aman
{
	public static void main(String[] args) {
		Test1 obj=new Test1();
		obj.aa();
		Test1.total(2, 4,5);
		
	}
}

