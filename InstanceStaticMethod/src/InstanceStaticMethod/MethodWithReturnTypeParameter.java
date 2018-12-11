package InstanceStaticMethod;

public class MethodWithReturnTypeParameter {
	
	double sum1(double a , double b)
	{
//	System.out.println("Hey");
	double res=a+b;
	return res;
	}
}


class Aman
{
	public static void main(String[] args) {
		MethodWithReturnTypeParameter obj1=new  MethodWithReturnTypeParameter();
		double ww=obj1.sum1(3.4,56.6);
		System.out.println(ww);
	}
}
