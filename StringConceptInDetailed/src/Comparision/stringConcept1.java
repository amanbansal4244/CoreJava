package Comparision;

public class stringConcept1
{
	String s1="aman";
	String s2="bansal";
	
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
		stringConcept1 obj= new stringConcept1();
		obj.show();
		obj.display();
	}
}