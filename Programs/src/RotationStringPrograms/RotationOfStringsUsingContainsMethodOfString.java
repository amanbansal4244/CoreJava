package RotationStringPrograms;
//(eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)
public class RotationOfStringsUsingContainsMethodOfString {

	 public static void main(String[] args)
	    {
	        String s1 = "JavaJ2eeStrutsHibernate";
	 
	        String s2 = "StrutsJavaHibernateJ2ee";
	 
	        //Step 1
	 
	        if(s1.length() != s2.length())
	        {
	            System.out.println("s2 is not rotated version of s1");
	        }
	        else
	        {
	            //Step 2
	 
	            String s3 = s1 + s1; // s3 would be "JavaJ2eeStrutsHibernateJavaJ2eeStrutsHibernate"
	 
	            //Step 3
	 
	            if(s3.contains(s2)) // Contains method returns true if and only if this string contains the specified sequence of char values.
	            {
	                System.out.println("s2 is a rotated version of s1");
	            }
	            else
	            {
	                System.out.println("s2 is not rotated version of s1");
	            }
	        }
	    }
	}