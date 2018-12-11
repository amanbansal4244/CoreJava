package Stream_udemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/****
 * IntStream is a stream of primitive int values. It's part of the java.util.stream package.
 */
public class _4ToFindMinAndMaxNumber_ComparatorUsingStream {

	

	public int min() {
		final List<Integer> numbersList = Arrays.asList(1,25,23,56,11,88,54);
		
		return numbersList.stream()
		//.min((number1, number2) -> number1 > number2 ? 1: -1) // this is also correct
		.min(Comparator.naturalOrder()) // this will give us mininum no.
		.get(); // If a value is present in this Optional, returns the value, otherwise throws NoSuchElementException.
		
	}
	
	public int max() {
		final List<Integer> numbersList = Arrays.asList(1,25,23,56,11,88,54);
		
		return numbersList.stream()
		.max((number1, number2) -> number1 > number2 ? 1: -1) // this is also correct
		//.max(Comparator.naturalOrder()) // this will give us mininum no.
		.get();// If a value is present in this Optional, returns the value, otherwise throws NoSuchElementException.
		
	}
	
	public static void main(String[] args) {
		System.out.println("Min. number is :" + new _4ToFindMinAndMaxNumber_ComparatorUsingStream().min());
		System.out.println("Max. number is :" + new _4ToFindMinAndMaxNumber_ComparatorUsingStream().max());
	}
}
