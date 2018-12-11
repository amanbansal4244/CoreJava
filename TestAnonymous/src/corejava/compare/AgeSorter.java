package corejava.compare;

import java.util.Comparator;

public class AgeSorter implements Comparator<Employee>{
	 @Override
	    public int compare(Employee o1, Employee o2) {
		 	return o1.getAge() - o2.getAge();
		 	//return o1.getAge().compareTo(o2.getAge());   // Note: Cant invoke compareTo(int) on the primitive type int
	 }
	 
	 //Note:  For extra Knowledge: Below hidden code is also right
	 
	 /*public class AgeSorter implements Comparator{

		    public int compare(Object o1, Object o2) {
		        Employee p1 = (Employee) o1;
		        Employee p2 = (Employee) o2; 
		       return p1.getAge() - (p2.getAge());
		    }*/
		}
