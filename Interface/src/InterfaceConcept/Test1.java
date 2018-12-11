package InterfaceConcept;

interface Test1 {
	/*Test1(){   // Interface class can't have the constructor
		
	}*/
	int x=10; // by default its varible are Public, Static and Final statfinally
	// int y; // We cant write without initialized bcoz varible is final
	void method();  // None of the methods in interface can be private, protected or static. ,, only abstract and public are permitted/
	void method1();
}

interface Test2{
	int x=20;
	void method3();
}

class Che implements Test1, Test2{
	
	
	public void method()
	{
		System.out.println("1st");
	}
	public void method1()
	{
		System.out.println("2nd");
	}
	public void method3()
	{
		System.out.println("3rd");
	}
	
	public void display(){
		System.out.println("X varible in Test1" + " "+ Test1.x );
		System.out.println("X varible in Test2" + " " +Test2.x );
	}
}

class Check{
	public static void main(String[] args) {
		Che obj=new Che();
		obj.method();
		obj.method1();
		obj.method3();
		obj.display();
		Test1 obj1=new Che(); // making reference of Test1 
		obj1.method();
	//	Test2 obj2 = obj;
		//Test1.x;
		
		System.out.println("X varible in Test1" + " "+ Test1.x );
		System.out.println("X varible in Test2" + " " +Test2.x );
		
	}
}

