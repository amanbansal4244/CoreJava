import java.util.Enumeration;
import java.util.Vector;


public class enumerationInterface
{
	public void vectorOpertion()
	{
		//Creating vector object
		 Vector vc=new Vector();
		 		 
		//adding built-in objects
		 vc.add(10); //autoBoxing
		 vc.add(20);
		 vc.add(30);
		 vc.add(40);
		 vc.add("50");
		 vc.add("aman");
		 vc.add("bansal");
		 System.out.println(vc);
		 
		 Enumeration em=vc.elements();
		 while(em.hasMoreElements())
		 {
			 System.out.println(em.nextElement());
		 }
		 
		/* //Using foreach loop
		 for(Object obj : vc)
		 {
			 System.out.println(obj);
		 }*/
	}
	public static void main(String[] args)
	{
		enumerationInterface obj=new enumerationInterface();
		obj.vectorOpertion();
	}
}
