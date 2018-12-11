package Comparision;

public class stringConcept
{
	String s1="aman";
	String s2="aman";
	
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
	public static void main(String[] args)
	{
		stringConcept obj= new stringConcept();
		obj.show();
	}
}