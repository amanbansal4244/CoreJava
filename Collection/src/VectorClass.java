
import java.util.Vector;
public class VectorClass
{
	public void vectorOpertion()
	{
		//Creating vector object
		 Vector vc=new Vector();
		 //Default Capacity of vector is always 10
		 System.out.println("Capacity : "+vc.capacity());
		 
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
		 vc.add("sakshi");
		 
		 System.out.println(vc);
		 System.out.println("Size of vecor is : "+vc.size());
		 //when the size of vector cross defalut size(10) then capacity will be double
		 // and when cross 20 size then capacity will be again double means 40 and every time get doubled when crossed size
		 System.out.println("Capacity : "+vc.capacity());
		 
		 vc.remove(0);// removing by indexing
		 //vc.remove(40); // cant do that: ArrayIndexOutOfBoundsException
		 vc.remove("50");//removing by name 
		 vc.remove("hello"); 
		 vc.remove(4);
		 System.out.println(vc);
		 
		 // after remove the data size will be decreased but Capacity will not get decreased
		 System.out.println("New Size of vecor is : "+vc.size());
		 System.out.println("New Capacity : "+vc.capacity());
		 
		
	}
	public static void main(String[] args)
	{
		VectorClass obj=new VectorClass();
		obj.vectorOpertion();
	}
}
