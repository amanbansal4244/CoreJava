package Palindrome;

import java.util.Arrays;

public class PalindromeInString_WithHelpOfReverseOfString {

	public static void main(String[] args) {
		String str = "bansallasnab";
		char temp[] = new char[str.length()];
		
		int begin = 0;
		int end = temp.length-1;
		char rev[] = new char[str.length()];
		for( int i =0; i< str.length(); i++)
		{
			temp[i]=str.charAt(i); // converted string into char array
		}
		
		for(int j=0; j<(temp.length); j++){
			
			rev[j]=temp[end];
			temp[end]= temp[begin];
			temp[begin]=rev[j];
			begin++;
			end--;
		}
		
		for(int k =0 ; k< rev.length; k++){
			System.out.println(" reverese array"+ " :" + rev[k]);
		}
		
		System.out.println("Is String Palindrome ? :"+Arrays.equals(temp, rev));
	}
}
