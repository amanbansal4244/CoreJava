package ReverseProblem;

public class ReverseANumber {


	public int reverseNumber(int number){
		int b=0;
		int reverse=0;
		while( number !=0)
		{
			b = number%10;// gives remainder
			number = number/10;// gives result
			reverse = reverse*10+b;
		}

		return reverse;
	}

	public static void main(String a[]){
		ReverseANumber nr = new ReverseANumber();
		System.out.println("Result: "+nr.reverseNumber(123));
	}
}
	