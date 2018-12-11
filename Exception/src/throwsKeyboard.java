class throwsKeyboard
 {
	public void throwMethod() throws NullPointerException
	{
		 System.out.println ("Inside throwMethod");
		
		 //throw new NullPointerException ("Demo");
	}
	 
	
	public void throwMethod11() throws ArithmeticException{
		
		System.out.println(2/0);
		
	}
	
	 public static void main(String args[])
	 {
		 throwsKeyboard obj=new throwsKeyboard();
		 obj.throwMethod(); 	// If we throws some exception but method doesnt have any case to throw that exception that
								// time we dont need to handle exception
		
		 //obj.throwMethod11();
		 try
		 {
		 obj.throwMethod11();    // In this case need to handle exception bcoz throwMethod11() thorowing 
		 }
		 catch (ArithmeticException exp)
		 {
		 System.out.println ("The exception get caught"+" " +exp);
		 }
	 }
 }
