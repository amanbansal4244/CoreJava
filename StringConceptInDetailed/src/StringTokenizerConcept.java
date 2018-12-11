import java.util.StringTokenizer;


 class StringTokenizerConcept {
	public static void main(String[] args) {
	String stri="amna,is,good,java,programmer,Right?";
	StringTokenizer st=new StringTokenizer(stri, ",");
	 System.out.println("The tokens are");
	 System.out.println(st.countTokens());
	 
	 while(st.hasMoreTokens()){
		 
		 System.out.println(st.nextToken());
	 }
	}
}

