package DataStructure;
// swap har bar bar so log(n2) swaping.
public class BubbleSort {

	static public void bubbleSort(int[] arr){
		
		int n = arr.length;
		int i, j=0;
		
		for( i=0; i< n-1; i++){ // for no of times 
			for(j=0; j<n-i-1;j++){ // jitni bar i ka loop chalega usse ek bar kam chalega j ka loop bcoz har i ki ek iteration m 
									//ek biggest element last m set hota jayega
				if(arr[j] > arr[j+1]) // har bar 2 element ko compare kregene and swap krenge har bar if condition met
				{	
				int temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
				}
			}
			
			for( j=0; j< n ; j++){
				System.out.println(arr[j]);
			}
		}
		
	}
	public static void main(String[] args) {
		int [] arr = {4,6,2,7,3,9,1};
		bubbleSort(arr);
	}
}
