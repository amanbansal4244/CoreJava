package PassingClassObjectAsAKeyHashMap;
import java.util.HashMap;
 
public class AppleOveridesHashcode {
	private String color;
 
	public AppleOveridesHashcode(String color) {
		this.color = color;
	}
 
	public int hashCode(){
		  System.out.println("In hashCode");
		return this.color.hashCode();	
	}
	
	public static void main(String[] args) {
		AppleOveridesHashcode a1 = new AppleOveridesHashcode("green");
		AppleOveridesHashcode a2 = new AppleOveridesHashcode("red");
		AppleOveridesHashcode a3 = new AppleOveridesHashcode("green");
		AppleOveridesHashcode a4 = new AppleOveridesHashcode("red");
		
		//hashMap stores apple type and its quantity
		HashMap<AppleOveridesHashcode, Integer> map = new HashMap<AppleOveridesHashcode, Integer>();
		
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
		
		AppleOveridesHashcode a5 = new AppleOveridesHashcode("green");
		AppleOveridesHashcode a6 = new AppleOveridesHashcode("red");
		
		
		System.out.println("Value of green from hash map is :" +map.get(new AppleOveridesHashcode("green")));
		System.out.println("Value of green from hash map is :" +map.get(new AppleOveridesHashcode("red")));
		
		System.out.println("Value of green from hash map using already created object is :" +map.get(a5));
		System.out.println("Value of green from hash map using already created object is :" +map.get(a6));
		
		System.out.println("Does map contains green as key :" + map.containsKey(new AppleOveridesHashcode("green")));
		System.out.println("Does map contains red as key :" + map.containsKey(new AppleOveridesHashcode("red")));
		
		System.out.println("Does map contains green using already created object as key :" + map.containsKey(a5));
		System.out.println("Does map contains red using already created object as key :" + map.containsKey(a6));
	}
}