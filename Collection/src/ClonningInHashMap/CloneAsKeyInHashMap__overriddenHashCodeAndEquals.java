package ClonningInHashMap;
import java.util.HashMap;
import java.util.Iterator;

import PassingClassObjectAsAKeyHashMap.AppleOveridesHashCodeEquals;

public class CloneAsKeyInHashMap__overriddenHashCodeAndEquals implements Cloneable {
	String name = " ";
	public CloneAsKeyInHashMap__overriddenHashCodeAndEquals(String name){
		this.name = name;
	}
	
	public int hashCode(){
		 System.out.println("In hashcode" + name.hashCode());
		return name.hashCode();
	}
	
	public boolean equals(Object obj){
		if(obj==null) return false;
		if (!(obj instanceof CloneAsKeyInHashMap__overriddenHashCodeAndEquals))
			return false;	
		if (obj == this)
			return true;
		System.out.println("In equals method:"+ this.name.equals(((CloneAsKeyInHashMap__overriddenHashCodeAndEquals) obj).name));
		return this.name.equals(((CloneAsKeyInHashMap__overriddenHashCodeAndEquals) obj).name);
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneAsKeyInHashMap__overriddenHashCodeAndEquals obj1 = new CloneAsKeyInHashMap__overriddenHashCodeAndEquals("aman");
		
		HashMap<CloneAsKeyInHashMap__overriddenHashCodeAndEquals, String> hm = new HashMap<>();
		hm.put(obj1, "value1");
		CloneAsKeyInHashMap__overriddenHashCodeAndEquals obj2 = (CloneAsKeyInHashMap__overriddenHashCodeAndEquals) obj1.clone();
		hm.put(obj2, "value2");
		
		Iterator itr = hm.entrySet().iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
}
