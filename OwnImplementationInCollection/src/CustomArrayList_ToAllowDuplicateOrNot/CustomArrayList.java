package CustomArrayList_ToAllowDuplicateOrNot;

import java.util.ArrayList;
import java.util.HashSet;

/*
This Class's Constructor should add the ability to specify whether or not 
duplicates are allowed in the Custom ArrayList.
*/
public class CustomArrayList<E> extends ArrayList<E> {

	public boolean allowDuplicate;
	HashSet<Object> hashSet = new HashSet<Object>();
	
	public CustomArrayList(boolean allowDuplicate) {
		this.allowDuplicate = allowDuplicate;
	}
	
	
	/**** This method is generic type and can take any type of objects.****/
	public boolean add(E e){
		
		if(allowDuplicate == false && hashSet.add(e) == false){
			throw new IllegalArgumentException("No Dublicates are allowed");
		}else if(allowDuplicate == true && hashSet.add(e) == false){
			super.add(e); // calling add method of ArrayList class.
		}
		
		return allowDuplicate;
	}
	
}
