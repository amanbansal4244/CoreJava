package ReverseProblem;

public class ReverseArray_ConstantSpace {

	static void swap(int []a, int i, int j){ 
        int t = a[i];
        a[i] = a[j]; 
        a[j] = t; 
    }
	
	public static void main(String[] args) {

		int arr[] = {3,5,2,6,4,9,23};

		int left =0;
		int right = arr.length-1;
		while(left < right){

			swap(arr, left, right);
			left++;
			right--;
		}

		for(int i =0; i < arr.length ; i++){
			System.out.println("reverse array: " + arr[i]);
		}
	}
}
