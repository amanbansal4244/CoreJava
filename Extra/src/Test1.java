
public class Test1 {
	static void total(int a, int b)
	{
		int x=a+b;
		System.out.println(x);
	}
	static void aa()
	{
		System.out.println("aman bansal");
	}
}

class Aman
{
	public static void main(String[] args) {
		Test1 obj=new Test1();
		obj.aa();
		obj.total(4, 5);
		//Test1.total(2, 4);
	}
}


