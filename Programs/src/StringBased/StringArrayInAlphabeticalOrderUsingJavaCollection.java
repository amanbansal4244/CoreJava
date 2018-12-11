package StringBased;
import java.util.Arrays;
import java.util.Collections;


public class StringArrayInAlphabeticalOrderUsingJavaCollection {

	public static void main(String[] args) {
		String str[] ={"aman", "df", "rt", "ab"};
		
		for(int i=0; i< str.length;i++){
			System.out.println("before"+ " "+ str[i]);
		}
		
		Arrays.sort(str);
		
		for(int i=0; i< str.length;i++){
			System.out.println("After"+ " "+ str[i]);
		}
		
	}
}
