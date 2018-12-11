package EqualityCheckUsingOperatorandEquals;

import java.util.LinkedHashMap;

public class StringReferenceCheckUsingOperatorandEquals {

	public static void main(String[] args) {
		String s1 = "aman";
		String s2 = "aman";
		
		String s3 = new String("aman");
		String s4 = new String("aman");
		
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s2 == s3);
		System.out.println(s3 == s4);
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s2.equals(s3));
		System.out.println(s3.equals(s4));
		
	}
}
