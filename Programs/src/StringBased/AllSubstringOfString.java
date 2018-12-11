package StringBased;
import java.util.HashMap;
public class AllSubstringOfString {
	static public void cal(String str){
		int position =0;
		int length =1;
		int count=1;

		while(position<=str.length()){
			while(length <=str.length()){
				System.out.println(str.substring(position, length));
				length ++;
			}
			count ++;
			position++;
			length =count;
		}
	}
	public static void main(String[] args) {
		String str = "aman";
		cal(str);
	}
}
