
import java.util.Enumeration;
import java.util.Stack;
import java.util.Vector;
public class stackList 
{
	public void display()
	{
		Stack al=new Stack();
		al.push("aman");
		al.push("anand");
		al.push("akshun");
		al.push("bansal");
		
		System.out.println(al);
		
		
		System.out.println(al.peek()); // Without removing it will print top of the stack
		System.out.println(al);
		System.out.println(al.pop());
		System.out.println(al);
		
		Enumeration em=al.elements();
		while(em.hasMoreElements())
		{
			System.out.println(em.nextElement());
		}
	}
	
	public static void main(String[] args)
	{
		stackList obj=new stackList();
		obj.display();
	}
}
