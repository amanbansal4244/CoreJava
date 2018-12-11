package ExceptionHandlingInOverriding;

import java.io.IOException;

public class DerivedClass extends BaseClass{

	public DerivedClass() {
		
	}
	@Override
	public void m1() throws NullPointerException{
		System.out.println("In Dervied Class : m1");
	}
	
	public void m2() throws IOException{
		System.out.println("In M2");
	}
	
	public static void main(String[] args) throws IOException {
		DerivedClass obj = new DerivedClass();
		obj.m2();
	}
}

