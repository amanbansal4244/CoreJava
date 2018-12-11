package EqualityCheckUsingOperatorandEquals;

public class StringBuilderReferenceCheckUsingOperatorandEquals {

	public static void main(String[] args) {
		
		StringBuilder s1 = new StringBuilder("aman");
		StringBuilder s2 = new StringBuilder("aman");
		
		System.out.println(s1 == s2);
		
		System.out.println(s1.equals(s2));
		
	}
}
