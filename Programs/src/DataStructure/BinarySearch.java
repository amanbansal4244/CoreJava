package DataStructure;

public class BinarySearch {
	
//Complexity would be : O(logn)
static public void  binarySearch(int[] arr){
		
	 int found_item=75;
     int lowerbound =0;
     int upperbound =arr.length;
  // To start, find the subscript of the middle position.
     int mid = (lowerbound+upperbound)/2;

     while((arr[mid] != found_item) && (lowerbound <= upperbound))
     {
            if (arr[mid] > found_item)               // If the number is > key, ..
           {                                                       // decrease position by one.
                  upperbound = mid - 1;    
           }                                                      
           else                                                
          {                                                        // Else, increase position by one.
                 lowerbound = mid + 1;     
           }
            mid = (lowerbound + upperbound) / 2;
     }
    if (lowerbound <= upperbound)
    {
    	System.out.println("The number was found in array subscript "+ " "+ (mid+1));
          
    }      
     else{
           System.out.println("not found");
     }
} 


public static void main(String[] args) {
		int [] arr = {4,6,8,17,33,49,51,68,75}; // always array in sorted order for binary search
		binarySearch(arr);
	}
}