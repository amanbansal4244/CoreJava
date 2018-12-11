package GenerciInMethodLevel;

import java.util.ArrayList;

public class Test {

	public void m1(ArrayList<String> al){
		al.add("aman");
		//al.add(10); // Compilation error
	}
	
	public void m2(ArrayList al){
		al.add("aman");
		al.add(10); // Compilation error
	}
	public static void main(String[] args) {
		
	}	
}
