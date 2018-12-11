package CallableConcept3_invokeAny;
import java.util.HashMap;
import java.util.Map;
 
public class EmployeeDao {
 
   private static Map<Integer, Employee> emps ;
    
   static {
	   emps = new HashMap<Integer, Employee>();
	   
	   emps.put(1001, new Employee(1001, "Bharat", "Mumbai"));
	   emps.put(1002, new Employee(1001, "Jayannt", "Pune"));
	   emps.put(1003, new Employee(1001, "Ravi", "Banglore"));
	   emps.put(1004, new Employee(1001, "Kapil", "Delhi"));
	   emps.put(1005, new Employee(1001, "Gaurav", "Pune"));
   }
   
 
    public static Employee getEmployeeById(int empId) {
        return emps.get(empId);
    }
}