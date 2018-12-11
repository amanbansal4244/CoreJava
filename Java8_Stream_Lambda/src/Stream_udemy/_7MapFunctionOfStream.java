package Stream_udemy;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * The map() function is a method in the Stream class which represents a functional programming concept. 
 * In simple words, the map() is used to transform/convert one object into other object by applying a function.
 * 
 * A simple Java Program to demonstrate how to use map and filter method Java 8.
 * In this program, we'll convert a list of String into a list of Integer and
 * then filter all even numbers.
 */
public class _7MapFunctionOfStream {
  public static void main(String[] args) {
    List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
    System.out.println("original list: " + numbers);
    List<Integer> even = 
    		numbers.stream()
                   .map(s -> Integer.valueOf(s)) // converting array list object String type  element into Integer, so that we can filter.
                   .filter(number -> number % 2 == 0)
                   .collect(Collectors.toList());//collecting into list.
    System.out.println("processed list, only even numbers: " + even);
  }
}