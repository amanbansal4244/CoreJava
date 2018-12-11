package ImmutableKeyInHashMapConcept;

import PassingClassObjectAsAKeyHashMap.AppleOveridesHashCodeEquals;

public final class Employee {

	private String name ;
	
	public Employee(String name) {
		this.name = name;
	}

	public int hashCode(){
		  System.out.println("In hashCode:" +this.name.hashCode());
		return this.name.hashCode();	
	}
	
	public boolean equals(Object obj) {
		  System.out.println("In equals");
		if(obj==null) return false;
		if (!(obj instanceof Employee))
			return false;	
		if (obj == this)
			return true;
		return this.name.equals(((Employee) obj).name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
