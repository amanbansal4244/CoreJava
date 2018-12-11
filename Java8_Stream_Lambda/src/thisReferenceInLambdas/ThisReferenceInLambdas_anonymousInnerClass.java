package thisReferenceInLambdas;

import java.io.InputStream;
import java.io.OutputStream;

public class ThisReferenceInLambdas_anonymousInnerClass {

	public void doProcess(int i , ProcessInterface p){ 
		p.process(i);
	}
	public static void main(String[] args) {
		
		ThisReferenceInLambdas_anonymousInnerClass thisReferenceInLambdas_anonymousInnerClass =  new  ThisReferenceInLambdas_anonymousInnerClass();
		thisReferenceInLambdas_anonymousInnerClass.doProcess(10, new ProcessInterface() {
			public void process(int i){
				System.out.println("value of i is : " + i);
				System.out.println(this); 
			/*
			o/p: value of i is : 10
				thisReferenceInLambdas.ThisReferenceInLambdas$1@7852e922	
			Note:
				Here, 'this' is the instance of 'ProcessInterface' interface (as we can see in o/p)
				because we are creating an object by having anonymous inner class.	
				
			*/	
			}
		});
	}
}


