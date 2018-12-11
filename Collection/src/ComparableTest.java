import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class ComparableTest  implements Comparable<ComparableTest>{   // If u dont want to pass any thing in Comparable then you have to implements by this
// public class Employee  implements Comparable{                      			// 	   public class Employee  implements Comparable{
//public class ComparableTest  implements Comparable<Object>{		  // OR :  public class ComparableTest  implements Comparable<Object>{
																	  //And have to pass Object class obj in compareTo() Method
																	  // Like in method 1
	private String name;
	private int age;
	private int sal;
	 
	   
public ComparableTest(String n,int a,int s)
	{
	     name = n;
	     age = a;
	     sal=s;
	}

		public String getName() {
		    return name;
		}
		
		public int getAge() {
		    return age;
		}
		
		public int getSal() {
		    return sal;
		}

		// Method 1:
		//Below Hidden code is also right
		/*
		 public int compareTo(Object o) {
		    	if(this.age==((ComparableTest)o).age){
		    		return 0;}
		    	else if((this.age) > ((ComparableTest)o).age)
		    		return 1;
		    	else
		    		return -1;
		    	
		    }  */
		
		// Method 2:
		//Below Hidden code is also right
		
	   /* public int compareTo(ComparableTest o) {
	    		if(this.age==(o.age))
	    		{
	    			System.out.println(this.age);
	    			System.out.println(this.age);
	    		return 0;
	    		}
	    		else if((this.age) > (o.age))
	    		{
	    			System.out.println(this.age);
	    			System.out.println(o.age);
	    		return 1;
	    		}
	    	else
	    	{
    			System.out.println(this.age);
    			System.out.println(o.age);
    		return -1;
	    	}
	    	
	    }  */
		
		//Method 3:
		public int compareTo(ComparableTest o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}
	
		public static void main(String[] args) {
			ArrayList<ComparableTest> people = new ArrayList<ComparableTest>();
	  
	people.add(new ComparableTest("div",56,2300));
	people.add(new ComparableTest("Aman ",23,5000));
	people.add(new ComparableTest("TOM ",20,4300));
	people.add(new ComparableTest("Devesh",15,4800));
	people.add(new ComparableTest("NEHA",60,4800));
	
	Collections.synchronizedList(people);  // By default ArrayList is not Synchronized , So this line will make ArrayList Synchronized.
	//Collections.sort(people); 
	
	System.out.println("Before Sort");
	            for (int i = 0; i < people.size(); i++) {
	            	ComparableTest ct=(ComparableTest) people.get(i);
	                System.out.println("Name: "+ct.getName()+"||"+"Age: "+ct.getAge()+"||"+"Salary: "+ct.getSal());
	            }
	            
	 Collections.sort(people);
	 
	 System.out.println("After Sort");
	            for (int i = 0; i < people.size(); i++) {

	            	ComparableTest ct=(ComparableTest) people.get(i);
	
	            	System.out.println("Name: "+ct.getName()+"||"+"Age: "+ct.getAge()+"||"+"Salary: "+ct.getSal());

	            }

}}
