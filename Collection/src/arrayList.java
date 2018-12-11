import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import java.util.Collections;

public class arrayList
{
	public void display()
	{
		ArrayList al=new ArrayList();
		al.add("aman");
		al.add(2);
		al.add("akshun");
		//Iterator it=al.iterator();
		al.add("2");
		al.add("akshun");
		al.add("akshun");
		al.add("tyagi");
		al.add("krishna");
;		
		al.add(null); 
		al.add("2.0");
		System.out.println(al);
		
		
		for(Object obj : al)
		 {
			 System.out.println(al.get(0));
		 }
		
		Collections.synchronizedList(al); // to convert array list to Thread Safe
		
		//System.out.println(al.size());

		  // Enumeration em=al.elements();
		
		Iterator it=al.iterator();
	
		while(it.hasNext())
		{
			
			System.out.println(it.next());
			/*
			Object o = it.next();
				
			if(o.equals("krishna"))
				it.remove();
			
			else
				System.out.println("Printed element: "+o);*/	
				
		}
		//it.remove();
		System.out.println(al.size());
	}
	
	public static void main(String[] args)
	{
		arrayList obj=new arrayList();
		obj.display();
	}
}
