package Transient_Concept;


import java.io.IOException;

public class SerializationTest {
    
   public static void main(String[] args) {
       String fileName="employee.ser";
       Employee emp = new Employee();
       emp.setId(100);
       emp.setName("Pankaj");
       emp.setSalary(5000);
       emp.setAdd("India");
        
       //serialize to file
       try {
           SerializationUtil.serialize(emp, fileName);
       } catch (IOException e) {
           e.printStackTrace();
           return;
       }
        
       Employee empNew = null;
       try {
           empNew = (Employee) SerializationUtil.deserialize(fileName);
       } catch (ClassNotFoundException | IOException e) {
           e.printStackTrace();
       }
        
       System.out.println("emp Object::"+emp);
       System.out.println("empNew Object::"+empNew);
   }
}
/*Note:
 * When we run above test program, we get following output.
emp Object::Employee{name=Pankaj,id=100,salary=5000}
empNew Object::Employee{name=Pankaj,id=100,salary=0}

Since salary is a transient variable, it’s value was not saved to file and hence not retrieved in the new object. 
Similarly static variable values are also not serialized since they belongs to class and not object.
 * */
