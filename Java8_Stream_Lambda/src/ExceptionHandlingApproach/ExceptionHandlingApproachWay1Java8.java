package ExceptionHandlingApproach;

import java.util.function.BiConsumer;

public class ExceptionHandlingApproachWay1Java8 {
	public static void main(String[] args) {
		int [] somenumbers = { 1,2,3,4,5};
		int key =0;
		// For lambda expression , We need an interface.. which method takes 2 arguments and return one object.
		//So I used 'BiConsumer' interface.
		//But this is not much cool to write try catch block with lambda expression since lambda expression code increased from one line code.
		process(somenumbers,key,(v,k) -> {
			try{	
				System.out.println(v/k);
			}catch(Exception e){
				System.out.println("Exception Occurred");
			}
		});
		
	}

	private static void process(int[] somenumbers, int key, BiConsumer<Integer, Integer> biConsumer) {
		for(int i : somenumbers){
				biConsumer.accept(i, key);
		}
	}
}
