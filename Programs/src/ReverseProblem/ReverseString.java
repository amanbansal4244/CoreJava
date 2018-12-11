package ReverseProblem;

public class ReverseString {

	public static void main(String[] args) {
		String s ="string";
		String revRes = "";
	
		for(int i =s.length()-1; i>= 0; i-- ){
			
			revRes=revRes+s.charAt(i);
		
		}
		System.out.println(revRes);
	}
  }
