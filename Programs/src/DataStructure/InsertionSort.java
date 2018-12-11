package DataStructure;
import java.util.Scanner;

/*6
1 4 3 5 6 2
Sample Output

1 4 3 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 2 3 4 5 6

 *Explanation 
Insertion Sort checks 4 first and doesn't need to move it,
 so it just prints out the array. Next, 3 is inserted next to 1,
  and the array is printed out. This continues one element at a time until the entire array is sorted./
  */
//swap har bar bar so log(n2) swaping.
public class InsertionSort {

	 public static void insertionSortPart2(int[] ar)
	    {       
		 
		 for(int i=0; i< ar.length -1 ;i++){
			 for(int j = i+1; j> 0; j--){
				 if(ar[j] < ar[j-1]){
					 int temp= ar[j];
					 ar[j] = ar[j-1];
					 ar[j-1]=temp;
				 }
				
			 }
			 printArray(ar);
		 }
		// printArray(ar);
	    }
	 public static void main(String[] args) {
	       /* Scanner in = new Scanner(System.in);
	        int s = in.nextInt();
	        int[] ar = new int[s];
	         for(int i=0;i<s;i++){
	            ar[i]=in.nextInt(); 
	         }*/
		 
		 int ar[] = {1, 4, 3, 5, 6, 2};
		 insertionSortPart2(ar);
	    }
	    
	    
	    
		private static void printArray(int[] ar) {
	      for(int n: ar){
	         System.out.print(n+" ");
	      }
	        System.out.println("");
	   }
	    
	    
	
}
