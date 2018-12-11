package AccessPrivateMethod;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class AccessPrivate {
	public static void main(String[] args)throws Exception{  
		  
		Class c=Sample.class; 
		Object o= c.newInstance();  
		
		//To call non-parameterized method
	    Method m =c.getDeclaredMethod("message", null);  //message is private method name.
	    //Turn off access check for this field
	    m.setAccessible(true);  
	    m.invoke(o, null);  //The null indicates there are no parameters being passed to the foo method.
	    

		//To call parameterized method
	    //Here the method takes a int parameter if there is no param, put null.
	    Method m1=c.getDeclaredMethod("cube",new Class[]{int.class});  //cube is private method name.
	    m1.setAccessible(true);  
	    m1.invoke(o,4); 
	    
	    
	   //to get private field
	    Field privateStringField = Sample.class.getDeclaredField("str");//str is private string name
	    //Turn off access check for this field
	    privateStringField.setAccessible(true);
	    String fieldValue = (String) privateStringField.get(o);
	    System.out.println("fieldValue = " + fieldValue);
	    
	    
	    //First change string value of private field and then get private field
	    Field privateStringField1 = Sample.class.getDeclaredField("str1");//str is private string name
	    //Turn off access check for this field
	    privateStringField1.setAccessible(true);
	    privateStringField1.set(o, "change aman to bansal");
	    String fieldValue1 = (String) privateStringField1.get(o);
	    System.out.println("Changed String Value = " + fieldValue1);
	    
	   
	    //First change boolean value of private field and then get private field
	    Field f = c.getDeclaredField("b");
	    f.setAccessible(true); //solution
	    f.setBoolean(o, false); // IllegalAccessException
	    boolean value= (boolean) f.get(o);
	    System.out.println("Changed Boolean Value = " + value);
	    
	}  
}
