package Stream_udemy;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap; import java.util.List; import java.util.Map; import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors; 
/****
 * Java 8 now directly allows you to do GROUP BY in Java by using Collectors.groupingBy() method.
 *  GROUP BY is a very useful aggregate operation from SQL. 
 *  It allows you to group records on certain criteria. How do you group by in Java? 
 *  For example, suppose you have a list of Persons, How do you group persons by their city 
 *  e.g. London, Paris or Tokyo? Well, we can do that by using a for loop, 
 *  checking each person and putting them on a list of HashMap with the same city,
 *  but in Java 8, you don't need to hack your way like that, you have a much cleaner solution. 
 *  You can use Stream and Collector which provides groupingBy() method to do this.
 *  Since its one of the most common way to aggregate data, it has a real benefit, 
 *  coupled that with the various overloaded version of groupingBy() method which also allow you to perform 
 *  grouping objects concurrently by using concurrent Collectors.
 */
public class _15Stream_groupingBy_mapping {
	public static void main(String args[]) throws IOException { 
		java.util.List<Person1> people = Arrays.asList(
				new Person1("aman", "bansal", 26),
				new Person1("aman1", "bansal1", 68), 
				new Person1("aman2", "Walia", 23), 
				new Person1("aman3", "Garg", 28)

				);

		// Now let's group all person by firstName in pre Java 8 world 
		Map<String,List<Person1>> personByCity = new HashMap<>(); 
		
		for(Person1 p : people){ 
			if(!personByCity.containsKey(p.getFirstName())){
				personByCity.put(p.getFirstName(), new ArrayList<>());
			}
			personByCity.get(p.getFirstName()).add(p);
		}
		System.out.println("Person grouped by firstNames before jave8: " + personByCity);

		// Let's see how we can group objects in Java 8 
		personByCity = people.stream() 
				.collect(Collectors.groupingBy(Person1 ::getFirstName)); 
		System.out.println("Person grouped by firstName in Java 8: " + personByCity); 
		
		// group by age, uses 'mapping' to convert List<Item> to Set<String>
        Map<Integer, Set<String>> result =
        		people.stream().collect(
                        Collectors.groupingBy(Person1::getAge,
                                Collectors.mapping(Person1::getFirstName, Collectors.toSet())
                        )
                );

        System.out.println("group by age, uses 'mapping' to convert List<Item> to Set<String>:" + result);

		// Now let's group person by age
		Map<Integer,List<Person1>> personByAge = people.stream() 
				.collect(Collectors.groupingBy(Person1::getAge)); 
		System.out.println("Person grouped by age in Java 8: " + personByAge); 

		// Now let's group person by age - counting
		Map<Integer,Long> personByAgeCounting = people.stream() 
				.collect(Collectors.groupingBy(Person1::getAge, Collectors.counting())); 
		
		System.out.println("Counted Person grouped by age in Java 8: " + personByAgeCounting); 
	}
}
