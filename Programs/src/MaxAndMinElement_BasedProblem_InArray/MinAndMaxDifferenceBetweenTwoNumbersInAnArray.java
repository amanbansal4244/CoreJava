package MaxAndMinElement_BasedProblem_InArray;

public class MinAndMaxDifferenceBetweenTwoNumbersInAnArray {

	public void printMinimumDifferenceNumbers(int[] nums){
       
		int minDiff =0;
		int maxDiff=0;
		int k=0;
		for(int i=0; i <nums.length;i++)
		{
		   for(int j =i+1; j<nums.length;j++)
		   {
			   int temp=0;
				   temp= Math.abs(nums[i]-nums[j]);
				   if(k==0 ){
					   minDiff=temp;
					   k++;
				   }
				   else if( temp < minDiff){
					   minDiff=temp;
				   }
				   else if( temp > maxDiff){
					   maxDiff=temp;
				   }		   
		   }
		}
		System.out.println("Minimum Diff." + " = "+ minDiff);
		System.out.println("Max Diff." + " = "+ maxDiff);
    }
     
    public static void main(String a[]){
      // int num[] = {5,34,78,2,45,1,99,23};
    	int num[] = {7,2,3,10,2,4,8,1};
        MinAndMaxDifferenceBetweenTwoNumbersInAnArray tmn = new MinAndMaxDifferenceBetweenTwoNumbersInAnArray();
        tmn.printMinimumDifferenceNumbers(num);
    }
}
