package CountDownLatchConcept3_BaseHealthChecker;

/****
 * Problem Statement : Implement a scenario using countdown latch to check the health status of Cache, Database and Network
 * If everything goes fine in health checking of Cache, Database and Network then main thread do the processing.
 */
public class Main {
	public static void main(String[] args)
	{
		boolean result = false;
		try {
			result = ApplicationStartupUtil.checkExternalServices();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("External services validation completed !! Result was :: "+ result);
	}
}
