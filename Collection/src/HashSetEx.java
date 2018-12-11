import java.util.HashSet;
import java.util.Iterator;


public class HashSetEx {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		HashSet<Integer> hs1=new HashSet<Integer>();
		hs.add("aman");
		hs.add("aman");
		//hs.add(null);
		hs.add("bansal");
		hs.add("bansal");
		hs.add(null);
		//TestProgram.check(hs);  for passing the values of hs obj to TestProgram class
		
		hs1.add(2);
		
		for(String s : hs){
			System.out.println();
		}
		Iterator it = hs.iterator();
		while(it.hasNext()){
			//it.remove();    java.lang.IllegalStateException bcoz iteration has not started yet.
			String s= (String) it.next();
			System.out.println(s);
			//System.out.println(it.next());    java.util.NoSuchElementException bcoz no more element to iterate.
		}
	}
}
