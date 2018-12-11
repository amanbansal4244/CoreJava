package Palindrome;

	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.Map;
	import java.util.Set;

	public class PalindromeSubStringOneTimeOccur {

		static public int cal(String str){
			String finalRes;
			int position =0;
			int length =1;
			int countSubstringNo=0;
		
			int count=1;
			HashMap hm = new HashMap();
			while(position<=str.length()){
				while(length <=str.length()){
					
					if(hm.containsKey(str.substring(position, length))){
						hm.put(str.substring(position, length), 1);
					}
					else{
						hm.put(str.substring(position, length) ,1);
					}
				length ++;
				
				}
			count ++;
			position++;
			length =count;
			}
			
			Set s = hm.entrySet();
			Iterator i = s.iterator();
			while(i.hasNext()){
				Map.Entry me=(Map.Entry)i.next();
				finalRes = (String) me.getKey();
				
				if(finalRes.equals(reverseString(finalRes))){
					countSubstringNo++;
				}
			}
			return countSubstringNo;
			
		}
		
		public static  String reverseString(String s){
			
			String revRes = "";
			char[] rev= new char[s.length()];
			int j =0;
			for(int i =s.length()-1; i>= 0; i-- ){
				
				revRes=revRes+s.charAt(i);
				j++;
			}
			return revRes;
		}
		public static void main(String[] args) {
			
			String str = "bansssal";
			int res =cal(str);
			System.out.println(res);
		}
	}

