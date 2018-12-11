/*Comparator vs Comparable
 
 Comparable:
 
 1. Sorting logic:
 		Sorting logic must be in same class whose objects are being sorted. Hence this is called natural ordering of objects
 		Implementation	Class whose objects to be sorted must implement this interface.e.g Country class needs to implement comparable to collection of country object by id
 2. Sorting method:
 
	 	int compareTo(Object o1)
		This method compares this object with o1 object and returns a integer.Its value has following meaning
		1. positive – this object is greater than o1
		2. zero – this object equals to o1
		3. negative – this object is less than o1	
	
 3. Calling method:	
	 	Collections.sort(List)
		Here objects will be sorted on the basis of CompareTo method and internally calls MErge Sort.
	
 4. Package:
 		Java.lang.Comparable
 
 5.	
     * Compare current person with specified person
     * return zero if person_id for both person is same 
     * return negative if current person_id is less than specified one
     * return positive if specified person_id is greater than specified one
      		
 
 Comparator:
 
 1.	Sorting logic:
	 	Sorting logic is in separate class. Hence we can write different sorting based on different attributes of objects to be sorted. E.g. Sorting using id,name etc.
		Class whose objects to be sorted do not need to implement this interface.Some other class can implement this interface. E.g.-CountrySortByIdComparator class can implement Comparator interface to sort collection of country object by id

2.  Sorting method:

		int compare(Object o1,Object o2)
		This method compares o1 and o2 objects. and returns a integer.Its value has following meaning.
		1. positive – o1 is greater than o2
		2. zero – o1 equals to o2
		3. negative – o1 is less than o1
 3. Calling method:
		Collections.sort(List, Comparator)
		Here objects will be sorted on the basis of Compare method in Comparator

 4. Package:
 		Java.util.Comparator
 	
 5. public class SortByPerson_ID implements Comparator{

    public int compare(Object o1, Object o2) {
        Person p1 = (Person) o;
        Person p2 = (Person) o; 
        return p1.getPersonId() - p2.getPersonId();
    }
}

 6. 
     * Compare current person with specified person
     * return zero if person_id for both person is same 
     * return negative if current person_id is less than specified one
     * return positive if specified person_id is greater than specified one


*/