package Comparision;

public class StringEqualsCompareMethodDifference3 {
public static void main(String[] args) {
	String s1="Aman";
	String s2="Ama";
	
	System.out.println(s1.hashCode());
	System.out.println(s2.hashCode());
	
	String st1=new String("Aan");
	String st2=new String("Aman");
	System.out.println(st1.hashCode());
	System.out.println(st2.hashCode());
	
	
	
	String s3="An";
	String st3=new String("Aman");
	System.out.println(s3.hashCode());
	System.out.println(st3.hashCode());
}
}