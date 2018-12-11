package CommunicateTwoUnknownClassesUsingInterface;

public class MainClass {
	public static void main(String[] args) {
		CommunicateClass cs=new CommunicateClass();
		
		Interface1 i; 			   // Creating Reference of Interface
		i=new DerivedClass1();    //Upcasting bcoz we cant call any method of any class untill we create memory of that class
		cs.call(i); 			 // Here, we are calling call method of CommunicateClass by passing reference of interface.
		
		//i.method1();
		
		// Above three lines we can do by below hidden one line
		//cs.call(new DerivedClass1());
	}
}
