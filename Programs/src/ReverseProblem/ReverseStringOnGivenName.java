package ReverseProblem;
/*
Want to find one string from input and reverse that found string

Ex. String str = "amrahulan"; 
	search string "rahul" , if match found reverse it 
	o/p: luhar
*/
public class ReverseStringOnGivenName {
	public static void reverseWithoutInbuiltFunction(String str, String searchString){
		char givenChar[] = str.toCharArray();
		char searchChar[] = searchString.toCharArray();
		int maxLength = 0;
		int currLength = 0;
		int maxIndex = 0;
		int currIndex = 0;
		int z = 0;
		String reverse = " ";
		boolean flag = false;
		for(int i = 0; i < str.length(); i++){
			if(z < searchChar.length/*when z goes beyond of search string length*/ && givenChar[i]  == searchChar[z]){
				if(flag == true){
					currLength++;
					z++;
				}
				else{
					currIndex = i;
					currLength = 1;
					flag = true;
					z++;
				}
			}else{
				if(currLength > maxLength){
					maxLength = currLength;
					maxIndex = currIndex;
				}
				flag = false;
				z =0 ;
			}
		}
		
		int reverseStringLength = maxIndex + maxLength;
		
		for(int r =reverseStringLength-1; r>=reverseStringLength-maxLength; r--){
			reverse = reverse + givenChar[r];
		}
		
		System.out.println("Reverse Given Searched String From Given Array: " + reverse);
	
	}
	
	public static void main(String[] args) {
		String str = "amrahulan";
		reverseWithoutInbuiltFunction(str, "rahul");
	}
}
