package StreamsJava8;

import java.util.Arrays;
import java.util.List;

public class StreamLazyEvaluationAndTerminalProofInDetails {

	public static boolean isDivisible(int i){
		System.out.println("In Divisible for value:"+ " " + i);
		return i%5 == 0;
	}

	public static int mapDoubled(int i){
		System.out.println("In map doubled for value:" + " " + i);
		return i*2;
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3,50,40,35,67,90);
		int result = 0;
		for(int i : list){
			System.out.println("in for loop for value:" + " " + i);
			if(i%5 == 0){
				result =  i*2;
				break;
			}
		}

		System.out.println("first Number divided by 5 only using for loop :" + result);

		Integer s = list.stream(). 
				filter(StreamLazyEvaluationAndTerminalProofInDetails :: isDivisible).
				map(StreamLazyEvaluationAndTerminalProofInDetails :: mapDoubled).
				findFirst().
				orElse(0);
		System.out.println("first Number divided by 5 using stream :" + s);

	}

}
