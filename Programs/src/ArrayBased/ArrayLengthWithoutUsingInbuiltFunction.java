package ArrayBased;

public class ArrayLengthWithoutUsingInbuiltFunction {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,};
		
		System.out.println("Array length with using in built function"+ "="+ arr.length);
		int count =0;
		for(int i : arr){
			count++;
		}
		
		System.out.println("Array length without using in built function"+ "="+count);
	}

}
