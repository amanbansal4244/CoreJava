package TypeInterferencePackage;

public class TypeInterferenceExample {

	
	public static void printLambda (StringLengthFunction l){
		System.out.println(l.getLength("hello world"));
	}
	
	public static void main(String[] args) {
		StringLengthFunction stringLengthFunction = s ->s.length();
		System.out.println(stringLengthFunction.getLength("amanbansal")); // 1st approach
		
		printLambda(stringLengthFunction); // 2nd approach
		
	}
	
	interface StringLengthFunction {
		int getLength(String s);
		
	}
}
