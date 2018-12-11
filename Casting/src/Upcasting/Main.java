package Upcasting;

public class Main {
	public static void main(String[] args) {
	One obj=new Two();  //Upcasting now base class obj can access the all the method of derived class is Over-Ridden
						//base class obj will have only base class method, will bot have derived class method
						// but if derived class method is overrided any base class method then derived class over rided method will get call
	obj.method1();// Overridden Method bcoz of late binding
	obj.method3();
	One.method();// base static Method
	Two.method();//Overridden static Method 
	
	obj.method(); //base static Method bcoz of static method and its early binding
	}
}
