package Exam;

//public class MyException extends Exception {  //  Here Myxecption is checked exception
	public class MyException extends RuntimeException {  // Here Myxecption is Unchecked exception
	
	void someMthod(){
		doStuff();  //
	}
	
	void doStuff() throws MyException
	{
		throw new MyException();
		/*
		try{
			throw new MyException();
		}
		
		catch(MyException e){
			throw e;
			
		}*/
	}
}
