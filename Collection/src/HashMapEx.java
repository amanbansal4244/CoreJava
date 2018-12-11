import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;


public class HashMapEx {
	public static void main(String[] args) {
		HashMap<Integer, String> hm=new HashMap<Integer, String>();
		hm.put(1, "aman");
		
		hm.put(6, "bansal");
	
		hm.put(null,"Hi");
		hm.put(null, null);
		hm.put(3, null);
		hm.put(4, "dpk");
		//hm.put(6, "bansalee");
		hm.put(null, null);
		hm.put(null,"Helllo");
	   // hm.put(null, null);
	//	hm.put(4, null);
	//	hm.put(4, null);
		hm.put(1, "aman1");
		hm.put(5, "aman5");
		
		Set s = hm.entrySet();
		
		
		//Set s = hm.values();
		
		/*Iterator i = s.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
			//String key = (String) i .next();
			if(i.equals(4)){
				hm.put(9, "pappu");
			}
			 System.out.println("HashMap after iterator: "+hm);
		}*/
		
		Iterator i = hm.values().iterator();
		
		while(i.hasNext()){
			
			System.out.println(i.next());
		//	Map.Entry me=(Map.Entry)i.next();
			
			//System.out.println("key" +" " + me.getKey());
		//	System.out.println("values"+ " " + me.getValue());
		
		}
	}}

