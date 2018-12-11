package Testing;

public class JaVaReference {
	
	String name = "";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	JaVaReference(String name){
		this.name = name;
	}
	
	public static void main( String[] args ) {
		JaVaReference aDog = new JaVaReference("Max");
	    // we pass the object to foo
	    foo(aDog);
	    // aDog variable is still pointing to the "Max" dog when foo(...) returns
	 
	    if(aDog.getName().equals("Max")){
	    	System.out.println("Max 1 : " + true);    // true, java passes by value
	    }
	    if(aDog.getName().equals("Fifi")){
	    	System.out.println("FIFI : " +  true);// false
	    }
	   
	}

	public static void foo(JaVaReference d) {
	    if(d.getName().equals("Max")){
	    	System.out.println("Max : " + true);// true
	    }
	    // change d inside of foo() to point to a new Dog instance "Fifi"
	    d = new JaVaReference("Fifi");
	    if(d.getName().equals("Fifi")){
	    	System.out.println("FIFI : " +  true);// true
	    }
	}
}
