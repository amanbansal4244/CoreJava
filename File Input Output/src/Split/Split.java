package Split;

import java.io.*;
import java.sql.Date;

public class Split {
	
	public static void main(String[] args) throws IOException {
		
	FileReader fileReader = new FileReader("D:/Personal/Java_Aman/Workspace/TestInput.txt");
	BufferedReader bufferedReader = new BufferedReader(fileReader);
	String line=bufferedReader.readLine();
	int fileSize = 0;
	BufferedWriter fos = new BufferedWriter(new FileWriter("d:/aman"+new Date(fileSize).getTime()+".docx",true));
	while(line!= null) {
	    if(fileSize + line.getBytes().length > .1 * 1024){
	        fos.flush(); 
	        fos.close();
	        fos = new BufferedWriter(new FileWriter("d:/aman_"+new Date(fileSize).getTime()+".docx",true));
	        fos.write(line+"\n");
	        fileSize = line.getBytes().length;
	    }else{
	        fos.write(line+"\n");
	        fileSize += line.getBytes().length;
	    }
	}          
	fos.flush();
	fos.close();
	bufferedReader.close();
}
}