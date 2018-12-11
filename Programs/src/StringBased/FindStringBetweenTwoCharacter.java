package StringBased;
/*
We need to find string between two character '#' and '}' 
 */

public class FindStringBetweenTwoCharacter {


	public static void main(String[] args) {

		String input =  "objType : EQUALTO : ${TYPE.CLASS#wt.projmgmt.execution.Milestone}";
		if(input.contains("TYPE.CLASS#")){
			input = input.substring((input.indexOf("#")+1), input.indexOf("}"));
			System.out.println(input);
		}
	}
}
