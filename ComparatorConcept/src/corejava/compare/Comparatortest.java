package corejava.compare;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
public class Comparatortest {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "aTestName", "dLastName", 34);
        Employee e2 = new Employee(2, "nTestName", "pLastName", 320);
        Employee e3 = new Employee(3, "kTestName", "sLastName", 1);
        Employee e4 = new Employee(4, "dTestName", "zLastName", 25);
 
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(e2);
        employees.add(e3);
        employees.add(e1);
        employees.add(e4);
 
      //  Collections.sort(employees);
         
     // Sorted by firstName
        Collections.sort(employees, new FirstNameSorter());
        
        System.out.println("After Sorted by first name");
        for (int i = 0; i < employees.size(); i++) {

        	Employee ct=(Employee) employees.get(i);

        	System.out.println("Name: "+ct.getFirstName()+"||"+"Age: "+ct.getAge()+"||"+"Last Name: "+ct.getLastName());

        }

 
        //Sorted by last name
      Collections.sort(employees, new LastNameSorter());

      System.out.println("After Sorted by last name");
        for (int i = 0; i < employees.size(); i++) {

        	Employee ct=(Employee) employees.get(i);

        	System.out.println("Name: "+ct.getFirstName()+"||"+"Age: "+ct.getAge()+"||"+"Last Name: "+ct.getLastName());

        }
 
     // Sorted by age
        Collections.sort(employees, new AgeSorter());
       
        System.out.println("After Sorted by age name");
        for (int i = 0; i < employees.size(); i++) {

        	Employee ct=(Employee) employees.get(i);

        	System.out.println("Name: "+ct.getFirstName()+"||"+"Age: "+ct.getAge()+"||"+"Last Name: "+ct.getLastName());

        }
        
    }
}