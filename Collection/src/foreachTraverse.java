
import java.util.Vector;
public class foreachTraverse
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
		 
		 //Using foreach loop
		 for(Object obj : vc)
		 {
			 System.out.println(obj);
		 }
	}
	public static void main(String[] args)
	{
		foreachTraverse obj=new foreachTraverse();
		obj.vectorOpertion();
	}
}
