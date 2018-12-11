package Serialization_Deserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class De_Serialization {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileInputStream fis = new FileInputStream("E:/Seri.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		try {
				
				
			Employee e;
			while((e=(Employee) ois.readObject())!=null){
				e.display();
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("End Of File Reached");
		}
		finally{
			ois.close();
		}
	}

}
