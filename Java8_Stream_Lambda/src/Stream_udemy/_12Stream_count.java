package Stream_udemy;

import java.util.Arrays;

import LambdaBasicExcercisePackage.Person;

public class _12Stream_count {


	public static void main(String[] args) {
		java.util.List<Person> people = Arrays.asList(
				new Person("aman", "bansal", 26),
				new Person("aman1", "bansal1", 26), 
				new Person("aman2", "Walia", 27), 
				new Person("aman3", "Garg", 28)

		);
		
		/*Stream : is used to iterate like an assembly language and all data will be iterating like on conveyor belt.
		 * Now here we want to print first name whose last name start with "b" only.
		 * Stream -> Returns a sequential Stream with this collection as its source.
		*/
		System.out.println("using stream");
		people.stream() // people is source
		.filter(p -> p.getLastName().startsWith("b"))
		.forEach(p -> System.out.println(p.getFirstName())); // this is terminal operation.
		
		
		long count = people.stream() // people is source
		.filter(p -> p.getLastName().startsWith("b"))
		.count(); // this is terminal operation.
		
		System.out.println("Count :" + count);
		
		/*parallelStream used for parallel processing (thats what lambda expression is used for parallel processing.
		 * parallelStream -> Returns a possibly parallel Stream with this collection as its source.
		 * It is allowable for this method to return a sequential stream. 	
		*/
		long count1 = people.parallelStream() // people is source
				.filter(p -> p.getLastName().startsWith("b"))
				.count(); // this is terminal operation.
				
		System.out.println("Count1 :" + count1);
				
	}

}
