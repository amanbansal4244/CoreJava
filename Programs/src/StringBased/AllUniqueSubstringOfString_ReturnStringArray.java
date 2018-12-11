package StringBased;
import java.util.HashSet;
import java.util.Iterator;


public class AllUniqueSubstringOfString_ReturnStringArray {
	static public  String [] cal(String str){
		int position =0;
		int length =1;
		int count=1;
		HashSet<String> set = new HashSet<>(); // We preferred HashSet because we want unique substring of string in this case.

		while(position<=str.length()){
			while(length <=str.length()){
				set.add(str.substring(position, length));
				length ++;
			}
			count ++;
			position++;
			length =count;
		}
		
		String[] list = new String[set.size()];
		int k =0;
		
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()){
			list[k] =  itr.next();
			k++;
		}
		return list;
	}
	public static void main(String[] args) {
		String str = "aman";
		String[] str1 = cal(str);
		for(int i=0; i< str1.length; i++){
			System.out.println(str1[i]);
		}
	}
}
