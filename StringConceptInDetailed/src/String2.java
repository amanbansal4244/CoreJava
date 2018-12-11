
 class String2 {
	
	String s="Aman";
	String s1="AmanBansal";
	
	public boolean method()
	{
		boolean b=s.equals(s1);
		return b;
		
		
	}
	
	public boolean method1(){
		
		String result=s1.replaceAll(s1, s);
		System.out.println(result);
	//String sub=s1.substring(0,4);
		//System.out.println(sub);
		boolean b1=	s.equals(result);
		return b1;
	}
	public static void main(String[] args) {
		String2 obj=new String2();
		boolean res=obj.method1();
		System.out.println(res);
		
		//obj.method1();
	}
}
