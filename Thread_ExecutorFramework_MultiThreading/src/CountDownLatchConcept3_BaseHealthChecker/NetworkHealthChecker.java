package CountDownLatchConcept3_BaseHealthChecker;

import java.util.concurrent.CountDownLatch;

public class NetworkHealthChecker extends BaseHealthChecker
{
	public NetworkHealthChecker (CountDownLatch latch)  {
		super("NetworkHealthChecker Service", latch);
	}

	@Override
	public void verifyService()
	{
		System.out.println("Checking " + this.getServiceName());
		try
		{
			Thread.sleep(7000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(this.getServiceName() + " is UP");
	}
}
