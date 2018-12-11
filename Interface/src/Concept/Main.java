package Concept;

public class Main {

	
	
	Testing obj = new Testing() {
		
		@Override
		public void method2() {
			System.out.println("Method2");
			
		}
		
		@Override
		public void method1() {
			System.out.println("Method1");
			
		}
	};
	
	public static void main(String[] args) {
	
		Main outer = new Main();
		outer.obj.method1();
		outer.obj.method2();
	}
}
