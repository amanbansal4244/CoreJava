package CommunicationExample2;

public class MainClass {
	public static void main(String[] args) {
		CommunicationClass cs=new CommunicationClass();
		Interface1 i1;
		i1=new Test1();			// O/p :First : Method 1
		// i1=new Test2();     // O/p :Second : Method 1 
		cs.call(i1);
	}
}
