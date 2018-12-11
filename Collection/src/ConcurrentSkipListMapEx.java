import java.util.Iterator;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
 
public class ConcurrentSkipListMapEx {
	public static void main(String[] args) {
 
		/****ConcurrentNavigableMap: A ConcurrentMap supporting NavigableMap operations, and recursively 
		 * so for its navigable sub-maps.
		 * ConcurrentSkipListMap: Constructs a new, empty map, sorted according to the natural ordering of the keys.
		 */
		ConcurrentNavigableMap<Integer, String> crunchifyCompanyMap = new ConcurrentSkipListMap<Integer, String>();
		crunchifyCompanyMap.put(100, "Crunchify");
		crunchifyCompanyMap.put(400, "Google");
		crunchifyCompanyMap.put(300, "Apple");
		crunchifyCompanyMap.put(275, "Facebook");
		crunchifyCompanyMap.put(325, "Twitter"); // NOTE: these are sample numbers
 
		//Returns a key-value mapping associated with the least key greater than or equal to the given key
		log("Let's get ceilingEntry: " + crunchifyCompanyMap.ceilingKey(200)); 
		// Returns the first (lowest) key
		log("Let's get firstKey: " + crunchifyCompanyMap.firstKey()); 
		// Returns greatest key
		log("Let's get lastEntry: " + crunchifyCompanyMap.lastEntry()); 
		// Returns the greatest key less than or equal to the given key
		log("Let's get floorEntry: " + crunchifyCompanyMap.floorKey(320)); 
 
		// Returns a reverse order NavigableSet view of the keys contained in this map.
		NavigableSet<Integer> crunchifyNavSet = crunchifyCompanyMap.descendingKeySet(); 
 
		log("\nHere is a Natual Sorted order NavigableSet ~~~~~~~~~~~~~~~~ ");
		
		Iterator<Integer> crunchifyIterator = crunchifyNavSet.iterator(); 
		// Returns true if the iteration has more elements
		while (crunchifyIterator.hasNext()) { 
			Integer mapKey = crunchifyIterator.next();
			log(mapKey.toString());
		}
 
		log("\nLet's do some deugging ~~~~~~~~~~~~~~~~");
		// Removes and returns a key-value mapping associated with the least key in this map
		log("pollFirstEntry: " + crunchifyCompanyMap.pollFirstEntry()); 
		
		log("now firstEntry: " + crunchifyCompanyMap.firstEntry());
		
		// Removes and returns a key-value mapping associated with the greatest key in this map
		log("pollLastEntry: " + crunchifyCompanyMap.pollLastEntry()); 
		log("now lastEntry: " + crunchifyCompanyMap.lastEntry());
	}
 
	private static void log(String result) {
		System.out.println(result);
 
	}
 
}