import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

  
public class UnzipUtilityTest {
    public static void main(String[] args) throws IOException {
    	
    	InputStreamReader isr = new InputStreamReader(System.in);
    	BufferedReader br = new BufferedReader(isr);
    	System.out.println("Enter only zip file name:");
        String temp=br.readLine();
        
        String zipFilePath="C:/Users/Bansal/Downloads/Compressed/"+temp;
 
        String[] movieName=zipFilePath.split(".zip");
        String destDirectory=movieName[0];
        
        UnzipUtility unzipper = new UnzipUtility();
        try {
            unzipper.unzip(zipFilePath, destDirectory);
        } catch (Exception ex) {
            // some errors occurred
            ex.printStackTrace();
        }
        
        
        
    }
    
    
}