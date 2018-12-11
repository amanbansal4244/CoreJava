package Throws_Throw_Combination;

public class CheckValidation {

	public void validateNum(int n) throws UserException   // if we used throws keyword then always caller will handle these or checked exception
														 // means we need to write try catch block where this method is getting called.
														 // We can throws multiple exception.
	{
		if(n<=40 && n>=20)
		{
			System.out.println("valid no");
		}
		else
		{
			throw new UserException(); //User Defined Exception and we dont need to have catch block bcoz we already used throws keyboard
										//UserException is class name and we shd alws use classname here when we want to throw userdefined exception
		}
	}
	
	public void validateString(String str)
	{
		if(str.length()<=5)
		{
			System.out.println("valid string");
		}
		else
		{
			try {
				throw new StringException(); //User Defined Exception
			} catch (StringException e) {
				// TODO Auto-generated catch block
				e.invalidString();
				e.invalidStringDuplicate();
			}
		}
	}
}
