package corejava.compare;

import java.util.Comparator;

public class FirstNameSorter implements Comparator{
	
	 @Override
	 public int compare(Object o1, Object o2) {
		 Employee e1 = (Employee) o1; 
		 Employee e2 = (Employee) o2;
		 return e1.getFirstName().compareTo(e2.getFirstName());
	 }
	

}
