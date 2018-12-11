package Upcasting;

public class Two extends One {
	
	public void method1()
	{
		System.out.println("Overridden Method");
	}
	public void method2(){
		System.out.println("Two : method2");
	}
	
	public static void  method()
	{
		System.out.println("Overridden static Method ");
	}
}
