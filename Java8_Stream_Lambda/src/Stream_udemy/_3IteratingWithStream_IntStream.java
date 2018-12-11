package Stream_udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/****
 * IntStream is a stream of primitive int values. It's part of the java.util.stream package.
 */
public class _3IteratingWithStream_IntStream {

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

	//1. Print some number through intStream
	public void range() {

		//Before Java 8
		System.out.println("Before Java 8");
		for(int i=0; i<=10; i++) {
			System.out.println(i);
		}

		/****
		 * As you probably guessed from the resulting streams, the rangeClosed function includes 
		 * the ending int, while range excludes it.
		 */

		//After java 8
		System.out.println("After Java 8 : Exclusive approach, here 10 will be Exclusive");
		IntStream.range(0, 10)
		.forEach(System.out::println);

		System.out.println("After Java 8 : Inclusive approach , here 10 will be Inclusive");
		IntStream.rangeClosed(0, 10)
		.forEach(System.out::println);
	}

	/****
	 * Complete method bellow: loop through people using IntStream and get the index and print the each object.
	 */
	public void rangeIteratingPersonList() {
		IntStream.range(0, listOfPesron.size())
			.forEach(index1 -> {
				Person person = listOfPesron.get(index1);
				System.out.println(person.getAge());
			});

	}
	

	//Now what if we don't want all the ints within a range? What if we just want every even number?
	public void intStreamIterator() {
		IntStream.iterate(0, i -> i +1) // this is same as loop starts from 0 and incrementing by 1
		.filter(numberEven -> numberEven %2 == 0) // gives the only even numbers.
		.limit(5) //this will restrict the number of result.
		.forEach(System.out::println);
		
	}
	
	
	public static void main(String[] args) {
		//new _3IteratingWithStream_IntStream().range();
		//new _3IteratingWithStream_IntStream().rangeIteratingPersonList();
		new _3IteratingWithStream_IntStream().intStreamIterator();
	}
}
