package AbstractConcept;

abstract class Test1 {
	Test1()  // Abstract class can have the constructor
	{
		
	}
	public void method()
	{
		System.out.println("1st");
	}
	abstract protected void method2();
	abstract void method3();
	abstract void method4();
}

abstract class Fun extends Test1{
	protected void method2()
	{
		System.out.println("2nd");
	}
	void method3()
	{
		System.out.println("3rd");
	}
}

class Fun1 extends Fun{
	void method4()
	{
		System.out.println("4th");
	}
}

class Fun2{
	public static void main(String[] args) {
		/*Fun1 obj=new Fun1();
		obj.method2();
		obj.method();
		obj.method3();
		obj.method4();*/
		
		Test1 ref=new Fun1();
		ref.method();
		ref.method4();
		
	}
}
