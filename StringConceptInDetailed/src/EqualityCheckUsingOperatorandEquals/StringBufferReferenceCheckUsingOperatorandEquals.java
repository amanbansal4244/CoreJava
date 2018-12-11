package EqualityCheckUsingOperatorandEquals;

public class StringBufferReferenceCheckUsingOperatorandEquals {

	public static void main(String[] args) {
		
		StringBuffer s1 = new StringBuffer("aman");
		StringBuffer s2 = new StringBuffer("aman");
		
		System.out.println(s1 == s2);
		
		System.out.println(s1.equals(s2));
		
	}
}
