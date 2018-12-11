package _7ScheduledThreadPoolExecutor;

import java.util.Date;

class Task implements Runnable
{
    private String name;
 
    public Task(String name) {
        this.name = name;
    }
     
    public String getName() {
        return name;
    }
 
    @Override
    public void run() 
    {
        try {
            System.out.println("Thread name : " + Thread.currentThread().getName()+ ":" +"Doing a task during : " + name + " - Time - " + new Date());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}