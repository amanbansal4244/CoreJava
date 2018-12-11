import java.util.ListIterator;
import java.util.Vector;

import java.util.*;
public class listIterator
{
	
		public void vectoroper()
		{
			
			
			
			Vector vectobj1=new Vector();
			
			
			
			vectobj1.add(20);
			vectobj1.add(30);
			vectobj1.add(40);
			vectobj1.add(50);
			
			ListIterator li=vectobj1.listIterator();
			while(li.hasNext())
			{
				System.out.println(li.next());
				
			}
			//System.out.println(li.getClass());
			System.out.println(li.getClass().getSimpleName());
			
			while(li.hasPrevious())
			{
				Object obj = li.previous();
						
				
				li.remove();
				System.out.println(obj);
			}
			

			System.out.println(vectobj1);
		}
		
		
		public static void main(String[] args)
		{
			listIterator vc=new listIterator();
			vc.vectoroper();

			
		}
}
