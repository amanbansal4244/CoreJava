package StringBased;
//Write a program to shuffle a deck of 52 cards and shuffle them equally to 4 players

import java.util.ArrayList; 
import java.util.Random; 

public class ShuffleCardDeck 
{ 
	public static int k ; 
	public static StringBuffer ashish = new StringBuffer(); 
	public static StringBuffer ankur = new StringBuffer(); 
	public static StringBuffer bhatia = new StringBuffer(); 
	public static StringBuffer rajesh = new StringBuffer(); 
	public static int chance =1; 
	
	public static void main(String[] args) { 
		
		Random rndm = new Random(); //The java.util.Random class instance is used to generate a stream of pseudo random numbers
		
		ArrayList<Integer> arylst = new ArrayList<Integer>(); 
		
		for (int i = 1; i <= 52; i++) { 
			arylst.add(i); 
		} 
	
		while (arylst.size() != 0) { 
			k = rndm.nextInt(arylst.size()); //This method generates the next pseudo random number.
			int l = arylst.get(k); 
			if ((chance-1) %4 == 0) { 
			ashish.append(l); 
			ashish.append(" "); 
			} 
			if ((chance-2) %4 == 0) { 
			ankur.append(l); 
			ankur.append(" "); 
			} 
			if ((chance-3) %4 == 0) { 
			bhatia.append(l); 
			bhatia.append(" "); 
			} 
			if ((chance-4) %4 == 0) { 
			rajesh.append(l); 
			rajesh.append(" "); 
			} 
			++chance; 
			arylst.remove(k); 
		} 
		
			System.out.println("Ashish Have: "+ashish.toString());	
			System.out.println("Mayank Have: "+bhatia.toString()); 
			System.out.println("rajesh Have: "+rajesh.toString()); 
			System.out.println("Ankur Have: "+ankur.toString()); 
			
		} 

}