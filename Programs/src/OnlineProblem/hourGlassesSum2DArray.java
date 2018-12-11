package OnlineProblem;

// Problem -> https://www.hackerrank.com/challenges/java-2d-array

import java.util.Arrays;

import java.util.*;

	/**
	 * @author amanba
	 *
	 */
	class hourGlassesSum2DArray 
	{
		int sum=0;
		int startCountForRow=0;
		int endCountForRow=2;
		int startCountForColumn=0;
		int endCountForColumn=2;
		int condForRow=0;
		int condForColumn=1;
		int finalSum=0;
		public  void hourGlassesSum(int[][] arr){
			
			
			for(int i=startCountForRow; i<=endCountForRow;i++){
				for(int  j=startCountForColumn; j<=endCountForColumn;j++){
					if((i==condForColumn && j==condForRow) || (i==condForColumn && j==condForRow+2)){
						
					}
					else{
						sum =  sum +arr[i][j];
					}
				}
			}
			//System.out.println(sum);
			if(sum > finalSum){
				finalSum=sum;
			}
			startCountForColumn++;
			endCountForColumn++;
			condForRow++;
			sum=0;
			if(endCountForColumn >= arr.length ){
				
			}
			else{
				hourGlassesSum( arr);
			}
			startCountForRow++;
			endCountForRow++;
			condForColumn++;
			startCountForColumn=0;
			endCountForColumn=2;
			condForRow=0;
			if(endCountForRow >= arr.length ){
				
			}
			else{
				hourGlassesSum( arr);
			}
		
			
			System.out.println(finalSum);
		}
		

		
		public static void main(String[] args) {
			hourGlassesSum2DArray obj = new hourGlassesSum2DArray();
			int arr[][]=
				{
					{1 ,1, 1, 0, 0, 0},
					{0, 1, 0, 0, 0, 0},
					{1, 1, 1, 0, 0, 0},
					{0, 0, 2, 4, 4, 0},
					{0, 0, 0, 2, 0, 0},
					{0, 0, 1, 2, 4, 0}
				};
			
			obj.hourGlassesSum(arr);
		}
	}