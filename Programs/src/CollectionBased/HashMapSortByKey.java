package CollectionBased;
 
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
 
public class HashMapSortByKey {
	
	public static void main(String[] args){
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("Ajay","Cricket");
		map.put("Jyoti","FruitForest");
		map.put("Bijay","Cricket");
		map.put("Deepti","Marathon");
		map.put("Goutam","Marathon");
		map.put("Ingit","Roaming");
		map.put("Trupti","babySitting");
		map.put("Asha","HR");
		for (Map.Entry<String, String> entry : map.entrySet()) { 
			System.out.println(entry.getKey() + " :: "+entry.getValue());
		}
		/*In the tree map constructor you need to pass 
		 * the unsorted map to sort it*/
		System.out.println("\nTree Map sorts map by key in asceding order\n");
		Map<String,String> treeMap = new TreeMap<String,String>(map);
		for (Map.Entry<String, String> entry : treeMap.entrySet()) { 
			System.out.println(entry.getKey() + " :: "+entry.getValue());
		}
		
	
 
	}
 
}