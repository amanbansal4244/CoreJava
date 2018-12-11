package CollectionBased;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class RepeatingElelementInARRAY {

	
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
		
		Set s = dupMap.entrySet();
		
		Iterator i = s.iterator();
		while(i.hasNext()){
			Map.Entry me=(Map.Entry)i.next();
			if((Integer) me.getValue() > 1){
				
				System.out.println("duplicate array element" +" " + me.getKey());
				System.out.println("no fo times present duplicate array element"+ " " + me.getValue());
				//int x= (Integer) me.getValue();
			}
		}
		
	}
	
	public static void main(String[] args) {
		int arr[] = {3,5,3,2,6,4,2,9};
		
		check(arr);
	}
}
