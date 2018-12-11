package StringBased;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;



public class CountTheNumberOfWordsInAString_AndSaveAsKEyValuePair {
	public static void main(String[] args) {
		String str ="   aman   ban   sal   ";
		char ch[] = str.toCharArray();
		int count =0;
		
		//Below logic just to count the words in string array
		for(int i =0 ; i<str.length()-1 ; i++){
			if(ch[i] == ' ' && ch[i+1] != ' '){
				count++;
			}
		}
		
		System.out.println("Total No Of Words In A String:" + count);
		
		//Below logic to store words as per no of occurrences in key value pair
		HashMap<String, Integer> hm = new HashMap<>();
		String[] nameParts = str.split(" ");
		for(String part: nameParts) {
			for(int i =0 ; i<str.length() ; i++){
				if(ch[i] == ' ' && ch[i+1] != ' '){
					if(hm.containsKey(part)){
					hm.put(part, hm.get(part)+1);
					}else{
						hm.put(part, 1);
					}
				}
			}
		}

			Set set = hm.entrySet();
			Iterator itr = set.iterator();
			
			while(itr.hasNext()){
				java.util.Map.Entry me=(java.util.Map.Entry)itr.next();
				System.out.println("Key:"+ me.getKey());
				System.out.println("Value:"+ me.getValue());
				
			}
		
	}
}
