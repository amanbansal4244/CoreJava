package PolymorphismEx;

public class StaticPolymorphism_Overriding {
	protected static void method(int a , int b)
	{
		int c=a+b;
		System.out.println("Base"+c);
		//return c;
		//System.out.println("First" + c);
	}
}

class Overriding1 extends StaticPolymorphism_Overriding
{
	//@Override  // we can't override the static method.
	protected static void method(int a , int b)
	{
		int c=a+b;
		System.out.println("derived"+c);
		//return c;
		//System.out.println("Second" + c);
	}
}
class CheckTest
{
	public static void main(String[] args) {
		/*Overriding1 obj = new Overriding1();
		Overriding obj1=new Overriding();
		int d=obj.method(22, 63);
		System.out.println(d);
		int r=obj1.method(31, 3);
		System.out.println(r);*/
		
		StaticPolymorphism_Overriding o = new Overriding1(); //upcasting
		Overriding1 on = new Overriding1();
		on.method(3, 3);
		o.method(4, 5);  // if method data type is not static then derived class method will get called, bcoz it will be late binding and decide 
						//at run time not compile time
						 
						// if method data type is  static then base class method will get called, bcoz it will be early binding and decide 
						//at compile time not run time
		  
		

	}
}