import java.util.*;

public class treeSet 
{
	public void display()
	{
			
		TreeSet hs=new TreeSet();

		//adding inBuilt object
		//hs.add(null);
		hs.add("G");
		hs.add("M");
		hs.add("P");
		hs.add("U");
		hs.add("C");
		hs.add("B"); 
		hs.add("B");//we can add duplicate elements any no times but will print only once
		//hs.add(null); // Null Pointer Exception
		//hs.add(null);
		//hs.add(1); // we cant add if we added once another datatype that means TreeSet is Generic Class
						// java.lang.ClassCastException
		
		System.out.println(hs); // print likes a Sorted(Ascending) Ordered list
		
		SortedSet ss=hs.subSet("M","U"); // Traverse including m and all the elements b/w M & U and Excluding U
		//SortedSet ss=hs.subSet("U","M"); //IllegalArgumentException
		System.out.println(ss);
	
		System.out.println(hs.subSet("P","U")); // we can do also like this without using SortedSet Interface
		
		ss=hs.headSet("M"); // Traverse all the elements before M and Excluding M
		System.out.println(ss);
		
		System.out.println(hs.headSet("P")); // we can do also like this without using SortedSet Interface
		
		ss=hs.tailSet("M"); // Traverse all the elements After M and Including M
		System.out.println(ss);
		
		System.out.println(hs.tailSet("P")); // we can do also like this without using SortedSet Interface
		
		
		
		
		
		
		System.out.println(hs.size());
		

	}
	public static void main(String[] args)
	{
		treeSet obj=new treeSet();
		obj.display();
	}

	
}
