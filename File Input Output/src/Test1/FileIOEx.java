// File class deals with both file and folder as well as

package Test1;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileIOEx {
	
	void fileHandler(){
		try {
			File file=new File("C:\\Program Files");
			//File file=new File("c:\\data2.txt");  // By writing this line , Noting will create
			
			
			//Below lines to see  all files in Program Folder
			File [] listFiles=file.listFiles();
			
			for(int i=0;i<listFiles.length;i++){
				Date date=new Date(listFiles[i].lastModified());
			System.out.println(listFiles[i].getName()+ " "+date);
			
		
			File [] innerFiles=listFiles[i].listFiles();
			
			 // below lines to files to folder to folder
			for(int j=0;j<innerFiles.length;j++){
				//if(innerFiles[j].isFile()){
				System.out.println(innerFiles[j].getName());
				
			}
			
			//System.out.println(date.set);
			//System.out.println(file.lastModified());
			}
			//file.createNewFile(); // To create file
			
			//file.delete(); // for delete
			//file.mkdir();// To create folder(Directory)
			//file.mkdirs();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		FileIOEx obj = new FileIOEx();
		obj.fileHandler();
	}
}
