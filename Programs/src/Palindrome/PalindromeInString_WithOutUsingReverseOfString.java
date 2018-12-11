package Palindrome;
/*
In this approach, we will compare first element with last element and check whether both 
are equals or not.If both are equals then we will increment first pointer by one and 
decrement last pointer by 1 and process goes on.... 
*/

public class PalindromeInString_WithOutUsingReverseOfString {

	public static void main(String[] args) {
		String str = "bansallasnab";
		char [] ch = str.toCharArray();
		int left = 0;
		int right = str.length()-1;
		boolean flag = true;
		while(left <right){
			if(ch[left] != ch[right]){
				System.out.println("String is not Palindrome");
				flag = false;
				break;
			}else{
				left++;
				right--;
			}
		}
		
		if(flag){
			System.out.println("String is Palindrome!");
		}
	}
}
