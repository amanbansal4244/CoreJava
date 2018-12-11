package CollectionBased;


import java.util.*;
import java.io.*;

//Solve class used to find solution of the problem
public class RestroProblem {
	
	
	//static int keyCount=1;
	public static void main(String[] args) throws Exception
	{
		HashMap<Integer,Float> previous = new HashMap<Integer, Float>();
		HashMap<Integer,Float> current = new HashMap<Integer, Float>();
		String itemLabel[] = new String[args.length - 1];
		String splitBy = ",";
		for (int i = 1; i < args.length; i++)
		{
			itemLabel[i - 1] = args[i];
		}
		
		for (int i = 0; i < itemLabel.length; i++) 
		{
			previous = (HashMap<Integer, Float>)current.clone();
			current.clear();
			File file = new File("D:/Aman-HD/aman.csv");
			RandomAccessFile br = new RandomAccessFile(file, "rw");

			String line;
			float value = 0f;
		
			if (i != 0) 
			{
				br.seek(0);
			}
			
			while ((line = br.readLine()) != null)
			{
				String[] b = line.split(splitBy);
				int key = Integer.parseInt(b[0]);
				value = Float.parseFloat(b[1]);
				String temp = null;
				
				if(b.length > 3){
					
								int ix;
								 int count =0; 
									for (ix=2; ix < b.length; ix++) {
										temp = b[ix].substring(1);
										for (int x = 0; x < itemLabel.length; x++) 
										{
											if (temp.compareTo(itemLabel[x]) == 0)
											{
												count++;
												
												break;
											}
										}
									}
									
									if(count == ix-2)
									{
											if(i == 0)
											 {
												
												current.put(key, value);
												//count =0;
											 }
											else{
												if(previous.containsKey(key))
												 {
													// value = value + previous.get(key);	
													 current.put(key, value);
													// count =0;
												 }
											}
									}
									
									else{
										if(i == 0)
										 {
											for (ix=2; ix < b.length; ix++) {
												temp = b[ix].substring(1);
												for (int x = 0; x < itemLabel.length; x++) 
												{
													if (temp.compareTo(itemLabel[x]) == 0)
													{
													//if(null)
														current.put(key, value);
														
													}
													else{
														if(previous.containsKey(key))
														 {
															// value = value + previous.get(key);	
															 current.put(key, value);
															// count =0;
														 }
													}
												}
											}
											//count =0;
										 }
										
										
									}
							 }
				
				else{
				
					if (b[2].substring(1).compareTo(itemLabel[i]) == 0)
					{
						 if(i == 0)
						 {
				             current.put(key, value);	               
				         } 
						 else
						 if(previous.containsKey(key))
						 {
							 value = value + previous.get(key);	
							 current.put(key, value);
						 }
					}
				}
			}

			br.close();
		}
		System.out.println("jai ho");
	
		ArrayList temp = new ArrayList(current.values());
		Collections.sort(temp);

		Set s = current.entrySet();
		Iterator i = s.iterator();
		
		while (i.hasNext()) {
					Map.Entry me = (Map.Entry) i.next();
					
					//if(tempHM.ge == itemLabel.length )
					if (temp.get(0) == me.getValue()) {
						System.out.println("Restro Id " + me.getKey());
						System.out.println("Total Min Price " + me.getValue());
					}
		
					}
		
	}
}
