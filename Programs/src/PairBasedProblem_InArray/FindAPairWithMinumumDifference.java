package PairBasedProblem_InArray;

public class FindAPairWithMinumumDifference {
	
	public void printFindAPairWithMinumumDifference(int[] nums){
	       
		int minDiff =0;
		int maxDiff=0;
		int k=0;
		int minFirstIndex=0;
		int minSecondIndex=0;
		int maxFirstIndex=0;
		int maxSecondIndex=0;
		
		for(int i=0; i <nums.length;i++)
		{
		   for(int j =i+1; j<nums.length;j++)
		   {
			   int temp=0;
			   
				   temp= Math.abs(nums[i]-nums[j]);
				   if(k==0 ){
					   minDiff=temp;
					   minFirstIndex=i;
					   minSecondIndex=j;
					   k++;
				   }
				   else if( temp < minDiff){
					   minDiff=temp;
					   minFirstIndex=i;
					   minSecondIndex=j;
					   
				   }
				   else if( temp > maxDiff){
					   maxDiff=temp;
					   maxFirstIndex=i;
					   maxSecondIndex=j;
				   }		   
		   }
		}
		
		System.out.println("Minimum Diff." + " = "+ minDiff);
		System.out.println("Max Diff." + " = "+ maxDiff);
		System.out.println("Pair With The Minimum Difference" +" = "+ nums[minFirstIndex] + " and " + nums[minSecondIndex]);
		System.out.println("Pair With The Maximum Difference" +" = "+ nums[maxFirstIndex] + " and " + nums[maxSecondIndex]);
    }
     
    public static void main(String a[]){
      // int num[] = {5,34,78,2,45,1,99,23};
    	int num[] = {1,5,7,8,13};
    	FindAPairWithMinumumDifference tmn = new FindAPairWithMinumumDifference();
        tmn.printFindAPairWithMinumumDifference(num);
    }
}
