import java.util.LinkedList;
import java.util.Vector;
public class linkedList 
{
	public void display()
	{
		LinkedList ln=new LinkedList();
		
		ln.add("Goa");
		ln.add("Mumbai");
		ln.add("Pune");
		ln.add("UP");
		ln.add(null);
		ln.add("Chennai");
		ln.add("Bihar");
		ln.add(null);
		ln.add("Bihar");
		
		//adding at indexing
				ln.add(2,"Haryana");
		//adding at first
				ln.addFirst("Bangalore");
		//adding at last
				ln.addLast("Gurgaon");
		
		//dispaly the elements in the linked list
				System.out.println("Linked List: "+ln);
		
		//removing at beginning
				ln.removeFirst();
		//removing at last
				ln.removeLast();
		//removing at indexing
				ln.remove(2);
		
		//dispaly the elements in the linked list
				System.out.println("Linked List: "+ln);
		
		//to replace the element at specified position
				ln.set(3,"Kerala");
		
		//to get the first element
				System.out.println(ln.getFirst());
		
		//to get the last element
				System.out.println(ln.getLast());
		
		//for size
				System.out.println(ln.size());
		
		//returns the index of first occurence of elements if exist otherwise -1
		System.out.println(ln.indexOf("Bihar"));
		
		//returns the index of last occurence of elements if exist otherwise -1
				System.out.println(ln.lastIndexOf("Bihar"));
				
		//convert the linked list objects to array list objects class type 
				Object obj[]=ln.toArray(); //have to take this to store to an array elemnets
				for(Object ob :obj)
				{
					System.out.println(ob);
				}
		// to add the last(tail)
				System.out.println(ln.offer("aman")); // its also returns boolean value
				System.out.println(ln.offerFirst("anand")); // to add first and also returns boolean value
				System.out.println(ln.offerLast("krishna"));// to add last and also returns boolean value
				
		//dispaly the elements in the linked list
				System.out.println("Linked List: "+ln);
	}
	public static void main(String[] args)
	{
		linkedList obj=new linkedList();
		obj.display();
	}
}
