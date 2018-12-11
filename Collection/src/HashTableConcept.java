import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class HashTableConcept {
	public static void main(String[] args) {
		Hashtable<Integer, Integer> ht=new Hashtable<Integer, Integer>();
		ht.put(1, 1);
		ht.put(2, 2);
		//ht.put(33, 3);
		ht.put(3, 3);
		ht.put(3, 8);
		ht.put(2, 5);
		ht.put(4, 1);
		//ht.put(32, 3);
		//ht.put(4, 5);
	  //ht.put(null, 3);     This line will give java.lang.NullPointerException bcoz HashTable does not allow null keys.
	  //ht.put(null, null);  This line will give java.lang.NullPointerException bcoz HashTable does not allow null keys and values.
	  // ht.put(null,333);   This line will give java.lang.NullPointerException bcoz HashTable does not allow null values.
		
		/*Enumeration e=ht.elements();  This method doesnot suit for HashTable 
		while(e.hasMoreElements()){
			System.out.println(e.nextElement());
		}*/
		/*
		Set s= ht.entrySet();
		Iterator i = s.iterator();
		while(i.hasNext()){
			Map.Entry me=(Map.Entry)i.next();
			System.out.println("key" +" " + me.getKey());
			System.out.println("values"+ " " + me.getValue());
			}*/
		
		Enumeration e=ht.keys();  // This code is also fine
		while(e.hasMoreElements()){
			System.out.println(e.nextElement());
		}
	
}
}
