package CountDownLatchConcept2_DEV_QAExample;
class MyQATeam extends Thread {   
    @Override
    public void run() {
        System.out.println("Task assigned to QA team");
        try {
                Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Task finished by QA team");
    }
}