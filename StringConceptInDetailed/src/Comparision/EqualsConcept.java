package Comparision;


//Concept:  equals always compares the object and null is not an object.
  //        If you compare null in equals then it will give null pointer exception
				//means before dot if we have null using equals-> Awls will have null pointer exception
						// null.equals("aman");
				// but after dot we can have null in bracket using equals
						//str.equals(null);
 //         We can not compare null to anything except ==,if u try to compare except == will always give null pointer exception
public class EqualsConcept {

	public void Check()
	{
		String str=" ";
		if(str.equals(" ") || str.equals(null))
		{
			System.out.println("Success");
		}
		else{
			System.out.println("Failed");
		}
	}
	public void check1()
	{
		String str=" ";
		if(str.equals(null) || str.equals(" "))
		{
			System.out.println("Success No");
		}
		else{
			System.out.println("Failed");
		}
	}
	public void check2()
	{
		String str=null;
		if(str.equals(" ") || str.equals(null))
		{
			System.out.println("Success");
		}
		else{
			System.out.println("Failed");
		}
	}
	public void check3()
	{
		String str=null;
		if((str==null) || str.equals(" "))
		{
			System.out.println("Success");
		}
		else{
			System.out.println("Failed");
		}
	}
	
	public void check4()
	{
		String str=null;
		if(str.equals(" ") || (str==null) )
		{
			System.out.println("Success");
		}
		else{
			System.out.println("Failed");
		}
	}
	public static void main(String[] args) {
		EqualsConcept obj=new EqualsConcept();
		obj.Check();	// Success
	   // obj.check1();	// Success No
	    //obj.check2();	// Null Pointer Exception
	    //obj.check3();	// Success
	   //obj.check4();   // Null Pointer Exception
	}
}
