
public class ArithmeticException1 {

	public static void main(String[] args) {
		divideByZero(2);
	}
	
	public static void divideByZero(int a){
		try{
			System.out.println(a/0);
		}
		catch(ArithmeticException ae){
			
			System.out.println("you cant do that");
			System.out.println(ae.getMessage()); // will print cause of the exception   // / by zero
			System.out.println(ae.toString()); //java.lang.ArithmeticException: / by zero
			ae.printStackTrace(); // all the info and also showing where is the exactly problem
		}
	}
}
