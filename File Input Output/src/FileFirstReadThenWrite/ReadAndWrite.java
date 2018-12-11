package FileFirstReadThenWrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*Input:
 *  READ a file name input which has below data:
		cdk||global
		aman|34|bansal

Output: file name should be reverse: reverss the line ang cnahge |(pipe) symbol with ,(comma)
	  kdc,labolg
  	  nama,43,lasnab

*
*/
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ReadAndWrite {

	 static FileWriter fileWriter=null;
	 static BufferedWriter bufferedWriter=null;
	 
	public void reader(BufferedReader br){
		try {
			    String line = null;
			    while ((line = br.readLine()) != null) {
			    
			    	String res = reverseStringWithModification(line);
			        
			    	writer(res);
			    }
			} catch (IOException x) {
				System.err.println(x);
	}
	}
	
	public void writer(String res) throws IOException{
		try {
		
            bufferedWriter.write(res);
            bufferedWriter.newLine();
		}
		 catch(IOException ex) {
	            
	            ex.printStackTrace();
	        }
		
	}
	
	public String reverseStringWithModification(String line){
	
		StringTokenizer st = new StringTokenizer(line, "|");
		String result="";
		int noOfTokens= st.countTokens();
		while(st.hasMoreTokens()){
			noOfTokens--;
			String token = st.nextToken();
			String rev="";
			for(int i =token.length()-1; i>= 0; i-- ){
				rev = rev+token.charAt(i);
			}
			result= result+rev;
			if(noOfTokens!=0){
			result= result+",";
			}
			rev="";
			
			
		}
		return result;
		
	}

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("D:/TestInput.txt");
		BufferedReader br = new BufferedReader(fr);
		
		
		try {
			fileWriter = new FileWriter("D:/reverse.txt");
			bufferedWriter = new BufferedWriter(fileWriter);
		       
			ReadAndWrite obj = new ReadAndWrite();
			obj.reader(br);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			br.close();
			bufferedWriter.close();// its vey imp to write data into the file , if we dont close file , then
									//you wont be able to see data in a file.
		}

        // Always wrap FileWriter in BufferedWriter.
       
	}
}
