package ThisSuperExample;

public class Super {

	int a=10;
	
	public Super() {
		// TODO Auto-generated constructor stub
	
	System.out.println("Base Cons");
	}
	
	public void show()
	{
		System.out.println(a);
	}
}

class Super1 extends Super{
	int a = 20;
	
	public Super1() {
		// TODO Auto-generated constructor stub
	
	System.out.println("Derived Cons");
	}
	public void show()
	{	System.out.println(a);
		super.show();
		System.out.println(a);
	}
	
	public void method(){
		this.show();
		super.show();
		
		//this();    // cant write in method
 		//super();   // cant write in method
	}
}

class main{
	public static void main(String[] args) {
		Super1 obj = new Super1();
	//	obj.show();
		obj.method();
	}
}
