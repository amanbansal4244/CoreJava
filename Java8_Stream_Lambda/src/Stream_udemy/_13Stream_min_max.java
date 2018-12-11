package Stream_udemy;

import java.util.Arrays;

import LambdaBasicExcercisePackage.Person;

public class _13Stream_min_max {


	public static void main(String[] args) {
		java.util.List<Person1> people = Arrays.asList(
				new Person1("aman", "bansal", 26),
				new Person1("aman1", "bansal1", 68), 
				new Person1("aman2", "Walia", 23), 
				new Person1("aman3", "Garg", 28)

				);

		//min
		double minNumber = people.stream() // people is source
				.filter(p -> p.getLastName().startsWith("b"))
				.mapToDouble(Person1:: getAge)
				.min()
				.getAsDouble();

		System.out.println("Min. no: " + minNumber);


		// max
		double maxNumber = people.stream() // people is source
				.filter(p -> p.getLastName().startsWith("b"))
				.mapToDouble(Person1:: getAge)
				.max()
				.getAsDouble();

		System.out.println("Min. no: " + maxNumber);


	}

}
