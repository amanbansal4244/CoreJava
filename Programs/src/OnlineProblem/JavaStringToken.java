package OnlineProblem;
//Problem statement
//https://www.hackerrank.com/challenges/java-string-token
//!,?._'@".


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class JavaStringToken {

	
	
	public static void main(String[] args) {
		//String str="He is a very v@ery go!od boy, isn't he?";
		
		
		System.out.println("Enter STring:");
		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		
		String str = null;
		try {
			str = inp.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		StringTokenizer st = new StringTokenizer(str, " ,'!._@?"); // we can give multiple checks together in string tokenizer
		System.out.println(st.countTokens());
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
	}
}
