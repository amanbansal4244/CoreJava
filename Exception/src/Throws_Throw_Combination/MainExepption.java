package Throws_Throw_Combination;


public class MainExepption {
	public static void main(String[] args) {
		CheckValidation obj=new CheckValidation();
		
		
		// Need to write try catch block bcoz we used throws keyboard to throw exception in validateNum method
		/*try {     
			obj.validateNum(67);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.invalidNum();
			//System.out.println("invalid range");
		}*/
		
		obj.validateString("hjdddg");
	}
}
