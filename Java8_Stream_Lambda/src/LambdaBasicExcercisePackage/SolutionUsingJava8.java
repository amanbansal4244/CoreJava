package LambdaBasicExcercisePackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SolutionUsingJava8 {


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
		
		//lambda expression
		
		
		System.out.println("prints all have people last name beginning with b" );
		printAllConditionaly(people, (Person p) -> p.getLastName().startsWith("b"));
		
		
		//Problem 4: Create a method that prints all have people last name beginning with G
		//lambda expression
				ConditionInterface conditionInterface1 =  (Person p) -> {
					if (p.getLastName().startsWith("G")) {
						return true;
					}
					return false;
				};
		System.out.println("prints all have people last name beginning with G" );
		printAllConditionaly(people, conditionInterface1);
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
