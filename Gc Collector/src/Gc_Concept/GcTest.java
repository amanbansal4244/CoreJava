// We have two types to destroy the object
// First : By Referencing the object 
// Second: BY  Nulling the object

// Finalize:  Finalize belongs to obj class that can exist in every class and it is called by gc() for each obj is being destroyed.
			// If we dont write finalize method , still System.gc() will surely destroyed the obj 
			// but in this case we will not get know whether obj is destroyed or not



package Gc_Concept;
public class GcTest {
	public GcTest() {
		System.out.println("obj created");
	}
	
	public void finalize()
	{
		System.out.println("obj Destroyed");
	}
	
	
	public static void main(String[] args) {
		GcTest obj1=new GcTest();
		GcTest obj2=new GcTest();
		GcTest obj3=new GcTest();
		GcTest obj4=new GcTest();
		
		//Below three lines obj4 is not get destroyed bcoz before obj4 pointing to someone else or nullify, obj5 is already pointed ot it.
		GcTest obj5=obj4;
		//obj4=obj2;
		obj4=null;
		
		
		
		
		obj1=obj2; 			// Referencing the object (obj1 will get destroyed)
		obj3=null; 			// Nulling the object
		obj1=null;  		// No obj will get destroyed bcoz obj is already destroyed
		
		System.gc();		//This is more request, not an order means gc will get call after some time not immediately
							//This line should exist after above three lines
							// invites garbage collector but does not force to call garbage collector
							// but if we write finalize, that means we have to write System.gc();
							// Sysytem.gc() is executed by thread
	
		//Runtime.gc();
	}
}