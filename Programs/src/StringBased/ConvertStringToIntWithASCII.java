package StringBased;

public class ConvertStringToIntWithASCII {
	
	static public void  parseInt(String str) {
	    char[] ch = str.trim().toCharArray();
	    int len = ch.length;
	    int value = 0;
	    for (int i=0, j=(len-1); i<len; i++,j--) {
	        int c = ch[i];
	        if (c < 48 || c > 57) {
	            throw new NumberFormatException("Not a number: "+str);
	        }
	        int n = c - 48;
	        n *= Math.pow(10, j);
	        value = value + n;
	    }
	    System.out.println("after conversion from string to int"+ " : "+ value);
	}
	public static void main(String[] args) {
		
	String s;
	s="5142635";
	System.out.println("befor"+ ":"+ s);
	parseInt(s);
	}

}