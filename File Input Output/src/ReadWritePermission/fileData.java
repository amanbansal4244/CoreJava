package ReadWritePermission;
import java.io.*;
import java.io.RandomAccessFile;

public class fileData {

	void fileData1(){
		try {
			RandomAccessFile rm=new RandomAccessFile("f:\\input.txt", "rw");
		
			rm.seek(rm.length()); // seek point to location where we want to point and here length takes bytes
			rm.writeBytes("Hii Java");
			rm.seek(0); // for back to starting position to read the file
			String str=rm.readLine();
			System.out.println(str);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}