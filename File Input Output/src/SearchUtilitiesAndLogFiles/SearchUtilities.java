package SearchUtilitiesAndLogFiles;

//  first create three  or any no of file in path "c:\\Search"
// put data into all files
// then search whatever you want to search  and find in which file your searchable string exist
import java.io.*;
import java.util.Date;

public class SearchUtilities {

	String searchString="amanbansal";
	public void search()
	{
		File fileSearch=new File("c:\\Search");
		File [] listFiles=fileSearch.listFiles();
		
		for(int i=0;i<listFiles.length;i++){
			//System.out.println(listFiles[i].getName());
			try {
				RandomAccessFile rm=new RandomAccessFile(listFiles[i].getAbsolutePath(),"r");
				
				rm.seek(0);
				while(rm.getFilePointer()<rm.length())
				{
					//System.out.println(listFiles[i].getName());
					String str=rm.readLine();
					//System.out.println(str);
					if(str.contains(searchString))
					{
						log(listFiles[i]);
					}
			
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void log(File f)
	{
		//File file=new File("C:\\log");
		Date date=new Date(f.lastModified());
		try {
			RandomAccessFile raf = new RandomAccessFile("c:\\log.txt", "rw");
			raf.seek(raf.length());
			//String str=f.getName()
			//System.out.println(str);
			
			raf.writeBytes(f.getName()+" "+date);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}

