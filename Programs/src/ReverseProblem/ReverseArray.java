package ReverseProblem;

public class ReverseArray {

	
	public static void main(String[] args) {
		int arr[] = {3,5,2,6,4,9};
		int rev[]= new int[arr.length];
		int j=0;
		for(int i=arr.length-1; i>=0 ; i--){
			
			rev[j]=arr[i];
			j++;
			
		}
		for(int k=0; k< j; k++){
		System.out.println(rev[k]);
		}
		
	}
}
