package ThreadLocal;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class _2ThreadLocalTest {

    public static void main(String args[]) throws IOException {
        Thread t1 = new Thread(new Task());   
        Thread t2 = new Thread( new Task());
      
        t1.start();
        t2.start();       
      
    }
    
    /*
     * Thread safe format method because every thread will use its own DateFormat
     */
    public static String threadSafeFormat(Date date){
        DateFormat formatter = PerThreadFormatter.getDateFormatter();
        return formatter.format(date);
    }
    
}

