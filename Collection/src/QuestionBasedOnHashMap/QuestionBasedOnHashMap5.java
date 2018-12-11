package QuestionBasedOnHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class QuestionBasedOnHashMap5 {

	@Override
    public int hashCode() {
	 System.out.println(" In hashcode");
       return 1;
    }
	
    @Override
    public boolean equals(Object obj) {
	 System.out.println("In equals method");
        return true;
    }
    
    public static void main(String[] args) {
		HashMap<QuestionBasedOnHashMap5, Integer> obj = new HashMap<QuestionBasedOnHashMap5, Integer>();
		for(int i=0; i< 10; i++){
			obj.put(new QuestionBasedOnHashMap5(), i);
		}
		
		Iterator itr = obj.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry me = (Entry) itr.next();
			System.out.println("Key: "+ me.getKey() + " " + "Value:" + me.getValue());
		}
		
	}
}
