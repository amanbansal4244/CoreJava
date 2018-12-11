package forEachIterationUsingLamda;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import LambdaBasicExcercisePackage.Person;

public class forEachIterationUsingSimpleJava7 {

	public static void main(String[] args) {
		List<Integer> people = Arrays.asList(1,2,3,4,5,6);
		
		//External Iteration : we should use for loop when we want to limited values like from index 3 to 5 only.
		System.out.println("using for loop");
		for(int i =2; i<people.size();i++){
			System.out.println(people.get(i));
		}
		
		//External Iteration : we should use for iteration when we want to limited values like from index 3 to 5 only.
		System.out.println("\n using iteration");
		Iterator<Integer> i = people.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		//External Iteration : We should use enhanced for loop when we want to print all values.
		System.out.println("\n using for each  loop");
		for(Integer p : people){
			System.out.println(p);
		}
	
	}
}
