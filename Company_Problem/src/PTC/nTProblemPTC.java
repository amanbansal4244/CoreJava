package PTC;
/*
.Given an input string S write a function which returns true if it satisfies S = nT. Basically you have to find if a given string can be represented from a substring by iterating it �n� times. n >= 2
An example would suffice 
Function should return true if
1) S = abab
2) S = abcdabcd
3) S = abcabcabc
4) S = zzxzzxzzx
Function should return false if
1) S = abac
2) S = abcdabbd
3) S = abcabcefg
4) S = zzxzzyzzx*/
 
public class nTProblemPTC {
	
	static boolean doesStringHasPattern(String givenString){
		boolean doesStringHasPattern=false;
		char str[]= givenString.toCharArray();
        int kmp[] = buildKMP(str);
        int index = kmp[str.length-1];
        //reason end is this rather than index+1 because
        //if our string was ababab for KMP we would have index as 4 at str.length-1 and we
        //want end to be 1 rather than 5
        int end = str.length - index-1;
        if(end >= str.length/2){
            return doesStringHasPattern;
        }
        int j = end+1;
        int i = 0;
        while(j < str.length){
            if(str[i] != str[j]){
                return doesStringHasPattern;
            }
            i = (i+1)%(end+1);
            j++;
        }
        
        if(i == 0){
        	doesStringHasPattern=true;
            return doesStringHasPattern;
        }
        return doesStringHasPattern;
    }
    
    private static int[] buildKMP(char str[]){

        int result[] = new int[str.length];
        
        int i =1;
        result[0] = 0;
        int len =0;
        while(i < str.length){
            if(str[i] == str[len]){
                len++;
                result[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = result[len-1];
                }else{
                    len =0;
                    result[i] = 0;
                    i++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
    	nTProblemPTC obj = new nTProblemPTC();
    	System.out.println(obj.doesStringHasPattern("abcdabbd"));
       // System.out.println(obj.match("abcdabbd".toCharArray()));
	}
}
