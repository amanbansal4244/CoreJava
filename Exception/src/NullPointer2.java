
public class NullPointer2
{	
	int x=12;
	public void show(int a)
	{
		x=x+a;
		System.out.println("value of x: "+x);
	}
	
	public static void main(String[] args)
	{
	NullPointer2 obj=new NullPointer2();
	
	obj=null;
	obj.show(20);
	
	}
	
}
