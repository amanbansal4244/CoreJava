package ArrayListAndLInkedListPerformance;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListAndLInkedListPerformance {
	
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		// ArrayList add 100000 records in array list one by one
		long startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			arrayList.add(i);
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("ArrayList, total time taken add 100000 records in array list one by one:  " + duration);


		// LinkedList add 100000 records in linked list one by one
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			linkedList.add(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList, total time taken add 100000 records in linked list one by one: " + duration);


		// ArrayList add with mid of array list around index at 50000:
		startTime = System.nanoTime();
		arrayList.add(50000,34);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken :ArrayList add with mid of array list around index at 50000:  " + duration);


		// LinkedList add with mid of linked list around index at 50000:
		startTime = System.nanoTime();
		linkedList.add(50000,34);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken :LinkedList add with mid of linked list around index at 50000: " + duration);


		// ArrayList add with start of array list around index at 5: 
		startTime = System.nanoTime();
		arrayList.add(5,30);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken :ArrayList add with start of array list around index at 5:  " + duration);


		// LinkedList add with start of linked list around index at 5: 
		startTime = System.nanoTime();
		linkedList.add(5,30);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken :LinkedList add with start of linked list around index at 5: " + duration);


		// ArrayList add with end of array list around index at 95000: 
		startTime = System.nanoTime();
		arrayList.add(95000,31);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken :ArrayList add with end of array list around index at 95000:  " + duration);


		// LinkedList add with end of linked list around index at 95000: 
		startTime = System.nanoTime();
		linkedList.add(95000,31);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken :LinkedList add with end of linked list around index at 95000: " + duration);


		// ArrayList get total time to fetch all the records from array list:
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			arrayList.get(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken :ArrayList get total time to fetch all the records from array list one by one:  " + duration);


		// LinkedList get total time to fetch all the records from linked list:
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			linkedList.get(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken :LinkedList get total time to fetch all the records from linked list one by one: " + duration);


		// ArrayList remove with mid of array list around index at 50000:
		startTime = System.nanoTime();
		arrayList.remove(50000);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken :ArrayList remove with mid of array list around index at 50000:  " + duration);


		// LinkedList remove with mid of linked list around index at 50000:
		startTime = System.nanoTime();
		linkedList.remove(50000);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken :LinkedList remove with mid of linked list around index at 50000: " + duration);


		// ArrayList remove with start of array list around index at 5: 
		startTime = System.nanoTime();
		arrayList.remove(5);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken :ArrayList remove with start of array list around index at 5:  " + duration);


		// LinkedList remove with start of linked list around index at 5: 
		startTime = System.nanoTime();
		linkedList.remove(5);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken :LinkedList remove with start of linked list around index at 5: " + duration);


		// ArrayList remove with end of array list around index at 95000: 
		startTime = System.nanoTime();
		arrayList.remove(95000);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken :ArrayList remove with end of array list around index at 95000:  " + duration);


		// LinkedList remove with end of linked list around index at 95000: 
		startTime = System.nanoTime();
		linkedList.remove(95000);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken :LinkedList remove with end of linked list around index at 95000: " + duration);

		// ArrayList remove all array list one by one
		startTime = System.nanoTime();
		for (int i = 9999; i >=0; i--) {
			arrayList.remove(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken :ArrayList remove all array list elements one by one:  " + duration);



		// LinkedList remove  all linked list one by one
		startTime = System.nanoTime();
		for (int i = 9999; i >=0; i--) {
			linkedList.remove(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Time taken :LinkedList remove  all linked list elements one by one: " + duration);
	}
}
