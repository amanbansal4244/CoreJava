package PassingClassObjectAsAKeyHashMap;
import java.util.HashMap;
 
public class AppleWithoutOverrides {
	private String color;
 
	public AppleWithoutOverrides(String color) {
		this.color = color;
	}
 
	public static void main(String[] args) {
		AppleWithoutOverrides a1 = new AppleWithoutOverrides("green");
		AppleWithoutOverrides a2 = new AppleWithoutOverrides("red");
		AppleWithoutOverrides a3 = new AppleWithoutOverrides("green");
		AppleWithoutOverrides a4 = new AppleWithoutOverrides("red");
		
		//hashMap stores apple type and its quantity
		HashMap<AppleWithoutOverrides, Integer> map = new HashMap<AppleWithoutOverrides, Integer>();
		
		map.put(a1, 10);
		map.put(a2, 20);
		map.put(a3, 30);
		map.put(a4, 40);
		
		System.out.println("Value of a1 key : " +map.get(a1));
		System.out.println("Value of a2 key : "+map.get(a2));
		System.out.println("Value of a3 key : " +map.get(a3));
		System.out.println("Value of a4 key : "+map.get(a4));
		
		System.out.println("Check a1 and a2 are equals : " +a1.equals(a2));
		System.out.println("Check a1 and a3 are equals : " +a1.equals(a3));
		System.out.println("Check a1 and a4 are equals : " +a1.equals(a4));
		System.out.println("Check a2 and a3 are equals : " +a2.equals(a3));
		System.out.println("Check a2 and a4 are equals : " +a2.equals(a4));
		System.out.println("Check a3 and a4 are equals : " +a3.equals(a4));
		
		System.out.println("Hashcode of a1 :" + a1.hashCode() + " and " +"Hashcode of a2 :" + a2.hashCode()  
		+ " and " +"Hashcode of a3 :" + a3.hashCode() + " and " +"Hashcode of a4 :" + a4.hashCode());
		
		
		AppleWithoutOverrides a5 = new AppleWithoutOverrides("green");
		AppleWithoutOverrides a6 = new AppleWithoutOverrides("red");
		
		map.put(a5, 50);
		map.put(a6, 60);
		System.out.println("Value of green from hash map is :" +map.get(new AppleWithoutOverrides("green")));
		System.out.println("Value of green from hash map is :" +map.get(new AppleWithoutOverrides("red")));
		
		System.out.println("Value of green from hash map using already created object is :" +map.get(a5));
		System.out.println("Value of green from hash map using already created object is :" +map.get(a6));
		
		System.out.println("Does map contains green as key :" + map.containsKey(new AppleWithoutOverrides("green")));
		System.out.println("Does map contains red as key :" + map.containsKey(new AppleWithoutOverrides("red")));
		
		System.out.println("Does map contains green using already created object as key :" + map.containsKey(a5));
		System.out.println("Does map contains red using already created object as key :" + map.containsKey(a6));
		
		System.out.println("Size of map:" + map.size());
	}
}