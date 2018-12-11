package QuestionBasedOnHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class QuestionBasedOnHashMap6 {

	@Override
    public int hashCode() {
	 System.out.println(" In hashcode and hascode value: " + super.hashCode() );
       return super.hashCode();
    }
	
    @Override
    public boolean equals(Object obj) {
	 System.out.println("In equals method");
        return false;
    }
    
    public static void main(String[] args) {
		HashMap<QuestionBasedOnHashMap6, Integer> obj = new HashMap<QuestionBasedOnHashMap6, Integer>();
		for(int i=0; i< 10; i++){
			obj.put(new QuestionBasedOnHashMap6(), i);
		}
		
		Iterator itr = obj.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry me = (Entry) itr.next();
			System.out.println("Key: "+ me.getKey() + " " + "Value:" + me.getValue());
		}
		
	}
}
