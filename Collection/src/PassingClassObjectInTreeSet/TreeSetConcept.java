package PassingClassObjectInTreeSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetConcept {
	public static void main(String a[]){
       
        Set<HasmMapAsAValue> nameComp = new TreeSet<HasmMapAsAValue>();
        
        nameComp.add(new HasmMapAsAValue("Ram",3000));
        
        nameComp.add(new HasmMapAsAValue("John",6000));
        nameComp.add(new HasmMapAsAValue("Crish",2000));
        nameComp.add(new HasmMapAsAValue("Tom",2400));
        
        System.out.println(nameComp);
          }
}


/*Note: Output
 * 
 * Exception in thread "main" java.lang.ClassCastException: PassingEmployeeObjectInTreeSet.Price cannot be cast to java.lang.Comparable
	at java.util.TreeMap.compare(TreeMap.java:1290)
	at java.util.TreeMap.put(TreeMap.java:538)
	at java.util.TreeSet.add(TreeSet.java:255)
	at PassingEmployeeObjectInTreeSet.TreeSetConcept.main(TreeSetConcept.java:10)

 * 
 * */
 