package Graphs;

/*See below video to understand what does mean of island or connected cluster.
	
	https://www.youtube.com/watch?v=CGMNePwovA0&t=34s
	
	Concept : http://javabypatel.blogspot.in/2016/08/find-number-of-islands-using-dfs.html
*/
/*Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. 
 * For example, the below matrix contains 5 islands
 * 
Given a 2-d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Input : mat[][] = {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1} 
Output : 5
Time complexity is : O(V+E) time where V -> Vertices and E -> Edges
*/ 
class Islands
{
    //No of rows and columns
    static final int ROW = 5, COL = 5;
 
    // A function to check if a given cell (row, col) can
    // be included in DFS
    boolean isSafe(int M[][], int row, int col,
                   boolean visited[][])
    {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) &&
               (col >= 0) && (col < COL) &&
               (M[row][col]==1 && !visited[row][col]);
    }
 
    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    void DFS(int M[][], int row, int col, boolean visited[][])
    {
    	
    	System.out.println("Pair : "+ row +","+ col);
    	
    	/*These arrays are used to get row and column numbers of 8 neighbors of a given cell and middle element(1,1) is main node.
	    	1, 1, 1
	    	1, 1, 1
	    	1, 1, 1
    	*/


    	/* In row, consider middle elements of 8 neighbors of a given cell, suppose we are currently at 0th row index.
    	 *  put -1 for top of 0th row(because we need to visit earlier index so that we need to go back by one index so, 0-1= -1)
    	 *  put 0 for middle row means 0th row( because suppose, currently we are at 0 index, we don't need to move up and down at all)
    	 *  and +1 for last of 0th row(because we need to visit next index so that we need to go to next index by one index  so, 0+1= +1)
    	 *  and traverse row wise and store into array 
	    	-1, -1, -1
			 0,  1,  0
			+1, +1, +1
    	 */
    	int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};	
    	
    	/* In row, consider middle elements of 8 neighbors of a given cell, suppose we are currently at 0th column index.
    	 *  put -1 for left of 0th column(because we need to visit earlier index so that we need to go back by one index so, 0-1= -1)
    	 *  put 0 for middle column means 0th column( because suppose, currently we are at 0 index, we don't need to go left and right at all)
    	 *  and +1 for last of 0th column(because we need to visit next index so that we need to go to next index by one index  so, 0+1= +1)
    	 *  and traverse row wise and store into array 
	    	-1, 0, +1
			-1, 1, +1
			-1, 0, +1
    	 */
    	int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};

    	// Mark this cell as visited
    	visited[row][col] = true;

    	// Recursion for all connected neighbors
    	for (int k = 0; k < 8; ++k){
    		if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited) ){
    			DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    		}
    	}
    }
 
    // The main function that returns count of islands in a given
    //  boolean 2D matrix
    int countIslands(int M[][])
    {
        // Make a boolean array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[ROW][COL];
 
 
        // Initialize count as 0 and traverse through the all cells of given matrix.
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j]==1 && !visited[i][j]) // If a cell with
                {                                 // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                	++count;
                    System.out.println("Below Are The Pair of Island No : " +count);
                    DFS(M, i, j, visited);
                   
                }
 
        return count;
    }
 
    // Driver method
    public static void main (String[] args) throws java.lang.Exception
    {
        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
                                 {0, 1, 0, 0, 1},
                                 {1, 0, 0, 1, 1},
                                 {0, 0, 0, 0, 0},
                                 {1, 0, 1, 0, 1}
                                };
        Islands I = new Islands();
        System.out.println("Total Number of islands is: "+ I.countIslands(M));
    }
}