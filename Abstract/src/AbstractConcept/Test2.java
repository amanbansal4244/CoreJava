package AbstractConcept;

abstract class Test2 {
	void method5()
	{
		System.out.println("5th");
	}
	
}

class Test4 extends Test2{
	public static void main(String[] args) {
		Test2 obj = new Test4();
		obj.method5();
	}
}
