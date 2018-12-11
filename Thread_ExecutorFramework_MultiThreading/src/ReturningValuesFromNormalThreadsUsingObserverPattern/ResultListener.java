package ReturningValuesFromNormalThreadsUsingObserverPattern;

public interface ResultListener<T> {

	void notifyResult(T result);
}
