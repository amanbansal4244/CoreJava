package Transient_Concept;
/*Note:
 * Notice that it’s a simple java bean with some properties and getter-setter methods. 
 * If you want an object property to be not serialized to stream, you can use transient keyword like 
 * I have done with salary variable.
 * */
import java.io.Serializable;

public class Employee implements Serializable {
 
//  private static final long serialVersionUID = -6470090944414208496L;
     
    private String name;
    private int id;
    transient private int salary;
    static private String add;
     
    public static String getAdd() {
		return add;
	}

	public static void setAdd(String add) {
		Employee.add = add;
	}

	@Override
    public String toString(){
        return "Employee{name="+name+",id="+id+",salary="+salary+",add="+add+"}";
    }
     
    //getter and setter methods
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public int getSalary() {
        return salary;
    }
 
    public void setSalary(int salary) {
        this.salary = salary;
    }
 
}