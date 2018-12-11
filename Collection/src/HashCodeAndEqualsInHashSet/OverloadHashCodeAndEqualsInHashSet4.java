package HashCodeAndEqualsInHashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class OverloadHashCodeAndEqualsInHashSet4
{
    String name;

    OverloadHashCodeAndEqualsInHashSet4(String n)
    {
        name=n; 
    }
    public String getName()
    {
        return name;   
    }

    @Override
    public boolean equals(Object arg0) {

        System.out.println("in equals");

        OverloadHashCodeAndEqualsInHashSet4 obj=(OverloadHashCodeAndEqualsInHashSet4)arg0;

        System.out.println("1st "+getName());
        System.out.println("2nd "+obj.getName());

        if(this.getName().equals(obj.getName()))
        {
                return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        System.out.println("hashcode for"+" " + name + ":" + name.hashCode());
        return name.hashCode();
    }
    
    public static void main(String[] args) {
    	OverloadHashCodeAndEqualsInHashSet4 obj1=new OverloadHashCodeAndEqualsInHashSet4("bcd");

    	OverloadHashCodeAndEqualsInHashSet4 obj2=new OverloadHashCodeAndEqualsInHashSet4("cde");

    	OverloadHashCodeAndEqualsInHashSet4 obj3=new OverloadHashCodeAndEqualsInHashSet4("abc");

    	OverloadHashCodeAndEqualsInHashSet4 obj4=new OverloadHashCodeAndEqualsInHashSet4("abc");
    	
    	Set<OverloadHashCodeAndEqualsInHashSet4> sset=new HashSet<OverloadHashCodeAndEqualsInHashSet4>();

    	sset.add(obj1);
    	sset.add(obj2);
    	sset.add(obj3);
    	sset.add(obj4);
    	sset.add(new OverloadHashCodeAndEqualsInHashSet4("abc"));
    	sset.add(new OverloadHashCodeAndEqualsInHashSet4("cde"));
    	
    	if(sset.contains(new OverloadHashCodeAndEqualsInHashSet4("cde"))){
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