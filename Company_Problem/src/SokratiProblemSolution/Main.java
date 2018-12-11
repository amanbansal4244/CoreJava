package SokratiProblemSolution;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Combination obj = new Combination();
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 System.out.println("Enter the size of Row");
		 int r=Integer.parseInt(br.readLine());
		 System.out.println("Enter the size of Column");
		 int c=Integer.parseInt(br.readLine());
		 int[][] input = new int[r][c];
		 System.out.println("Enter array elements:");
		 
		 for(int i=0; i<r;i++){
			 for(int j=0;j<c;j++){
				 int no=Integer.parseInt(br.readLine());
				 input[i][j]=no;
			 }
		 }
		ArrayList<int[]> combos= obj.generate(input);
		
	    for(int[] s : combos){
	        System.out.println(java.util.Arrays.toString(s));
	    }
		
	}
}
