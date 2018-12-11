package CollectionBased;
	 
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Set;
	 
	public class DuplicateElementAndCountDuplicateElement {
	 
	    public void findDuplicateChars(String str){
	         
	        Map<Character, Integer> dupMap = new HashMap<Character, Integer>();
	        int count =0;
	        int max=0;
	        char[] chrs = str.toCharArray();
	        for(Character ch:chrs){
	            if(dupMap.containsKey(ch)){
	            	count++;
	                dupMap.put(ch, dupMap.get(ch)+1);
	            } else {
	            	//count =1;
	                dupMap.put(ch, 1);
	            }
	            if(count>= max){
	          max=count;  
	            }
	        }
	        System.out.println("max no of duplicate " + " " +max);
	        Set<Character> keys = dupMap.keySet();
	        for(Character ch:keys){
	            if(dupMap.get(ch) > 1){
	                System.out.println(ch+"--->"+dupMap.get(ch));
	            }
	        }
	    }
	     
	    public static void main(String a[]){
	    	DuplicateElementAndCountDuplicateElement dcs = new DuplicateElementAndCountDuplicateElement();
	        dcs.findDuplicateChars("Java2Novice");
	    }
	}
	