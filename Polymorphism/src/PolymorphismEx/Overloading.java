package PolymorphismEx;

public class Overloading {
	public void method(int a , int b)
	{
		int c=a+b;
		System.out.println("First" +c);
	}
	public void method(int a, int b, int d)
	{
		int e=a+b+d;
		System.out.println("second"+e);
	}
	public void method(double a, double b, double d)
	{
		double e=a+b+d;
		System.out.println("third"+e);
		//return e;
	}

}

class Che
{
	public static void main(String[] args) {
		Overloading obj = new Overloading();
		obj.method(2, 3);
		obj.method(3, 5, 6);
		obj.method(3.2, 4.5, 6.4);
	}
}
