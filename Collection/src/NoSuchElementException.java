import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class NoSuchElementException 
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
			
			System.out.println(it.next());
			// Below two line will give NoSuchElementException
			it.remove();
			System.out.println(it.next());	
	
		}
	}
	
	public static void main(String[] args)
	{
		NoSuchElementException obj=new NoSuchElementException();
		obj.display();
	}
}
