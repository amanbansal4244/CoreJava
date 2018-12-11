package Palindrome;

/*Find the longest palindrome from a given string.
 * Palindrome in Java. ... A string is a palindrome if it remains unchanged when reversed, 
 * for example, "dad" is a palindrome as reverse of "dad" is "dad" whereas "program" isn't a palindrome 
 * as its reverse is “margorp”. Some other examples of palindrome strings are "mom", "madam", "abcba", “12321”, "c++&++c".

In this approach, we will compare first element with last element and check whether both 
are equals or not.If both are equals then we will increment first pointer by one and 
decrement last pointer by 1 and process goes on.
*/public class LongestPalindromeSubstring
{
	static int longestPalSubstr(String str) {

		char ch[] = str.toCharArray();

		int startingIndex =0;
		int endingIndex =str.length()-1	;
		int currLength = 0;
		int maxIndex = 0;
		int currIndex = 0;
		boolean flag = true;
		while(startingIndex < endingIndex){
			if(ch[startingIndex] == ch[endingIndex])
			{
				currLength = currLength +2; // incrementing by 2, just to print total length of Palindrome string because
				// we will be traversed only half of Palindrome string.
				if(flag){
					currIndex = startingIndex;
					maxIndex = endingIndex;
				}
				flag = false;
			}else{
				currLength=0;
				flag = true;
			}
			startingIndex++;
			endingIndex--;
		}

		System.out.print("Longest palindrome substring is: " + str.substring(currIndex, maxIndex+1)+"\n");

		return currLength;
	}

	// Driver program to test above function
	public static void main(String[] args) {

		String str = "forgeeksskeegfor";
		System.out.println("Length is: " + 
				longestPalSubstr(str));
	}

}
