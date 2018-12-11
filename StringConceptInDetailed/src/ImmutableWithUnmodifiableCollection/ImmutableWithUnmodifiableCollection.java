package ImmutableWithUnmodifiableCollection;

import java.util.Collections;

public final class ImmutableWithUnmodifiableCollection {

	private final String name;
	private final Address1 address;
	
	public ImmutableWithUnmodifiableCollection(String name, Address1 address) {
		this.name=name;
		this.address=new Address1(); 
	    this.address.setSocietyName(address.getSocietyName());
	}
	
	public String getName() {
		return name;
	}

	public Address1 getAddress() {
		return (Address1) Collections.unmodifiableList(address.getSocietyName());
		//return address;
	}
	
	public String toString(){
		return "Name:" + getName() +" " + "Address:" + getAddress().getSocietyName();
	}
}

