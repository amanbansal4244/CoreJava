package OnlineProblem;
import java.util.StringTokenizer;

//Problem statement
//https://www.hackerrank.com/challenges/java-regex

public class CheckIPAddress {

	public static void main(String[] args) {
		String str="000.1222.12.034";
		boolean isIP=true;
		StringTokenizer st = new StringTokenizer(str,".");
		
		
		
		while(st.hasMoreTokens()){
			int no = Integer.parseInt(st.nextToken());
			if( st.countTokens() > 4 || st.nextToken().length() > 3 || no > 255 ){
				isIP=false;
			}
		}
		
		if(isIP){
			System.out.println("true");
		}
		else{
			System.out.println("false");
		}
	}
}
