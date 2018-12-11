package InstanceStaticMethod;

public class MethodWithReturnType {
	double a,b;
	MethodWithReturnType() {
	a=53;
	b=70.4;	
	}
	double sum()
	{
	System.out.println("Hey");
	double res=a+b;
	return res;
	}
}


class Methods
{
	public static void main(String[] args) {
		MethodWithReturnType obj=new  MethodWithReturnType();
		double x=obj.sum();
		System.out.println(x);
	}
}