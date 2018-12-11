package Stream_udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _6Filtering {

	static List<Person> listOfPesron = new ArrayList<Person>();
	static {
		listOfPesron.add(new Person(1, "aman"));
		listOfPesron.add(new Person(14, "aman1"));
		listOfPesron.add(new Person(14, "aman1"));
		listOfPesron.add(new Person(21, "aman2"));
		listOfPesron.add(new Person(15, "aman3"));
		listOfPesron.add(new Person(2, "aman4"));
		listOfPesron.add(new Person(5, "aman5"));
		listOfPesron.add(new Person(6, "aman6"));
		listOfPesron.add(new Person(44, "aman7"));
		listOfPesron.add(new Person(9, "aman8"));
		listOfPesron.add(new Person(22, "aman9"));
		listOfPesron.add(new Person(99, "aman10"));
	}
	
	/*filter method of stream takes 'Predicate' as an argument.
	 * Predicate -> is an functional interface which was introduced in java 8
	 * Predicate has only one method 'test' which returns boolean value
	 * if it returns false that mean filter removes the value from the stream and 
	 * if it returns true, filter keeps the value in stream.
	*/
	
	
	//1. Find people aged less or equal to 18.
	//2. Then change the implementation to find first 5 people.
	public void declarativeApproach() {
		listOfPesron.stream()
			.filter(per -> per.getAge()<=18)
			.limit(5)
			.collect(Collectors.toSet()) // collecting as set
			.forEach(p -> System.out.println("Person Age: " +p.getAge()));
	}
	
	public static void main(String[] args) {
		new _6Filtering().declarativeApproach();
	}
}
