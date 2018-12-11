package Immutable;

public class DerivedClass extends ImmutableWithoutFinalAsClass {
    private int realValue;

    public DerivedClass(int value) {
        super(value);

        this.realValue = value;
    }

    public void method1() {
    	System.out.println("Derived class getValue():" + realValue);
    }
    public void setValue(int newValue) {
        realValue = newValue;
    }

   public static void main(String[] arg){
	   
	   ImmutableWithoutFinalAsClass obj1 = new ImmutableWithoutFinalAsClass(2);
	   obj1.method1();
	   DerivedClass obj = new DerivedClass(4);
	   obj.method1();
	   obj1.method1();
	   obj1.getValue();
	   /*ImmutableWithoutFinalAsClass immObj = (ImmutableWithoutFinalAsClass) obj;              
       System.out.println(immObj.getValue());
       obj.setValue(8);
       
       System.out.println(immObj.getValue());*/   
   }
}