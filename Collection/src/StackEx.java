import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;


public class StackEx {
	public static void main(String[] args) {
		Stack<String> obj=new Stack<String>();
		obj.push("aman");
		obj.push("aman");
		obj.push("hiii");
		obj.push(null);
		obj.push(null);
		obj.push(null);
		obj.push(null);
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		
		Stack obj1 = new Stack();
		obj1.push(3);
		obj.push("bansal");
		
		Iterator it = obj.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		ListIterator li = obj1.listIterator();
		while(li.hasNext()){
			System.out.println(li.next());
		}
		
		Enumeration e=obj1.elements();
		while(e.hasMoreElements()){
			System.out.println(e.nextElement());
		}
	}
}
