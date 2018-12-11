package thisReferenceInLambdas;

import java.io.InputStream;
import java.io.OutputStream;

public class ThisReferenceInLambdas_usingLambdaExpression {

	public void doProcess(int i , ProcessInterface p){ 
		p.process(i);
	}
	
	public void execute(){
		doProcess(10, i -> {
			System.out.println("value of i is : " + i);
			System.out.println(this); 
			/*
			o/p:
				value of i is : 10
				thisReferenceInLambdas.ThisReferenceInLambdas_usingLambdaExpression@6ce253f1
			Note:
				Here, 'this' is the instance of 'ThisReferenceInLambdas_usingLambdaExpression' class (as we can see in o/p)
				because we are calling this method with instance of 'ThisReferenceInLambdas_usingLambdaExpression' class.
			*/
		});	
	}
	public static void main(String[] args) {
		
		ThisReferenceInLambdas_usingLambdaExpression thisReferenceInLambdas_anonymousInnerClass =  new  ThisReferenceInLambdas_usingLambdaExpression();
		thisReferenceInLambdas_anonymousInnerClass.doProcess(10, i -> {
			//System.out.println(this); // this will not work with in lambda expression because we can't use 'this' in static context
		});
		
		thisReferenceInLambdas_anonymousInnerClass.execute();
	}
}


