package Split;

import java.io.*;  
import java.util.ArrayList;
import java.util.Scanner;  

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class Split_Join {

	BufferedWriter out = null;
	DataInputStream in = null;
	ArrayList data = new ArrayList();
	int totalNoOfFiles;
	File theDir;
	File inputfile;
	Scanner scanner;
	int count = 0; 
	int tempLines =0 ;
	int lines = 0;
	int occurence = 0;
	int tempOccurence = 0;
	static int n=1;
	public void input(){
	  System.out.println("Enter no of desired lines in which you want to be split into ");
	  BufferedReader desriedLines =new BufferedReader(new InputStreamReader(System.in)); 
	  
	try {
		lines = Integer.parseInt( desriedLines.readLine());
	} catch (NumberFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  tempLines=lines;
	  double noOfLines = (double)lines;
	  
	  this.totalNoOfLines();
	}
	
	public void createDirectory(){
		theDir = new File("d:/Bansal");
		// if the directory does not exist, create it
		  if (!theDir.exists()) {
		   theDir.mkdir();  
		  }
		  
		  this.deleteAllFilesInDirectory();
	}
	//to delete all the files first
   public void deleteAllFilesInDirectory(){
		   if(theDir.exists()){
			   String[]entries = theDir.list();
			   for(String s: entries){
			       File currentFile = new File(theDir.getPath(),s);
			       currentFile.delete();
			   }
		   }
	}
   
   public void totalNoOfLines()
   {
	    inputfile = new File("d:/aman.txt");  
	   try {
	    scanner = new Scanner(inputfile);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}  
	   while (scanner.hasNextLine())   
	   {  
	    scanner.nextLine();  
	    count++;  
	   }  
	   System.out.println("Total lines in the file: " + count);     // Displays no. of lines in the input file.  
	   
	   this.createDirectory();
   }
   
   
	public void join(){
		
		 if(theDir.exists()){
			  String arr[]=theDir.list();
			  totalNoOfFiles=arr.length;
		  }			 
		try {
			FileOutputStream fout = new FileOutputStream("d:/Bansal/aman_Output.txt");
			
			 BufferedOutputStream out = new BufferedOutputStream(fout);
	 
			for (int part = 1; part <=totalNoOfFiles; part++)
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
	
	public void split()
	{
		this.input();
		try
		{
		FileInputStream fstream = new FileInputStream(inputfile); 
		 
		  in = new DataInputStream(fstream);  
		  
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		     
		  String strLine;
		  String str;  
			  int z=0;
			 while((str=br.readLine())!=null){
		        
				 data.add(str);
				  z++;
					  if(z==tempLines)
					  {
						
						  if(str.equalsIgnoreCase(" //aman "))
						    {
							  if(occurence == tempOccurence){
								  
								  occurence++;
							//  for(int n =0; n <10; n++){
							 //f(occurence == 0){
							  FileWriter fstream1 = new FileWriter("d:/Bansal/aman"+n+".txt"); 
							  n++;
								 out = new BufferedWriter(fstream1);
								for(Object obj : data){
									out.write(obj.toString());
									out.newLine();  
								}
							tempOccurence=occurence;
							
								
								data.clear();
								tempLines=tempLines+lines;
								 out.close(); 
								// 
						  }}
						    
						  else if(str.equalsIgnoreCase(" //bansal ")){
							  FileWriter fstream2 = new FileWriter("d:/Bansal/aman"+3+".txt"); 
								 out = new BufferedWriter(fstream2);
								for(Object obj : data){
									out.write(obj.toString());
									out.newLine();  
								}
								data.clear();
								tempLines=tempLines+lines;
								 out.close();  
						  }
					 else{
						
						 tempLines++;
							
						 }
					  }
				 }// end of while loop
		    in.close();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		 this.join();
	}
	
	public static void main(String[] args) {
		Split_Join obj = new Split_Join();
		obj.split();
	}
}
