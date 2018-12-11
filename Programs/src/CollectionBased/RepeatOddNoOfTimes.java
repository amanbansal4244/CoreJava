package CollectionBased;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*Let's assume that there's an array that has nonzero natural numbers where all the numbers repeat an even number of times,
except for one value that repeats an odd number of times. Can you write me a function that takes this array, 
and returns the value that occurs the odd number of times? 

Ex : - [ 4, 7, 2, 2, 5, 3, 5, 7, 7, 3, 4, 5 ]
*/

public class RepeatOddNoOfTimes {
	static public void check (int [] arr){
		
		 Map<Integer, Integer> dupMap = new HashMap<Integer, Integer>();
		
		 int count=1;
		 
		for(int i =0; i< arr.length; i++){
			
			
			if(dupMap.containsKey(arr[i])){
				
				dupMap.put(arr[i], dupMap.get(arr[i])+1);
				//dupMap.ge
			}
			else{
				dupMap.put(arr[i] ,1);
			}
			
		}
		
		Set s = dupMap.entrySet();
		
		Iterator i = s.iterator();
		while(i.hasNext()){
			Map.Entry me=(Map.Entry)i.next();
			if((Integer) me.getValue() %2 !=0){
				
				System.out.println("odd duplicate array element" +" : " + me.getKey());
				System.out.println("no fo times present odd duplicate array element"+ " : " + me.getValue());
				//int x= (Integer) me.getValue();
			}
		}
		
	}
	
	public static void main(String[] args) {
		int arr[] = {4, 7, 2, 2, 5, 3, 5, 7, 7,7, 3, 4, 5};
		
		check(arr);
	}
}
