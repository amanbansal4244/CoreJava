package MaxAndMinElement_BasedProblem_InArray;

public class MaxElementInArray {
	public static void main(String[] args) {
		
	
	int arr[] = {11,3,5,2,6,4,39};
	
	int max =arr[0];
	int location =1;
	for(int i =1; i< arr.length; i++){
		if(arr[i] > max){
			max=arr[i];
		}
		
		//location ++;
	
	}
	System.out.println(" max no " + " " + max);
	}
}
