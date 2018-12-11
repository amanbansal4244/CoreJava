package CountDownLatchConcept2_DEV_QAExample;

import java.util.concurrent.CountDownLatch;

public class ManagerMain {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        
        MyDevTeam teamDevA = new MyDevTeam(countDownLatch, "devA");
        MyDevTeam teamDevB = new MyDevTeam(countDownLatch, "devB");
        
        teamDevA.start();
        teamDevB.start();
        
        countDownLatch.await();
        
        MyQATeam qa = new MyQATeam();
        qa.start();
    }   
}
	
	
	
