package Stream_udemy;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap; import java.util.List; import java.util.Map; import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream; 
/****
 * In Java 8, Stream can hold different data types, for examples:

Stream<String[]>	
Stream<Set<String>>	
Stream<List<String>>	
Stream<List<Object>>

But, the Stream operations (filter, sum, distinct…) and collectors does not support it, so, we need flatMap() to do the following conversion :

Stream<String[]>		-> flatMap ->	Stream<String>
Stream<Set<String>>	-> flatMap ->	Stream<String>
Stream<List<String>>	-> flatMap ->	Stream<String>
Stream<List<Object>>	-> flatMap ->	Stream<Object>

How flatMap() works :
{ {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}

{ {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
 */
public class _16_2Stream_flatMap {
	public static void main(String args[]) throws IOException {
		 Student obj1 = new Student();
	        obj1.setName("mkyong");
	        obj1.addBook("Java 8 in Action");
	        obj1.addBook("Spring Boot in Action");
	        obj1.addBook("Effective Java (2nd Edition)");

	        Student obj2 = new Student();
	        obj2.setName("zilap");
	        obj2.addBook("Learning Python, 5th Edition");
	        obj2.addBook("Effective Java (2nd Edition)");

	        List<Student> list = new ArrayList<>();
	        list.add(obj1);
	        list.add(obj2);

	        List<String> collect =
	                list.stream()
	                        .map(x -> x.getBook())      //Stream<Set<String>>
	                        .flatMap(x -> x.stream())   //Stream<String>
	                        .distinct()
	                        .collect(Collectors.toList());

	        collect.forEach(x -> System.out.println(x));
	    }
}
