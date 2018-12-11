package Exam;

public class Ques2 {

	public static void main(String[] args) {
	
		//Case1:
	//	new Ques2().go();  // Will complie and give StackOverFlowError
	
	
	//Case2:	
	try{
		new Ques2().go(); //Will complie and Print aman
	}
	catch(Error e)
	{
		System.out.println("aman");
	}
		
	
	//Case3:
		/*try{
			new Ques2().go();   //Will complie and StackOverflowError
								//Bcoz Exception is not a super class of Error,Catching an Exception  will not help handle an Error
		}
		catch(Exception e)
		{
			System.out.println("aman");  
		}*/
		
		
	}
	
	void go()
	{
		go();
	}
}
