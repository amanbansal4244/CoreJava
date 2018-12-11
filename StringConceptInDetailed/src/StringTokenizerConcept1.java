import java.util.StringTokenizer;


 class StringTokenizerConcept1 {
	
	public static void main(String[] args) {
		String str="Aman";
		String str1="AmanBansal";
		System.out.println("hii");
		
		StringTokenizer st=new StringTokenizer(str1, "B");
		
		/*while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}*/
		
		
			String [] stArray= new String[6];
			for(int i=0;i<st.countTokens();i++){
				stArray[i]=st.nextToken();
				
				//System.out.println(stArray[0]);
		
			String ii=stArray[0];
			System.out.println(ii);
			if(str.equals(ii))
			{
				
				System.out.println("true");
			}
			else
			{
				System.out.println("false");
			}
			
		}
	}

	

	
}
