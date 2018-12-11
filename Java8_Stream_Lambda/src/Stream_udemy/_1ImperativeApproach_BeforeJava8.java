package Stream_udemy;

import java.util.ArrayList;
import java.util.List;

public class _1ImperativeApproach_BeforeJava8 {

	static List<Person> listOfPesron = new ArrayList<Person>();
	static {
		listOfPesron.add(new Person(1, "aman"));
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
	
	//1. Find people aged less or equal to 18.
	//2. Then change the implementation to find first 5 people.
	public void imperativeApproach() {
		 int counter =0;
		final int limit = 5;
		List<Person> youngPeople = new ArrayList<Person>();
		
		for(Person person : listOfPesron) {
			if(person.getAge() <= 18) {
				youngPeople.add(person);
				counter++;
				if(counter==limit) {
					break;
				}
				
			}
		}
		
		for(Person young : youngPeople) {
			System.out.println(young.getAge());
		}
	}
	
	public static void main(String[] args) {
		new _1ImperativeApproach_BeforeJava8().imperativeApproach();
	}
}
