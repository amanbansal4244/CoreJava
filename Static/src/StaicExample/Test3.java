package StaicExample;

public class Test3 {
static{
	System.out.println("Static Block");
}
public void check()
{
	System.out.println("check");
}
public static void main(String[] args) {
	System.out.println("Main");
	Test3 obj=new Test3();
	obj.check();
}
}
