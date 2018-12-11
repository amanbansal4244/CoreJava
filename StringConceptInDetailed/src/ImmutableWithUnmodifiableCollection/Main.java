package ImmutableWithUnmodifiableCollection;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Address1 address = new Address1();
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("1");
		al.add("2");
		al.add("3");
		
		address.setSocietyName(al);
		
		ImmutableWithUnmodifiableCollection obj =
				new ImmutableWithUnmodifiableCollection("aman", address);
		
		System.out.println("Result:" + obj);
		
		al.add("4");
		al.add("5");
		
		obj.getAddress().setSocietyName(al);
		System.out.println("Result:" + obj);
	}
}