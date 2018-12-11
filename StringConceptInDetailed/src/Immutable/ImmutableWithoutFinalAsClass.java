package Immutable;

public class ImmutableWithoutFinalAsClass {
    private  int value;

    public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public ImmutableWithoutFinalAsClass(int value) {
        this.value = value;
    }

    public void method1() {
    	System.out.println("Base class getValue():" + value);
    }
}