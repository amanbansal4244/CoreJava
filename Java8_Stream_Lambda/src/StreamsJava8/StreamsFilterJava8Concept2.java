package StreamsJava8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsFilterJava8Concept2 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3,50,40,35,67,90);
		
		int result = 0;
		
		for(int i : list){
			if(i%5 == 0){
				result = result + i;
			}
		}
		
		System.out.println("Number divided by 5 only without stream filter :" + result);
		
		
		
		Integer s = list.stream(). //stream will take all the values from list
								filter(j -> j%5 == 0). // after this line , only those values come out from list which can be divided by 5
								reduce(0,(c,e) -> c+e); // This line will sum up all values which is divided by 5
		System.out.println("Number divided by 5 only using stream filter :" + s);
	}
}
