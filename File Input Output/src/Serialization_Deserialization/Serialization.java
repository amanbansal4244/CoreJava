package Serialization_Deserialization;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization {
	public static void main(String[] args) throws IOException {
		
		try {
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			FileOutputStream fout = new FileOutputStream("E:/Seri.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			System.out.println("How Many Objects");
			int n = Integer.parseInt(br.readLine());
			
			for(int i=0; i<n; i++)
			{
				Employee e_obj = Employee.getData();
				oos.writeObject(e_obj);
			}
			oos.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
