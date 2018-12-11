package TriplePointProblem;
/**
 *
 * @author aman
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import TriplePointProblem.Employee;

public class Schedule implements Runnable, ProblemInterface
{
    ArrayList<Task> listObj;
    Employee empObj;
    
    Employee emp1,emp2,emp3;
    Task task1,task2,task3;
    ArrayList<Task> al1, al2, al3;
    
    Schedule(){
    	
    }
	public Schedule(Employee emp, ArrayList<Task>list)       
	{
		this.empObj=emp;
		this.listObj=list;
	    Collections.sort(listObj,new PrioritizedBasedOnTheServiceFee());
	}
	
	public Schedule(ArrayList<Task> list,Employee emp)       
	{
		this.empObj=emp;
		this.listObj=list;
	    Collections.sort(listObj,new PrioritizedBasedOnTheTimeTaken());
	}
	
	public void run()
    {
		
	       System.out.println("Employee name's"+ " " + this.empObj.employeeName()+" "+"started.");
		   Iterator<Task> iterator = listObj.iterator();
		   while(iterator.hasNext())
		   {
		       Task task=(Task)iterator.next();
		       System.out.println("Employee:"+" "+empObj.employeeName()+","+"Task's name"+":"+task.taskName()+","+"Time taken="+ ":"+task.timeTaken()+"," +"Service fees"+ ":"+task.serviceFee());
		   }
		  System.out.println("Employee:"+" "+this.empObj.employeeName()+" "+"has completed all the asigned tasks.");
	}

	public void requiredData()
    {
    	emp1=new Employee("Joe","Trainee");
    	emp2=new Employee("Smith","Expert");
    	emp3=new Employee("Walker","Employee");
         
        task1=new Task("Car-Wash",100,2);
        task2=new Task("Car-Repair",1000,5);
        task3=new Task("Car-Paint",1100,4);
         
         
        al1=new ArrayList<Task>();
	        al1.add(task1);
	        al1.add(task2);
	        al1.add(task3);
	        
        al2=new ArrayList<Task>();  
        	al2.add(task2);
        
        al3=new ArrayList<Task>();   
        	al3.add(task2);
        	al3.add(task3);
    
    }
    
	public void serviceBasedTask()
     {
    	 System.out.println("\nService Priority Based Tasks Started.\n");
    	
         ExecutorService executor = Executors.newFixedThreadPool(3);
     
         Runnable runnable1=new Schedule(emp1,al1);
         Runnable runnable2=new Schedule(emp2,al2);
         Runnable runnable3=new Schedule(emp3,al3);
         
         Future future1 = executor.submit(runnable1);
         Future future2=executor.submit(runnable2);
         Future future3=executor.submit(runnable3);
         
         try{
               while(future1.get()!=null && future2.get()!=null && future3.get()!=null)
               	{
              
               	}
            }
          catch(Exception e){}
            
          executor.shutdown();  
        
          while (!executor.isTerminated()) {  
        	  
          } 
     }
      
	public void timeBasedTask()
        {
        	 System.out.println("\nTime Priority Based Tasks Started:\n");
        	 
	         ExecutorService executor = Executors.newFixedThreadPool(3);
	         
	         Runnable runnable1=new Schedule(al1,emp1);
	         Runnable runnable2=new Schedule(al2,emp2);
	         Runnable runnable3=new Schedule(al3,emp3);
	        
	         Future future1 = executor.submit(runnable1); 
	         Future future2=executor.submit(runnable2);
	         Future future3=executor.submit(runnable3);
	          try{
	                while(future1.get()!=null && future2.get()!=null && future3.get()!=null)
			          {
			              
			          }
	             }
	          catch(Exception e){}
	               
	          executor.shutdown();  
        }
    
}
