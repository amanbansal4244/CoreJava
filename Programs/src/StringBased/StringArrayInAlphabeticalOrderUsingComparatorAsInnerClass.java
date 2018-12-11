package StringBased;
import java.util.Arrays;
import java.util.Comparator;


public class StringArrayInAlphabeticalOrderUsingComparatorAsInnerClass {

	public static void main(String[] args) {
		String str[] ={"aman", "df", "rt", "ab"};
		
		for(int i=0; i< str.length;i++){
			System.out.println("before"+ " "+ str[i]);
		}
		
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int result = -1;
				try{
				result = o1.compareTo(o2);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return result;
			}
			
		});
		
		
		for(int i=0; i< str.length;i++){
			System.out.println("After"+ " "+ str[i]);
		}
		
	}
}
