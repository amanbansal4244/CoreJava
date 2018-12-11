package ArrayBased;

public class MaxProductOf4ContinuesNoInArray {
	
	 public  void findMaxSubArray(int[] inputArray){

	        int maxStartIndex=0;
	        int maxEndIndex=0;
	        int maxSum = Integer.MIN_VALUE; 
	        int productSum= 1;
	       
	        int maxStartIndexUntilNow=0;
	        		
	        for (int currentIndex = 0; currentIndex < inputArray.length; currentIndex++) {
	        	int tempIndex=currentIndex;
	        	maxStartIndexUntilNow=currentIndex;
	           	int k=0;
	           	if(currentIndex <= inputArray.length-4){
			   		while(k<4)
			   		{
			   			int eachArrayItem = inputArray[tempIndex];
			   			productSum*=eachArrayItem;
			   			k++;
			   			tempIndex++;
			   		}
			   		tempIndex--;
	           	}
	            if(productSum > maxSum){
	                maxSum = productSum;
	                maxStartIndex=maxStartIndexUntilNow;
	                maxEndIndex = tempIndex;
	                productSum=1;
	            }
	           else if (productSum< maxSum){
	            	maxStartIndexUntilNow=currentIndex+1;
	            	productSum=1;
	            }
	        }

	        System.out.println("Max sum         : "+maxSum);
	        System.out.println("Max start index : "+maxStartIndex);
	        System.out.println("Max end index   : "+maxEndIndex);
	    }
	   
	

	  public static void main(String a[]){
	        int num[] = {5,3,7,-2,4,-1,9,-3};
	        MaxProductOf4ContinuesNoInArray tmn = new MaxProductOf4ContinuesNoInArray();
	        tmn.findMaxSubArray(num);
	    }
}
