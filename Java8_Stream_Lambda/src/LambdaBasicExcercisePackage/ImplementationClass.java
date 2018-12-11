package LambdaBasicExcercisePackage;

public class ImplementationClass implements ConditionInterface{

	@Override
	public boolean testCondition(Person p) {
		if (p.getLastName().startsWith("G")) {
			return true;
		}
		return false;
	}
	
}
