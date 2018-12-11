package PerformanceImprovementInHashMapJava8;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Person /*implements Comparable<Person>*/{

	private String firstName;
	private String lastName;
	private UUID id;
	private static final int LIMIT = 500_000;

	public Person(String firstName, String lastName, UUID id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	/*@Override
		public int compareTo(Person person) {
			  return this.id.compareTo(person.id);
		}*/

	@Override
	public int hashCode() {
		return 5;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if(o == null || o.getClass() != this.getClass()){
			return false;
		}
		if(!(o instanceof Person)){
			return false;
		}
		Person personObj = (Person) o;
		if((this.firstName == null ) ? (personObj.firstName !=null) : !this.firstName.equals(personObj.firstName))
		{
			return false;
		}
		if(this.id != personObj.id){ 
			return false;
		}
		return true;
	}

	private static void fillAndSearch() {
		Person person = null;
		Map<Person, String> map = new HashMap<>();
		
		long startTimeBeforPut = System.currentTimeMillis();
		java.sql.Timestamp timeStampStartBeforPut = new java.sql.Timestamp(startTimeBeforPut);
		
		System.out.println("timeStampStartBeforPut :" + timeStampStartBeforPut);
		
		for (int i=0;i<LIMIT;i++) {
			UUID randomUUID = UUID.randomUUID();
			person = new Person("fn", "ln", randomUUID);
			map.put(person, "comment" + i);
		}
		
		long startTime = System.currentTimeMillis();
		java.sql.Timestamp timeStampStart = new java.sql.Timestamp(startTime);
		
		System.out.println("timeStampStart :" + timeStampStart);
		
		map.get(person);

		long stopTime = System.currentTimeMillis();
		java.sql.Timestamp timeStampStop = new java.sql.Timestamp(stopTime);
		System.out.println("timeStampStop : " + timeStampStop);
	}

	public static void main(String[] args) {
		Person.fillAndSearch();	    	
	}
}
