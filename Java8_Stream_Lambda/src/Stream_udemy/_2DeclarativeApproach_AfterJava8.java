package Stream_udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _2DeclarativeApproach_AfterJava8 {

	static List<Person> listOfPesron = new ArrayList<Person>();
	static {
		listOfPesron.add(new Person(1, "aman"));
		listOfPesron.add(new Person(14, "aman1"));
		listOfPesron.add(new Person(21, "aman2"));
		//listOfPesron.add(new Person(15, "aman3"));
		listOfPesron.add(new Person(2, "aman4"));
		listOfPesron.add(new Person(5, "aman5"));
		listOfPesron.add(new Person(5, "aman33"));
		listOfPesron.add(new Person(6, "aman6"));
		listOfPesron.add(new Person(44, "aman7"));
		listOfPesron.add(new Person(9, "aman8"));
		listOfPesron.add(new Person(22, "aman9"));
		listOfPesron.add(new Person(99, "aman10"));
	}
	
	//1. Find people aged less or equal to 18.
	//2. Then change the implementation to find first 5 people.
	public void declarativeApproach() {
		listOfPesron.stream()
			.filter(per -> per.getAge()<=18)
			.limit(5)
			/*Collectors is a final class that extends Object class. It provides reduction operations, such as accumulating elements 
			 * into collections, summarizing elements according to various criteria, etc.*/
			.collect(Collectors.toSet())//collecting into set.
			.forEach(p -> System.out.println("Person Age: " +p.getAge()));
	}
	
	public static void main(String[] args) {
		new _2DeclarativeApproach_AfterJava8().declarativeApproach();
	}
}
