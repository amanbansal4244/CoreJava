package Stream_udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _9Average_sum_mapToDouble {

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

	//Here, we are taking the data of Person class and storing(Transforming) into another class and calculating the average of age.
	public void averageAgeOfPerson() {
		double averageOfAge = listOfPesron.stream()
				// mapToDouble converting int type to Double data type because i want to perform average on double data type.
				.mapToDouble(PerObject -> PerObject.getAge()) // Returns a DoubleStream consisting of the results of applying the given function to the elements of this stream.
				.average()// we are calculating the average.
				.orElse(0);// if nothing is found to do average the print 0

		System.out.println("averageOfAge: "+ averageOfAge);

	}

	//Here, we are taking the data of Person class and storing(Transforming) into another class and calculating the sum of age.
	public void sumAgeOfPerson() {
		double sum = listOfPesron.stream()
				// mapToDouble converting int type to Double data type because i want to perform average on double data type.
				.mapToDouble(PerObject -> PerObject.getAge()) // Returns a DoubleStream consisting of the results of applying the given function to the elements of this stream.
				.sum();// we are calculating the sum.

		System.out.println("sumAgeOfPerson: "+ sum);

	}

	public static void main(String[] args) {
		new _9Average_sum_mapToDouble().averageAgeOfPerson();
		new _9Average_sum_mapToDouble().sumAgeOfPerson();
	}
}
