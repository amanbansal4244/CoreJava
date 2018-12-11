package Comparision;

public class StringEqualsCompareMethodDifference {
public static void main(String[] args) {
	String s1="Aman";
	String s2="Aman";
	
	if(s1==s2){
		System.out.println("Equal");
	}
	else
	{
		System.out.println("not equals");
	}
	
	String st1=new String("Aman");
	String st2=new String("Aman");
	if(st1==st2){
		System.out.println("Equal");
	}
	else
	{
		System.out.println("not equals");
	}
	
	boolean b=st1.equals(st2);
	System.out.println(b);
	
	
	
	
}
}

