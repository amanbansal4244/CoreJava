package InterfaceConcept;

interface Test4 {
	void method();
}

interface Test5 extends Test4{
	void method1();
}

class C implements Test5{
	public void method(){
		System.out.println("hi");
	}
	public void method1(){
		System.out.println("hey");
	}
}

class D{
	public static void main(String[] args) {
		C obj = new C();
		obj.method();
		obj.method1();
	}
}