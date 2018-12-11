package Comparision;

public class stringConcept6 {

	public static void main(String[] args) {
		 stringConcept6 a= new stringConcept6();
		 stringConcept6 b= new stringConcept6();
		 stringConcept6 c=a;
		 
		 
		 if (a==b)
		 {
			 System.out.println("true");
		 }
		 else{
			 System.out.println("false");
		 }
		 
		 if (a==c)
		 {
			 System.out.println("true");
		 }
		 else{
			 System.out.println("false");
		 }
		 
		 if (c==b)
		 {
			 System.out.println("true");
		 }
		 else{
			 System.out.println("false");
		 }
	}
}
