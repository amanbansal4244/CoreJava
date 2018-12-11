package RotationStringPrograms;

public class RotationOfStringsUsingIndexMethodOfString {

	 static boolean isRotation(String s1,String s2) {
         return (s1.length() == s2.length()) && ((s1+s1).indexOf(s2) != -1);
     }
	 
	 public static void main(String[] args)
	    {
	        String s1 = "JavaJ2eeStrutsHibernate";
	 
	        String s2 = "StrutsHibernateJavaJ2ee";
	 
	        boolean flag=false;
	        
	        	flag= isRotation(s1,s2);
	        	//Step 3
	 
	            if(flag) // Contains method returns true if and only if this string contains the specified sequence of char values.
	            {
	                System.out.println("s2 is a rotated version of s1");
	            }
	            else
	            {
	                System.out.println("s2 is not rotated version of s1");
	            }
	        }
}