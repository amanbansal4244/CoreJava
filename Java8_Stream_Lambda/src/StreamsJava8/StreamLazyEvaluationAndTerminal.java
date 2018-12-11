package StreamsJava8;

import java.util.Arrays;
import java.util.List;

public class StreamLazyEvaluationAndTerminal {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3,50,40,35,67,90);
		int result = 0;
		for(int i : list){
			if(i%5 == 0){
				result =  i*2;
				break;
			}
		}

		System.out.println("first Number divided by 5 only without stream filter :" + result);

		Integer s = list.stream(). 
				filter(j -> j%5 == 0).
				map(i -> i*2).
				findFirst().
				orElse(0);
		System.out.println("first Number divided by 5 only using stream filter :" + s);

	}
}
