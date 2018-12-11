package Testing;

import javax.swing.text.StyledEditorKit.BoldAction;

public class InstanceOfOperator_For_String_Class {

	
	public void method(){	
	String s="Aman Bansal"; // Here, String s is treated like a obj bcoz memory has been allocated to it.
	if (s instanceof String) {
		String obj = (String) s;
		System.out.println("true");
	}
		else
			System.out.println("false");
	}
	
	//However, applying instanceof on a null reference variable/expression returns false.
	public void method1(){	
		String s=null;  // Here, String s is a only a varible of String type bcoz no memory is allocated to it.  
		if (s instanceof String) {
			String obj2 = (String) s;
			System.out.println("true");
		}
			else
				System.out.println("false");
		}
		
	
	public static void main(String[] args) {
		InstanceOfOperator_For_String_Class  obj1=new InstanceOfOperator_For_String_Class();
		obj1.method();
		obj1.method1();
	}
}
