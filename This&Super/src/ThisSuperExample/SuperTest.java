package ThisSuperExample;

public class SuperTest {

	SuperTest()
	{
		System.out.println("super");
	}
}

class SuperTest1 extends SuperTest{
	 SuperTest1(int a) {
		// System.out.println("ss");
		 super();
		// this(();
		 System.out.println("Derived");
	}
}

class Ex
{
	public static void main(String[] args) {
		SuperTest1 obj = new SuperTest1(4);
	}
}