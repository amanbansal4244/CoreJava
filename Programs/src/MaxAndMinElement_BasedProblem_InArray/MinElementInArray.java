package MaxAndMinElement_BasedProblem_InArray;

public class MinElementInArray {

	public static void main(String[] args) {
		
		
		int arr[] = {3,5,2,6,4,9};
		
		int min =arr[0];
		int location =0;
		for(int i =1; i< arr.length; i++){
			if(arr[i] < min){
				min=arr[i];
			}
			//location ++;
			
		}
		System.out.println(" max no " + " " + min );
		}
	}
