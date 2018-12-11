package Immutable;

public final class ImmutableConcept_MutableDependencyInjectionOfAnotherClass {

	private final String name;
	private final Address address;
	
	public ImmutableConcept_MutableDependencyInjectionOfAnotherClass(String name, Address address) {
		this.name=name;
		//this.address=address;// never do this for mutable reference
		 this.address=new Address();  
	     this.address.setSocietyName(address.getSocietyName());
	}
	
	public String getName() {
		return name;
	}

	public Address getAddress() {
		
		/***
		 * Below line will break the immutability. 
		 * We should never return same object. 
		 */
		return address;
		
		/***
		 * Below lines code will not break the immutability. 
		 * We should always create the new object and then return newly created object. 
		 */
		/*Address newAdd = new Address(); // must copy here too
		newAdd.setSocietyName(address.getSocietyName());
		return newAdd;*/
	}
	
	public String toString(){
		return "Name:" + getName() +" " + "Address:" + getAddress().getSocietyName();
	}
}




