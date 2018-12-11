package Zip_Unzip;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;

public class ZipFile {
	public static void main(String[] args) throws IOException {
		 try {
			FileInputStream fin = new FileInputStream("C:/Users/vaio/Downloads/Compressed/input.txt");
			
			FileOutputStream fout = new FileOutputStream("C:/Users/vaio/Downloads/Compressed/zip");
			
			DeflaterOutputStream dout = new DeflaterOutputStream(fout);
			
			int data;
			while((data= fin.read()) != -1){
				dout.write(data);
			}
			fin.close();
			dout.close();
		 } 
		 
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
