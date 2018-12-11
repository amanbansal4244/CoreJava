package Wildcard;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList a1 = new ArrayList<String>(); // Valid
		ArrayList a2 = new ArrayList<Integer>(); // Valid
		ArrayList a3 = new ArrayList<Double>(); // Valid
		ArrayList a4 = new ArrayList<Float>(); // Valid
		
		System.out.println(a1.equals(a4));
		System.out.println(a2.equals(a4));
		System.out.println(a3.equals(a4));
	}
}
