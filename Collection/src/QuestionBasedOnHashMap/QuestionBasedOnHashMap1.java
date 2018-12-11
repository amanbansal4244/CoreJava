package QuestionBasedOnHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class QuestionBasedOnHashMap1 {

    @Override
    public boolean equals(Object obj) {
	 System.out.println("In equals method");
        return false;
    }
    
    public static void main(String[] args) {
		HashMap<QuestionBasedOnHashMap1, Integer> obj = new HashMap<QuestionBasedOnHashMap1, Integer>();
		for(int i=0; i< 10; i++){
			obj.put(new QuestionBasedOnHashMap1(), i);
		}
		
		Iterator itr = obj.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry me = (Entry) itr.next();
			System.out.println("Key: "+ me.getKey() + " " + "Value:" + me.getValue());
		}
		
	}
}
