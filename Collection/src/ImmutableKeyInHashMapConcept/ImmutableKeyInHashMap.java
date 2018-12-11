package ImmutableKeyInHashMapConcept;

import java.util.HashMap;

public class ImmutableKeyInHashMap {

	public static void main(String[] args) {
		Employee e1 = new Employee("Aman"); //assume hashCode=1234
		HashMap<Employee, String> hm = new HashMap<>();
		hm.put(e1, "emp1");
		
		System.out.println("First Time :"+ hm.get(e1));
		
		// Below code will change the key hashCode() and equals()
		// but it's location is not changed.
		e1.setName("Rahul"); //assume new hashCode=7890
		
		System.out.println("Second Time :"+hm.get(e1)); // will give null because 'get' method internally checks 'equals' method.
		
		//below will return null, because HashMap will try to look for key
		//in the same index as it was stored but since key is mutated,
		//there will be no match and it will return null.
		System.out.println("Third  Time :"+hm.get(new Employee("Aman")));// will give null because 'get' method internally checks 'equals' method.
		

	}
}
