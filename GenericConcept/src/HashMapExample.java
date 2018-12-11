import java.util.ArrayList;
import java.util.HashMap;

public class HashMapExample {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		hm.put("Ajay", new Integer(50));
		hm.put("Aman", new Integer(530));
		hm.put("Rahul", new Integer(534));
		
		//Retrieve Rahul's Score
		String s = "Rahul";
		Integer score = (Integer) hm.get(s);
		
		System.out.println("Score:" + score);
	}
}
