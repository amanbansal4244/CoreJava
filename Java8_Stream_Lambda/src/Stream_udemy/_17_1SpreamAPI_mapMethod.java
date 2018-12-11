package Stream_udemy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class _17_1SpreamAPI_mapMethod {

	public static void main(String[] args) {
		List<Integer> people = Arrays.asList(1,2,3,4,5);
		Stream s1 = people.stream()
				.map(i -> i*2);
		
		System.out.println("after doubled values");
		
		s1.forEach(System.out :: println);
	}
}
