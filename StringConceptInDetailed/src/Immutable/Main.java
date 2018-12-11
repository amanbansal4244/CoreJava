package Immutable;
public class Main {
	
	public static void main(String[] args) {
		Address address = new Address();
		address.setSocietyName("Kumar Paradise");
		ImmutableConcept_MutableDependencyInjectionOfAnotherClass obj =
				new ImmutableConcept_MutableDependencyInjectionOfAnotherClass("aman",address);
		System.out.println("Result:" + obj);
		
		obj.getAddress().setSocietyName("Anex");
		//address.setSocietyName("Cosmos");
		
		System.out.println("Result:" + obj);
	}
}