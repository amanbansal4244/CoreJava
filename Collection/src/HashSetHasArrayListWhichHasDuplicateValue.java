

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HashSetHasArrayListWhichHasDuplicateValue {

	public static void main(String[] args) {
		
		List list = Arrays.asList(1,2,3,3,2,1);
		HashSet hs = new HashSet(list);
		
		hs.add(12);
		hs.add(22);
		hs.add(31);
		
		Iterator itr = hs.iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		
	}
}
