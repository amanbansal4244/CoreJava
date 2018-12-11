package CallableConcept2_invokeAll;
import java.util.concurrent.Callable;
 
 
public class TaskAsCallable implements Callable<Employee>{
 
    private int empId;
     
    public TaskAsCallable(int empId) {
        this.empId = empId;
    }
     
    public Employee call() throws Exception {
         
        /* this is where your business logic goes...
         */
        return EmployeeDao.getEmployeeById(this.empId);
    }
}