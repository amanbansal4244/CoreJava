package Split;


import java.io.*;
public class Join_Split_Files {

		public static void main(String[] args) {
			
		
			String baseFilename = "aman";
			int c = 0 ;
			int count =0;
			int n =0;
			File theDir = new File("d:/Bansal");

			  // if the directory does not exist, create it
			  if (!theDir.exists()) {
			   // System.out.println("creating directory: " + bansal);
			    boolean result = theDir.mkdir();  

			     if(result) {    
			       System.out.println("DIR created");  
			     }
			  }
			  
			  
			  if(theDir.exists()){
				  String arr[]=theDir.list();
				   n=arr.length;
			  }			 
			try {
				FileOutputStream fout = new FileOutputStream("d:/Bansal/aman_Output.txt");
				
				 BufferedOutputStream out = new BufferedOutputStream(fout);
		 
				for (int part = 1; part <= n; part++)
					{
					BufferedInputStream in = new BufferedInputStream(new FileInputStream("d:/Bansal/aman"+part+".txt"));

					int b;
					while ( (b = in.read()) != -1 ){
						out.write(b);
					}

					in.close();
					}
				out.close();
			}
				catch (Exception e) {
					e.printStackTrace();
				}
	}
	}
			
