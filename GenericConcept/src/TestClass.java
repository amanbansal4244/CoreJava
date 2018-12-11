import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class TestClass{ 

	public static void main(String[] args) {
		 
		X<TestInterface> obj1 = new X<TestInterface>(); // allowed
		X<XImplementation> obj2 = new X<XImplementation>(); // allowed
		
		System.out.println((String)null);
	}
}
