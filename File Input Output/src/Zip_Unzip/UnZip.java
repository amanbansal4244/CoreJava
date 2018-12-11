package Zip_Unzip;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.InflaterInputStream;

public class UnZip {

	public static void main(String[] args) throws IOException {
		try {
			FileInputStream fin = new FileInputStream("C:/Users/Bansal/Downloads/aman/song.zip");
			
			FileOutputStream fout = new FileOutputStream("C:/Users/Bansal/Downloads/aman/unzip");
			
			InflaterInputStream ins = new InflaterInputStream(fin);
			int data;
			while((data= ins.read()) != -1){
				fout.write(data);
			}
			fout.close();
			ins.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
