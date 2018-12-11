package LambdaBasicExcercisePackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SolutionUsingJava8WithUsingJavaOOBInterface {


	public static void main(String[] args) {

		java.util.List<Person> people = Arrays.asList(
				new Person("aman", "bansal", 26),
				new Person("aman1", "bansal1", 26), 
				new Person("aman2", "Walia", 27), 
				new Person("aman3", "Garg", 28)

		);

		// Problem 1 : Sort list by last names.
		//lambda expression
		//Comparator comparator = ( o1,  o2) -> {return ((Person) o1).getLastName().compareTo(((Person) o2).getLastName());}; // no need of return keyword and curly braces.
		
		Collections.sort(people, ( o1,  o2) -> ((Person) o1).getLastName().compareTo(((Person) o2).getLastName()));

		// Problem 2 : Create a method which prints all name in the list
		printAll(people);
		
		// Problem 3: Create a method that prints all have people last name beginning with b and G
			
		System.out.println("prints all have people last name beginning with b" );
		printAllConditionaly(people, (Person p) -> p.getLastName().startsWith("b"));
		
		
		//Problem 4: Create a method that prints all have people last name beginning with G
		
		System.out.println("prints all have people last name beginning with G" );
		printAllConditionaly(people, (Person p) -> p.getLastName().startsWith("G"), p ->System.out.println( p));
	}

	private static void printAllConditionaly(java.util.List<Person> people , Predicate<Person> predicate) {  // Using java OOB interface 'Predicate' instead of creating brand new interface.
		
		for (Person p : people) {
			if (predicate.test(p)) {
				System.out.println( p); // to print this : toSting of 'Person' class method would be used 
			}
		}
	}
	private static void printAllConditionaly(java.util.List<Person> people , Predicate<Person> predicate, Consumer<Person> consumer) {  // Using java OOB interface 'Predicate' and 'consumer' instead of creating brand new interface.
			
			for (Person p : people) {
				if (predicate.test(p)) {
					consumer.accept(p); // Using 'Consumer' interface to print instead of every time using syso.
				}
			}
		
	}

	private static void printAll(java.util.List<Person> people) {
		System.out.println("prints all have people ");
		for(Person p : people){
			System.out.println(p); // to print this : toSting of 'Person' class method would be used
		}
	}

}
