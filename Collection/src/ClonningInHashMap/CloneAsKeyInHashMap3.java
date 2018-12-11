package ClonningInHashMap;

import java.util.HashMap;
import java.util.Iterator;

import PassingClassObjectAsAKeyHashMap.AppleOveridesHashCodeEquals;

public class CloneAsKeyInHashMap3 implements Cloneable {

	String name = " ";
	
	public CloneAsKeyInHashMap3(String name){
		this.name = name;
	}
	
	public int hashCode(){
		 return 5;
	}
	
	public boolean equals(Object obj){
		 return true;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneAsKeyInHashMap3 obj1 = new CloneAsKeyInHashMap3("aman");
		
		HashMap<CloneAsKeyInHashMap3, String> hm = new HashMap<>();
		hm.put(obj1, "value1");
		CloneAsKeyInHashMap3 obj2 = (CloneAsKeyInHashMap3) obj1.clone();
		hm.put(obj2, "value2");
		
		Iterator itr = hm.entrySet().iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}

	}
}
