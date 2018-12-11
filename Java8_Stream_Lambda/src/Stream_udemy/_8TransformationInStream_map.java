package Stream_udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _8TransformationInStream_map {

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
	
	//Here, we are taking the data of Person class and storing(Transforming) into another class
	public void transaformationStream() {
		List<PersonDTO> personDTOList = listOfPesron.stream()
			.map(per -> new PersonDTO(per.getAge(), per.getName())) // Converting Person object into PersonDTO object.
			.collect(Collectors.toList());
		
		personDTOList.forEach(System.out::println);
	}
	
	//Different approach to achieve same as above, we are taking the data of Person class and storing(Transforming) into another class.
		public void transaformationStream1() {
			List<PersonDTO> personDTOList = listOfPesron.stream()
				.map(PersonDTO::mappingFromPerson) // we are calling the static method 'mappingFromPerson'
				.collect(Collectors.toList());
			
			personDTOList.forEach(System.out::println);
		}
	
	public static void main(String[] args) {
		new _8TransformationInStream_map().transaformationStream();
		new _8TransformationInStream_map().transaformationStream1();
	}
}
