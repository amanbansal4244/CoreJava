package ArrayBased;
/*Search in a row wise and column wise sorted matrix
Given an n x n matrix, where every row and column is sorted in increasing order. 
Given a number x, how to decide whether this x is in the matrix. The designed algorithm should have linear time complexity.


1) Start with top right element
2) Loop: compare this element e with x
….i) if they are equal then return its position
…ii) e < x then move it to down (if out of bound of matrix then break return false)
..iii) e > x then move it to left (if out of bound of matrix then break return false)
3) repeat the i), ii) and iii) till you find element or returned false*/
public class Searchinarowwiseandcolumnwisesortedmatrix {
	/* Searches the element x in mat[][]. If the element is found, 
    then prints its position and returns true, otherwise prints 
    "not found" and returns false */
static public void search(int[][] mat, int n, int x)
{
   int i = 0, j = n-1;  //set indexes for top right element
   while ( i < n && j >= 0 )
   {
      if ( mat[i][j] == x )
      {
    	  
    	  System.out.println("Found at" + ": " + " row" + i + " " +" column" +" :" + j);
      
      }
      if ( mat[i][j] > x )
        j--;
      else //  if mat[i][j] < x
        i++;
   }
 System.out.println("Element not found");

}

public static void main(String[] args) {
		 int mat[][] = { {10, 20, 30, 40},
                 {15, 25, 35, 45},
                 {27, 29, 37, 48},
                 {32, 33, 39, 50},
               };
search(mat, 4, 35); // 4 is no of column and 10 is no which we need to search

}
}