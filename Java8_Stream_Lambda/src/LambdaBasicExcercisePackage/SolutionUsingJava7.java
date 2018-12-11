package LambdaBasicExcercisePackage;

import java.awt.List;
import java.text.spi.CollatorProvider;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class SolutionUsingJava7 {

	public static void main(String[] args) {

		java.util.List<Person> people = Arrays.asList(
				new Person("aman", "bansal", 26),
				new Person("aman1", "bansal1", 26), 
				new Person("aman2", "Walia", 27), 
				new Person("aman3", "Garg", 28)

		);

		// Problem 1 : Sort list by last names.
		Collections.sort(people, new Comparator<Person>() { // We can create new class for comparator but here we create 'anonymous inner class' which is implementing 'comparator' interface
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});

		// Problem 2 : Create a method which prints all name in the list
		printAll(people);
		
		// Problem 3: Create a method that prints all have people last name beginning with b 
		System.out.println("prints all have people last name beginning with b" );
		printAllConditionaly(people, new ConditionInterface() { //  we create 'anonymous inner class' which is implementing 'ConditionInterface' interface
			
			@Override
			public boolean testCondition(Person p) {
				if (p.getLastName().startsWith("b")) {
					return true;
				}
				return false;
			}
		});
		
		//Problem 4: Create a method that prints all have people last name beginning with G
		System.out.println("prints all have people last name beginning with G" );
		ImplementationClass implementationClass = new ImplementationClass(); // Creates new class which is implementing 'ConditionInterface' interface
		printAllConditionaly(people, implementationClass);
	}

	private static void printAllConditionaly(java.util.List<Person> people , ConditionInterface CI) {
		
		for (Person p : people) {
			if (CI.testCondition(p)) {
				System.out.println( p); // to print this : toSting of 'Person' class method would be used 
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
