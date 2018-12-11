
public class AutoBoxingConcept 
{	
public static void main(String[] args) {
		
		int i = 10;
		
		Integer I = new Integer(i); // under jdk 1.4
		
		//The above statement is replaced by Autoboxing (jdk1.5)
		
		Integer II = i;
		
		
		System.out.println("II = "+II+"\t i = "+i);
		
		//int ii = Integer.valueOf(I);
		int ii = II; //Unboxing
		
		System.out.println("ii = "+ii);
		

	}
}
