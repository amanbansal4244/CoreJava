package Comparision;

public class stringConcept3
{
	String s1= new String("aman");
	String s2=new String("aman");
	
	public void show()
	{
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		if(s1==s2)
		{
			System.out.println("equal");
		}
		else
		{
			System.out.println("not equal");
		}
	}
	
	public void display()
	{
		if(s1.equals(s2))
		{
			System.out.println("equal");
		}
		else
		{
			System.out.println("not equal");
		}
	}
	public static void main(String[] args)
	{
		stringConcept3 obj= new stringConcept3();
		obj.show();
		obj.display();
	}
}