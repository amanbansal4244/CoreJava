package ArrayBased;
import java.util.TreeSet;

/*Telephone Words

People often give others their telephone number as a word representing the seven-digit number. For example, if my telephone number were 866-2665, I could tell people my number is “TOOCOOL,” instead of the hard-to-remember seven-digit number. Note that many other possibilities (most of which are nonsensical) can represent 866-2665. You can see how letters correspond to numbers on a telephone keypad. 

Write a routine that takes a seven-digit telephone number and prints out all of the possible “words” or combinations of letters that can represent the given number. Because the 0 and 1 keys have no letters on them, you should change only the digits 2–9 to letters. You’ll be passed an array of seven integers, with each element being one digit in the number. You may assume that only valid phone numbers will be passed to your routine. You can use the helper routine
char getCharKey( int telephoneKey, int place )
which takes a telephone key (0–9) and a place of either 1, 2, 3 and returns the character corresponding to the letter in that position on the specified key. For example, GetCharKey(3, 2) will return ‘E’ because the telephone key 3 has the letters “DEF” on it and ‘E’ is the second letter.
*/
public class TelephoneWords {
	static final int PHONE_NUMBER_LENGTH = 7;
	static TreeSet<String> allPermutations1=new TreeSet<String>();
	 private static final char keys[][]={
	      {'0','0','0'},
	      {'1','1','1'},
	      {'A','B','C'},
	      {'D','E','F'},
	      {'G','H','I'},
	      {'J','K','L'},
	      {'M','N','O'},
	      {'P','R','S'},
	      {'T','U','V'},
	      {'W','X','Y'}
	  };
	      
	  
	  private static final char getCharKey(int telephoneKey,int place){
	    if(place <1 || place >3) throw new IllegalArgumentException("Argument 'place' is between 1-3 (both inclusive)");
	    if(telephoneKey <0 || telephoneKey >9) throw new IllegalArgumentException("Argument 'telephoneKey' is between 0-9 (both inclusive)");
	   	
	    return keys[telephoneKey][place-1]; 
	  }
	  
	  static TreeSet<String> generatePermutations(int[] telephoneNumber) {
			TreeSet<String> allPermutations=new TreeSet<String>(); // I want unique sorted permutations
			
			char[] result = new char[ PHONE_NUMBER_LENGTH ];

			allPermutations=  doPrintTelephoneWords( telephoneNumber, 0, result );
	      // your code goes here 
	      
	      
	      	return allPermutations;
	    }
	  
	  
	
		static TreeSet<String> doPrintTelephoneWords( int[] phoneNum, int curDigit,
		                           char[] result ){
			
			
			
		   if( curDigit == PHONE_NUMBER_LENGTH ){
		   //  System.out.println( new String( result ) );
		     allPermutations1.add(new String( result ));
		   return allPermutations1;
		   }

		   for( int i = 1; i <= 3; i++ ){
		       result[ curDigit ] = getCharKey( phoneNum[curDigit], i );
		       doPrintTelephoneWords( phoneNum, curDigit + 1, result );
		       if( phoneNum[curDigit] == 0 ||
		           phoneNum[curDigit] == 1) 
		    	   {
		    	   allPermutations1.add(new String( result ));
				 // return allPermutations1;
		    	   }
		    	  
		   }
		return allPermutations1;
		}
		   
		   
	  public static void main(String[] args) {
		TelephoneWords obj = new TelephoneWords();
		int [] no={8,6,6,2,6,6,5};
		obj.generatePermutations(no);
	}
}
