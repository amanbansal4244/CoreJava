package GreetingExample1;

public class GreetinWay2UsingInterfaceJava7 {

	public void greet(GreetingInterfaceWay2 greetingInterfaceWay2){ //Here we are passing an class which has an method to perform
		greetingInterfaceWay2.perform();
	}
	public static void main(String[] args) {
		GreetinWay2UsingInterfaceJava7 greetingWay1 = new GreetinWay2UsingInterfaceJava7();
		
		HelloWorldGreetingWay2 helloWorldGreetingWay2 =  new HelloWorldGreetingWay2();
		if(helloWorldGreetingWay2 instanceof GreetingInterfaceWay2){
			System.out.println("true , helloWorldGreetingWay2 is instance of GreetingInterfaceWay2");
		}
		
		//way to create lambda expression.
		GreetingInterfaceWay2 lambdaGreetingInterfaceWay2 = () -> System.out.println("Hello World!!"); // o/p : true , helloWorldGreetingWay2 is instance of GreetingInterfaceWay2
		
		
		if(lambdaGreetingInterfaceWay2 instanceof GreetingInterfaceWay2){
			System.out.println("true , lambdaGreetingInterfaceWay2 is instance of GreetingInterfaceWay2"); // o/p :true , lambdaGreetingInterfaceWay2 is instance of GreetingInterfaceWay2
		}
		
		//anonymous inner class
		GreetingInterfaceWay2 anonymousGreetingInterfaceWay2 = new GreetingInterfaceWay2() {
			public void perform() {
				System.out.println("Hello World!!");
			}
		};
		if(anonymousGreetingInterfaceWay2 instanceof GreetingInterfaceWay2){
			System.out.println("true , anonymousGreetingInterfaceWay2 is instance of GreetingInterfaceWay2"); // o/p :true , anonymousGreetingInterfaceWay2 is instance of GreetingInterfaceWay2
		}
		
		greetingWay1.greet(helloWorldGreetingWay2); // o/p : Hello World!!
		lambdaGreetingInterfaceWay2.perform(); // o/p : Hello World!!
		anonymousGreetingInterfaceWay2.perform(); // o/p : Hello World!!
		
		greetingWay1.greet(lambdaGreetingInterfaceWay2); // o/p : Hello World!!
		greetingWay1.greet(anonymousGreetingInterfaceWay2); // o/p : Hello World!!
		
		greetingWay1.greet(() -> System.out.println("Hello World!!")); // o/p : Hello World!! , in this line we are passing direct lambda expression
																	//which means greet method has an argument of 'GreetingInterfaceWay2' interface
																	//which will match the same thing ( whether interface has same type of method or not 
		
		
		/*
		Note 1: 
			difference b/w #line1 : HelloWorldGreetingWay2 helloWorldGreetingWay2 =  new HelloWorldGreetingWay2();
						   #line2 : GreetingInterfaceWay2 lambdaGreetingInterfaceWay2 = () -> System.out.println("Hello World!!");
			although both object are printing the same result. But only difference is at #line1, 
			We are creating class which is implementing an interface and define the method 
			but #line2 we are not creating class to implement an interface , we can directly define an interface method using lambda expression and avoid the brand new class.	
		
		2. 
			difference b/w  #line3 : GreetingInterfaceWay2 lambdaGreetingInterfaceWay2 = () -> System.out.println("Hello World!!");
							#line4 : creating an anonymous inner class
		*   actually by seeing #line3 and #line4, there is no difference and also both object are printing the same result.
		*   but they are actually not same. There is difference what else can anonymous inner class does from #line3.
		*   and from #line4 , its not exactly creating the anonymous inner class.
		*/
	}
}
