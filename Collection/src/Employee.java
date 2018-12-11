
/*Prog: Sort employee data according to age

List of objects that implement this interface can be sorted automatically by sort method of the list interface. 
This interface has compareTo() method that is used by the sort() method of the list.

In this code Employee class is implementing Comparable interface and have method compareTO().
This class first makes a list of objects of type Employee and call sort method of java.util.Collections,
which internally uses compareTo() method of Employee class and sort the list accordingly.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Employee  implements Comparable{
	private String name;
	private int age;
	private int sal;
	 
	   
public Employee(String n,int a,int s)
	{
	     name = n;
	     age = a;
	     sal=s;
	}
public String toString() {
    return "Name " + name + "\n" + "Age " + age + "\n" + "Salary" + sal;
}
	    public int compareTo(Object o) {
	    	if(this.age==((Employee)o).age){
	    		return 0;}
	    	else if((this.age) > ((Employee)o).age)
	    		return 1;
	    	else
	    		return -1;
	    	
	    }  
	
		public static void main(String[] args) {
			ArrayList<Employee> people = new ArrayList<Employee>();
	  
	people.add(new Employee("div",10,2300));
	people.add(new Employee("Aman ",5,5000));
	people.add(new Employee("TOM ",20,4300));
	people.add(new Employee("NEHA",60,4800));
	
	Collections.sort(people);
    Iterator itr = people.iterator();

    while(itr.hasNext()){
        Object element = itr.next();
        System.out.println(element + "\n");
        
    }
}
}