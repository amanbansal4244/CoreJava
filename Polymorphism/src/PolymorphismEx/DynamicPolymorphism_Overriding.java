package PolymorphismEx;


public class DynamicPolymorphism_Overriding {
	protected  void method(int a , int b)
	{
		int c=a+b;
		System.out.println("Base"+c);
		//return c;
		//System.out.println("First" + c);
	}
}

class Overriding11 extends DynamicPolymorphism_Overriding
{
	protected  void method(int a , int b)
	{
		int c=a+b;
		System.out.println("derived"+c);
		//return c;
		//System.out.println("Second" + c);
	}
}
class CheckTest1
{
	public  static void main(String[] args) {
		/*Overriding1 obj = new Overriding1();
		Overriding obj1=new Overriding();
		int d=obj.method(22, 63);
		System.out.println(d);
		int r=obj1.method(31, 3);
		System.out.println(r);*/
		
		DynamicPolymorphism_Overriding o = new DynamicPolymorphism_Overriding(); //upcasting
		Overriding11 on = new Overriding11();
		on.method(3, 3);
		o.method(4, 5);  // if method data type is not static then derived class method will get called, bcoz it will be late binding and decide 
						//at run time not compile time
						 
						// if method data type is  static then base class method will get called, bcoz it will be early binding and decide 
						//at compile time not run time
		  
		

	}
}