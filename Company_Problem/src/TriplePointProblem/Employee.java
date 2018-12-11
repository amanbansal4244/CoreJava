
package TriplePointProblem;

/**
 *
 * @author aman
 */
public class Employee {
	
    private String  empName;
    private String designation;
    
    public Employee(String empName,String designation)
    {
        this.empName=empName;
        this.designation=designation;
    }
    
    public String employeeName()
    {
        return empName; 
    }
    
    public String designationName()
    {
        return designation;
    }
}
