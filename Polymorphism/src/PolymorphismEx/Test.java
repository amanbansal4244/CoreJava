package PolymorphismEx;
import java.io.IOException;
public class Test {

	public int  m1(int a, int b){
		System.out.println("in m1");
		return 1;
	}
}

class DerivedTest extends Test{
	public int  m1(int a, int b){
		System.out.println("in m2");
		return 1;
	}
}
