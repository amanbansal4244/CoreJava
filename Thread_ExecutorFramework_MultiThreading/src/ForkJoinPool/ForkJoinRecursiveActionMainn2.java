package ForkJoinPool;
import java.util.*;
import java.util.concurrent.*;
 
/**
 * This program demonstrates how to execute a resultless ForkJoinTask in
 * a ForkJoinPool
 */
public class ForkJoinRecursiveActionMainn2 {
    static final int SIZE = 10_000_000;
    static int[] array = randomArray();
 
    public static void main(String[] args) {
 
        int number = 9;
 
        System.out.println("First 10 elements of the array before: ");
        print();
 
        ArrayTransform mainTask = new ArrayTransform(array, number, 0, SIZE);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
 
        System.out.println("First 10 elements of the array after: ");
        print();
    }
 
    static int[] randomArray() {
        int[] array = new int[SIZE];
        Random random = new Random();
 
        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(100);
        }
 
        return array;
    }
 
    static void print() {
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }
}