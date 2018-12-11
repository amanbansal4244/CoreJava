package StringBased;
public class AllCombinationOfString {
		static int count=0;
		 public static  String[] permute( String str)
		    {
		        int inputLength = str.length();
		        int total= permutation(str.length());
		        String res1[] = new String[total];
		        boolean[ ] used = new boolean[ inputLength ];
		        StringBuffer outputString = new StringBuffer();
		        char[ ] in = str.toCharArray( );
		       String res[]= doPermute ( in, outputString, used, inputLength, 0,res1);
		        return res;
		    }
		    public static    String[] doPermute ( char[ ] in, StringBuffer outputString,
		    boolean[ ] used, int inputLength, int level,String res1[])
		    {
		        if( level == inputLength) {
		            res1[count]=outputString.toString();
		            count++;
		        }
		        for( int i = 0; i < inputLength; ++i )
		        {
		            if( used[i] ) continue;
		            
		            outputString.append( in[i] );
		            used[i] = true;
		            doPermute( in,   outputString, used, inputLength, level + 1, res1);
		            used[i] = false;
		            outputString.setLength(   outputString.length() - 1 );
		        }
				return res1;
		    }
		  public static int permutation(int inputLength){
			  int n = inputLength;
			  int r=inputLength;
			  
			  int per=(fact(n)/(fact(n-r)));
			  return per;
		  }
		  public static int fact(int num)
			{
			int fact=1,i;
			for(i=1;i<=num;i++)
			fact=fact*i;
			return fact;
			}
		  public static void main(String[] args) {	
			AllCombinationOfString s = new AllCombinationOfString();
			String str="ABCD";
			String ss[]=s.permute(str);
			for(int j =0; j<ss.length;j++){
				System.out.println(ss[j]);
			}
			
		}
	}