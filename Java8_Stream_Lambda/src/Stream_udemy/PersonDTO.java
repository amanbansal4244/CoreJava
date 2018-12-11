package Stream_udemy;

public class PersonDTO {

	private final int age;
	private final String name;

	public PersonDTO(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonDTO [age=" + age + ", name=" + name + "]";
	}
	
	public static PersonDTO mappingFromPerson(Person person) {
		return new PersonDTO(person.getAge(), person.getName());
	}

}
