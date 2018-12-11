package ClonningInHashMap;
import java.util.HashMap;
import java.util.Iterator;

import PassingClassObjectAsAKeyHashMap.AppleOveridesHashCodeEquals;

public class CloneAsKeyInHashMap_NotOverriddenEqualAndHashcode implements Cloneable {
	String name = " ";
	public CloneAsKeyInHashMap_NotOverriddenEqualAndHashcode(String name){
		this.name = name;
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneAsKeyInHashMap_NotOverriddenEqualAndHashcode obj1 = new CloneAsKeyInHashMap_NotOverriddenEqualAndHashcode("aman");
		
		HashMap<CloneAsKeyInHashMap_NotOverriddenEqualAndHashcode, String> hm = new HashMap<>();
		hm.put(obj1, "value1");
		CloneAsKeyInHashMap_NotOverriddenEqualAndHashcode obj2 = (CloneAsKeyInHashMap_NotOverriddenEqualAndHashcode) obj1.clone();
		hm.put(obj2, "value2");
		
		Iterator itr = hm.entrySet().iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}	
	}
}
