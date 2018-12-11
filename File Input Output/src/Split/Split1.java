package Split;

import java.io.*;  
import java.util.Scanner;  
public class Split1 {
 
public static void main(String args[])  
{  
 try{  
  // Reading file and getting no. of files to be generated   
	 
  
 // double noOfLines = 400.0; //  No. of lines to be split and saved in each output file.  
  File inputfile = new File("d:/aman.txt");  
  Scanner scanner = new Scanner(inputfile);  
  int count = 0;  
 
/*  long ii=inputfile.length();
  double d=ii/1024;
  System.out.println(inputfile.length());
  System.out.println(d);
  */
  while (scanner.hasNextLine())   
  {  
   scanner.nextLine();  
   count++;  
  }  
  System.out.println("Total lines in the file: " + count);     // Displays no. of lines in the input file.  
  
  System.out.println("Enter no of desired lines in which you want to be split into ");
  BufferedReader desriedLines =new BufferedReader(new InputStreamReader(System.in)); 
  int lines = Integer.parseInt( desriedLines.readLine());
  double noOfLines = (double)lines;

  
  double temp = (count/noOfLines);  
  int temp1=(int)temp;  
  int noOfFiles=0;  
  if(temp1==temp)  
  {  
	  noOfFiles=temp1;  
  }  
  else  
  {  
	  noOfFiles=temp1+1;  
  }  
  System.out.println("No. of files to be generated :"+noOfFiles); // Displays no. of files to be generated.  
     
  // Actual splitting of file into smaller files  
  
  FileInputStream fstream = new FileInputStream(inputfile); 
 
  DataInputStream in = new DataInputStream(fstream);  
  
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String strLine;  
   
		  for (int j=1;j<=noOfFiles;j++)  
		  {  
		   FileWriter fstream1 = new FileWriter("d:/aman/file"+j+".txt");     // Destination File Location  
		   BufferedWriter out = new BufferedWriter(fstream1);   
				   for (int i=1;i<=noOfLines;i++)  
				   {  
				    char ch = (char)br.read();   
					    if (ch!= ' ')  
					    {  
					     out.write(ch);   
						     if(i!=noOfLines)  
						     {  
						      out.newLine();  
						     }  
					    }  
				   }  
		   out.close();  
		  }  
  
  in.close();  
 }catch (Exception e)  
 {  
  System.err.println("Error: " + e.getMessage());  
 }  
  
}  
  
}   