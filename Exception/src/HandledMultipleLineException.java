
public class HandledMultipleLineException {

 public void method()
 {
	try{
		try{
			try{
				//line 3
			}
			catch(Exception e)
			{
				
			}
			
			//line 2
		}
		catch(Exception e)
		{
			
		}
		//line1
	}
	catch(Exception e)
	{
		
	}
	
	finally{
		try{
		}
		catch(Exception e)
		{
			
		}
	}
}
}
