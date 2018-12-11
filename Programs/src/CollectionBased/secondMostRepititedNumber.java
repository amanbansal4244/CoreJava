package CollectionBased;


import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class secondMostRepititedNumber {

	
	static public void check (int [] arr){
		
		Map<Integer, Integer> dupMap = new HashMap<Integer, Integer>();
		
		for(int i =0; i< arr.length; i++){
			
			
			if(dupMap.containsKey(arr[i])){
				dupMap.put(arr[i], dupMap.get(arr[i])+1);
				
			}
			else{
				dupMap.put(arr[i] ,1);
			}
			
		}
		
		ArrayList temp = new ArrayList ( dupMap.values());
		Collections.sort(temp);
		
		
		Set s = dupMap.entrySet();
		Iterator i = s.iterator();
		while(i.hasNext()){
			Map.Entry me=(Map.Entry)i.next();
			if( temp.get(temp.size()-2).equals(me.getValue())){
				
				System.out.println("2nd repeated duplicate array element" +" " + me.getKey());
				System.out.println("no fo times present duplicate array element"+ " " + me.getValue());
				//int x= (Integer) me.getValue();
			}
		}
		
	}
	
	public static void main(String[] args) {
		int arr[] = {3,5,3,2,6,4,2,2,2,3,3,9};
		
		check(arr);
	}
}
