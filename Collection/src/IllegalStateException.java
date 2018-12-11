import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class IllegalStateException 
{
	public void display()
	{
		ArrayList al=new ArrayList();
		al.add("aman");
		al.add("anand");
		al.add("akshun");
		al.add("krishna");
		al.add("tyagi");
		
		System.out.println(al);
		
		Iterator it=al.iterator();
		
		while(it.hasNext())
		{
			 it.remove(); // IllegalStateException when you want remove before starting iterating the elements
			System.out.println(it.next());
		
		}
	}
	
	public static void main(String[] args)
	{
		IllegalStateException obj=new IllegalStateException();
		obj.display();
	}
}
