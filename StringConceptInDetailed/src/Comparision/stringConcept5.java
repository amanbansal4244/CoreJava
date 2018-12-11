package Comparision;

public class stringConcept5 {

	int a=3;
	byte b=3;
	byte c=8;
	 public void method()
	 {
		 if (a==b)
		 {
			 System.out.println("True");
		 }
		 else
			 System.out.println("false");
	 }
	 
	 
	 public void method1()
	 {
		 if (a==c)
		 {
			 System.out.println("True");
		 }
		 else
			 System.out.println("false");
	 }
	 public static void main(String[] args) {
		stringConcept5 obj = new stringConcept5();
		obj.method();  // Will give True
		obj.method1();  // Will give False
		
	}
}
