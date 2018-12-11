import java.util.*;

class Test
{
	int a,b;
	Test(int a,int b)
	{
		this.a=a;
		this.b=b;
	}
	
	public String toString()
	{
		return a+","+b;
	}
}
public class hashSet 
{
	public void hash()
	{
		Test t=new Test(15,10);
		
		HashSet hs=new HashSet();

		//adding inBuilt object
		hs.add("Goa");
		hs.add("Mumbai");
		hs.add("Pune");
		hs.add("UP");
		hs.add("Chennai");
		hs.add("Bihar"); 
		hs.add("Bihar");//we can add duplicate elements any no times but will print only once
		hs.add(null); // we add null any no of times but print only one time only at starting of list
		hs.add(null);
		hs.add(1);
		hs.add(5);
		
		//adding user defined object
		hs.add(new Test(55,60));
		hs.add(t);
		System.out.println(hs); // print likes a Unordered list
		System.out.println(hs.size());
		

	}
	public static void main(String[] args)
	{
		hashSet obj=new hashSet();
		obj.hash();
	}

	
}
