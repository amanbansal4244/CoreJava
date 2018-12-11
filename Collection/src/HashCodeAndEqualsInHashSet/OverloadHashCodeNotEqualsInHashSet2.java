package HashCodeAndEqualsInHashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class OverloadHashCodeNotEqualsInHashSet2
{
    String name;

    OverloadHashCodeNotEqualsInHashSet2(String n)
    {
        name=n; 
    }
    public String getName()
    {
        return name;   
    }

     @Override
    public int hashCode() {
        System.out.println("hashcode for"+" " + name + ":" + name.hashCode());
        return name.hashCode();
    }
    
    public static void main(String[] args) {
    	OverloadHashCodeNotEqualsInHashSet2 obj1=new OverloadHashCodeNotEqualsInHashSet2("bcd");

    	OverloadHashCodeNotEqualsInHashSet2 obj2=new OverloadHashCodeNotEqualsInHashSet2("cde");

    	OverloadHashCodeNotEqualsInHashSet2 obj3=new OverloadHashCodeNotEqualsInHashSet2("abc");

    	OverloadHashCodeNotEqualsInHashSet2 obj4=new OverloadHashCodeNotEqualsInHashSet2("abc");
    	
    	Set<OverloadHashCodeNotEqualsInHashSet2> sset=new HashSet<OverloadHashCodeNotEqualsInHashSet2>();

    	sset.add(obj1);
    	sset.add(obj2);
    	sset.add(obj3);
    	sset.add(obj4);
    	sset.add(new OverloadHashCodeNotEqualsInHashSet2("abc"));
    	sset.add(new OverloadHashCodeNotEqualsInHashSet2("cde"));
    	if(sset.contains(new OverloadHashCodeNotEqualsInHashSet2("cde"))){
			System.out.println("We have a cde obj!");
		}else{
			System.out.println("No cde obj!");
		}
    	Iterator it = sset.iterator();
		while(it.hasNext()){
			System.out.println("HashSet:" +  it.next());
		}
	}
}