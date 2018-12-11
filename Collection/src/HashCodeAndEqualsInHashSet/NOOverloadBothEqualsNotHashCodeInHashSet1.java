package HashCodeAndEqualsInHashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class NOOverloadBothEqualsNotHashCodeInHashSet1
{
    String name;

    NOOverloadBothEqualsNotHashCodeInHashSet1(String n)
    {
        name=n; 
    }
    public String getName()
    {
        return name;   
    }

    
    public static void main(String[] args) {
    	NOOverloadBothEqualsNotHashCodeInHashSet1 obj1=new NOOverloadBothEqualsNotHashCodeInHashSet1("bcd");

    	NOOverloadBothEqualsNotHashCodeInHashSet1 obj2=new NOOverloadBothEqualsNotHashCodeInHashSet1("cde");

    	NOOverloadBothEqualsNotHashCodeInHashSet1 obj3=new NOOverloadBothEqualsNotHashCodeInHashSet1("abc");

    	NOOverloadBothEqualsNotHashCodeInHashSet1 obj4=new NOOverloadBothEqualsNotHashCodeInHashSet1("abc");
    	
    	Set<NOOverloadBothEqualsNotHashCodeInHashSet1> sset=new HashSet<NOOverloadBothEqualsNotHashCodeInHashSet1>();

    	sset.add(obj1);
    	sset.add(obj2);
    	sset.add(obj3);
    	sset.add(obj4);
    	sset.add(new NOOverloadBothEqualsNotHashCodeInHashSet1("abc"));
    	sset.add(new NOOverloadBothEqualsNotHashCodeInHashSet1("cde"));
    	
    	if(sset.contains(new NOOverloadBothEqualsNotHashCodeInHashSet1("cde"))){
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