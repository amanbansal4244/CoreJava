package DataStructure;

public class LinearSearch {
	
	static public void  linearSearch(int[] arr){
		
		int Found_Item = 1; 
		for(int i =0 ; i<= arr.length - 1; i++){
			if(arr[i] == Found_Item){
				System.out.println("searched position " +" " + (i+1));
			}
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		int [] arr = {4,6,2,7,3,9,1};
		linearSearch(arr);
	}
}