package HashCodeAndEqualsInHashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class OverloadEqualsNotHashCodeInHashSet3
{
    String name;

    OverloadEqualsNotHashCodeInHashSet3(String n)
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

        OverloadEqualsNotHashCodeInHashSet3 obj=(OverloadEqualsNotHashCodeInHashSet3)arg0;

        System.out.println("1st "+getName());
        System.out.println("2nd "+obj.getName());

        if(this.getName().equals(obj.getName()))
        {
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
    	OverloadEqualsNotHashCodeInHashSet3 obj1=new OverloadEqualsNotHashCodeInHashSet3("bcd");

    	OverloadEqualsNotHashCodeInHashSet3 obj2=new OverloadEqualsNotHashCodeInHashSet3("cde");

    	OverloadEqualsNotHashCodeInHashSet3 obj3=new OverloadEqualsNotHashCodeInHashSet3("abc");

    	OverloadEqualsNotHashCodeInHashSet3 obj4=new OverloadEqualsNotHashCodeInHashSet3("abc");
    	
    	Set<OverloadEqualsNotHashCodeInHashSet3> sset=new HashSet<OverloadEqualsNotHashCodeInHashSet3>();

    	sset.add(obj1);
    	sset.add(obj2);
    	sset.add(obj3);
    	sset.add(obj4);
    	sset.add(new OverloadEqualsNotHashCodeInHashSet3("abc"));
    	sset.add(new OverloadEqualsNotHashCodeInHashSet3("cde"));
    	
    	if(sset.contains(new OverloadEqualsNotHashCodeInHashSet3("cde"))){
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