package PassingClassObjectAsValueInHashMap;


	import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden {

	private String item;
    private int price;
     
    public HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden(String itm, int pr){
        this.item = itm;
        this.price = pr;
    }
     
    public boolean equals(Object obj){
    	System.out.println("In equals");
    	if(obj instanceof HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden){
    		HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden pp = (HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden)obj;
    		return ((pp.item.equals(this.item)) && (pp.price == this.price));
    	}
    	return false;
    }
    
    
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
     
    public String toString(){
        return "item: "+item+"  price: "+price;
    }

	public static void printMap(HashMap<String, HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden> hm){

		Set s = hm.entrySet();
		Iterator i = s.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}

	public static void main(String[] args) {
		HashMap<String, HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden> hm = new HashMap<String, HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden>();
		
		HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden key1 = new HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden("Banana", 20);
		HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden key2 = new HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden("Banana2", 220);
		HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden key3 = new HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden("Apple", 40);
		HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden key4 = new HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden("Orange", 30);
		
		hm.put("a1",key1);
		hm.put("a2",key2);
		hm.put("a3",key3);
		hm.put("a4",key4);

		printMap(hm);

		HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden key5 = new HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden("Banana", 20);
		HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden key6 = new HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden("Apple", 40);

		
		System.out.println("Does key1 available with a1 key? "+(hm.get("a1")).equals(key1));
		System.out.println("Does key2 available with a2 key? "+(hm.get("a2")).equals(key2));
		System.out.println("Does key2 available with a3 key? "+(hm.get("a3")).equals(key2));
		System.out.println("Does key1 available with a3 key? "+(hm.get("a3")).equals(key1));
		System.out.println("Does key5 available with key1? "+(key5).equals(key1));
		System.out.println("Does key6 available with key1? "+(key6).equals(key1));
		System.out.println("Does key6 available with key3? "+(key6).equals(key3));
		
		System.out.println("Does key1 available with new key? "+(hm.get("a1")).equals(new HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden("Banana", 20)));
		System.out.println("Does key1 available with another new key? "+(hm.get("a1")).equals(new HasmMapAsAValueWithoutHashCodeAndWithEqualsMethodOverridden("Apple", 20)));
		
	}
}


