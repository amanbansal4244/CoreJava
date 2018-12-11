package ThisSuperExample;

public class TestThis {
	int b;
TestThis()
{
	this(3);
	System.out.println("Default Cons");
	this.al();
}
TestThis(int a)
{
	 b=a;
	System.out.println(b);
}

static public void al()
{
	System.out.println("method aa");
}
}

class Check{
	public static void main(String[] args) {
		TestThis obj=new TestThis();
	}
}
