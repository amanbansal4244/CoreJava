package ArrayListAndLInkedListPerformance;

public class System_ArrayCopyConcept {

   public static void main(String[] args) {

      int arr1[] = { 0, 1, 2, 3, 4, 5 };
      int arr2[] = { 5, 10, 20, 30, 40, 50 };
    
     // its copy the arr1 starts from index 2 of arr1 and paste into arr2 that starts from index 0 of arr2 till index 3 of arr2,
      System.arraycopy(arr1, 2, arr2, 0, 3); 
      System.out.print("array2 = ");
      System.out.print(arr2[0] + " ");
      System.out.print(arr2[1] + " ");
      System.out.print(arr2[2] + " ");
      System.out.print(arr2[3] + " ");
      System.out.print(arr2[4] + " ");
   }
}