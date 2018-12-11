//instanceOf is used to test if an obj belongs to an class or not.
//Note that instance means object.
//This operator can also be used to check if an object belongs to an interface or not.

/*		If (object1 instanceof Class1) {
		   // do something
		} else if (object1 instanceof Class2) {
		   // do something different
		}*/

//instanceof is a useful tool when you've got a collection of objects and you're not sure what they are. 

package Testing;

public class InstanceOfOperator {
	
	public static void main(String[] args) {
		InstanceOfOperator obj=new InstanceOfOperator();
		
		if (obj instanceof InstanceOfOperator) {
			System.out.println("true");
		}
		else
		{
				System.out.println("false");
		}
			
		}
	}
