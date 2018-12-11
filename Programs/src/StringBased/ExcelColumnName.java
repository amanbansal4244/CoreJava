package StringBased;
/*Find Excel column name from a given column number
MS Excel columns has a pattern like A, B, C, … ,Z, AA, AB, AC,…. ,AZ, BA, BB, … ZZ, AAA, AAB ….. etc. In other words, column 1 is named as “A”, 
column 2 as “B”, column 27 as “AA”.

Given a column number, find its corresponding Excel column name. Following are more examples.

Input          Output
 26             Z
 51             AY
 52             AZ
 80             CB
 676            YZ
 702            ZZ
 705            AAC
 Suppose we have a number n, let’s say 28. so corresponding to it we need to print the column name. We need to take remainder with 26.

If remainder with 26 comes out to be 0 (meaning 26, 52 and so on) then we put ‘Z’ in the output string and 
new n becomes n/26 -1 because here we are considering 26 to be ‘Z’ while in actual it’s 25th with respect to ‘A’.

Similarly if the remainder comes out to be non zero. (like 1, 2, 3 and so on) then we need to just insert the char accordingly 
in the string and do n = n/26.

Finally we reverse the string and print.
 */
public class ExcelColumnName {
	static public void printString(int n)
	{
	    char str[] = new char[50];  // To store result (Excel column name)
	    int i = 0;  // To store current index in str which is result
	  String reverse = null;
	    while (n>0)
	    {
	        // Find remainder
	        int rem = n%26;
	 
	        // If remainder is 0, then a 'Z' must be there in output
	        if (rem==0)
	        {
	            str[i++] = 'Z';
	            n = (n/26)-1;
	        }
	        else // If remainder is non-zero
	        {
	            str[i++] = (char) ((rem-1) + 'A');// count acc ASCII value, A at 65th position. and Z at 90th position.
	            n = n/26;
	        }
	    }
	   // str[i] = '\0';
	 
	    for ( int j = str.length - 1 ; j >= 0 ; j-- ){
	         reverse = reverse + str[j];
	    }
	    // Reverse the string and print result
	    System.out.println(reverse);
	  
	}
	public static void main(String[] args) {
		printString(26);
	    printString(51);
	    printString(52);
	    printString(80);
	    printString(676);
	    printString(702);
	    printString(705);	
	   /* Output

	    Z
	    AY
	    AZ
	    CB
	    YZ
	    ZZ
	    AAC*/
	}
}
