import java.util.Iterator;
import java.util.Vector;


public class iteratorInterface 
{
	int sum=0;
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
		 vc.add(12.34);
		 vc.add("hello");
		 vc.add(60);
		 vc.add(true);
		 
		 System.out.println(vc);
		 
		//travesing through IteratorInterface
		 Iterator it=vc.iterator();
		 

		 while(it.hasNext())
			{
				Object obj = it.next();
				//System.out.println("Class Name: "+obj.getClass()); // to get the whole class name
				//System.out.println("Class Name: "+obj.getClass().getSimpleName()); // to get the only class name means datatype of data
				
				String cname = obj.getClass().getSimpleName();
				
				
				if (cname.equals("Integer"))
				{
					sum = sum+Integer.parseInt(obj.toString());
					
				}
				else if (cname.equals("String"))
				{
					System.out.println("String : "+obj);
				}
				else if (cname.equals("Float"))
				{
					System.out.println("Float : "+obj);
				}
				else if (cname.equals("Boolean"))
				{   
					it.remove();
					System.out.println("Boolean :" +obj);
				}
			}
			
			System.out.println("Size : "+vc.size());
			System.out.println("Sum : "+sum);
				
		
	}
	public static void main(String[] args)
	{
		iteratorInterface obj=new iteratorInterface();
		obj.vectorOpertion();
	}
}
