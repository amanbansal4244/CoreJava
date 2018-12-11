import java.util.ArrayList;
import java.util.List;
import java.util.Random;
 
  
 // Set VM argument to -Xmx100m to have java.lang.OutOfMemoryError: Java heap space
class OutOfMemoryError {
    private static Random rnd = new Random();
    private static final int MEGA = 1024*1024;
  
    private static String createRandomStr(int length){
        StringBuilder sb = new StringBuilder(length);
        for(int i=0;i<length;i++)
            sb.append((char)('a'+rnd.nextInt('z'-'a'+1)));
        return sb.toString();
    }
  
    public static void main(String[] args){
        List<String> substrings = new ArrayList<String>();
        for(int i=0;i<100;i++){
            String randomStr = createRandomStr(MEGA);
            String subStr = randomStr.substring(1000,1004); // will give java.lang.OutOfMemoryError: Java heap space
           //String subStr = randomStr.substring(1000,1004).intern();// Will save java.lang.OutOfMemoryError: Java heap space
            substrings.add(subStr);
        }
    }
}