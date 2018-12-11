package Question;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Route {

	BufferedWriter out = null;
	DataInputStream in = null;
	ArrayList data = new ArrayList();
	int totalNoOfFiles;
	File theDir;
	File inputfile;
	Scanner scanner;
	static int count = 0; 
	int tempLines =0 ;
	int lines = 0;
	int occurence = 0;
	int tempOccurence = 0;
	static int n=1;
	public void totalNoOfLines()
	   {
		    inputfile = new File("f:/input.txt");  
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
	   }
	   
	public static void main(String[] args) {
		
		Route obj = new Route();
		obj.totalNoOfLines();
		
		Scanner scanner;
		 HashMap<String, Integer> dict1 = new HashMap<String, Integer>();
		 HashMap<String, HashMap<String, Integer>> dict = new HashMap<String, HashMap<String, Integer>>();
		 
		 dict1.put("Mumbai",150);
		 dict1.put("Bangalore",50);
         dict.put("Mangalore", dict1);
         
         dict1 = new HashMap<String, Integer>();
         dict1.put("Mangalore", 150);
         dict1.put("Bangalore",90);
         dict1.put("Hyderabad",325);
         dict.put("Mumbai", dict1);

         dict1 = new HashMap<String, Integer>();
         dict1.put("Mangalore", 50);
         dict1.put("Mumbai", 90);
         dict1.put("Hyderabad", 200);
         dict1.put("Chennai", 100);
         dict.put("Bangalore", dict1);

         dict1 = new HashMap<String, Integer>();
         dict1.put("Bangalore", 200);
         dict1.put("Mumbai", 325);
         dict1.put("Chennai", 75);
         dict.put("Hyderabad", dict1);

         dict1 = new HashMap<String, Integer>();
         dict1.put("Bangalore", 100);
         dict1.put("Hyderabad", 75);
         dict.put("Chennai", dict1);
         
         
         try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("f:/input.txt"));
			RandomAccessFile rm=new RandomAccessFile("f:\\input.txt", "rw");
			for(int i=0; i<=count ; i++){
			String str=rm.readLine();
			System.out.println(str);
			}
			
		} 
         catch (Exception e1) {
			
			e1.printStackTrace();
		}

         
         
        
         
       /*  string[] lines =
        		 System.IO.File.ReadAllLines(@"C:\Users\NAVAL\Desktop\input.txt");
        		             string[] output = null;
        		             string[] temp = null;
        		             SortedList<Int32,string> sl = new SortedList<Int32,string>();
        		             Int32 i, cost;
        		             foreach (string line in lines)
        		             {
        		                 cost = 0;
        		                 // Use a tab to indent each line of the file.
        		                 Console.WriteLine("\t" + line);
        		                temp = line.Split(':');
        		                for (int z = 0; z < temp.Length;++z ){
        		                        //city.Add(s);

        		                        //foreach(string s in city){
        		                    if (z + 1 < temp.Length)
        		                    {
        		                        dict.TryGetValue(temp[z], out dict1);
        		                        dict1.TryGetValue(temp[z + 1], out i);
        		                        cost = cost + i;
        		                    }
        		                    }
        		                Console.Write(cost);
        		                 sl.Add(cost,line);


        		             }
        		             Int32 ii = 0;
        		             output = new string[lines.Length];
        		             foreach(string value in sl.Values)
        		             {
        		                 output[ii++] = value;
        		             }
        		             System.IO.File.WriteAllLines(@"C:\Users\NAVAL\Desktop\output.txt",
        		 output);
        		             Console.ReadKey();
        		         }
        		     }
        		 }*/

	}
}
