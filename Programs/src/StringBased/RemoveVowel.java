package StringBased;

public class RemoveVowel {

//|| str.charAt(i) == 'e'|| str.charAt(i) == 'i' || str.charAt(i) == 'o' ||str.charAt(i) == 'u'
	static public void removeVowel(String str){
		
		for(int i=0; i< str.length();i++){	
			
			switch (str.charAt(i)) {
			case 'a':
				str=str.replaceAll("a","");
			case 'e':
				str=str.replaceAll("e","");
			case 'i':
				str=str.replaceAll("i","");
			case 'o':
				str=str.replaceAll("o","");
			case 'u':
				str=str.replaceAll("u","");
			default:
				break;
			}
			
		}
		
		System.out.println(str);

		
	}
	
	public static void main(String[] args) {
		
		String str = new String("amanbausinale");
		removeVowel(str);
	}
}
