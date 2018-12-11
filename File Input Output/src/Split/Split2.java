package Split;

import java.io.*;  
import java.util.ArrayList;
import java.util.Scanner;  
public class Split2 {
 
	
public static void main(String args[])  
{  
	 File theDir = new File("d:/Bansal");
	  // if the directory does not exist, create it
	  if (!theDir.exists()) {
	   // System.out.println("creating directory: " + bansal);
	    boolean result = theDir.mkdir();  

	     if(result) {    
	       System.out.println("DIR created");  
	     }
	  }
}
}