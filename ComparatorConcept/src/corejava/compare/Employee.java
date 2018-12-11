package corejava.compare;

public class Employee {
    private int id = -1;
    private String firstName = null;
    private String lastName = null;
    private int age = -1;
 
    public Employee(int id, String fName, String lName, int age) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
    }
 
    /*@Override
    public String toString() {
        return "Employee : " + id + " - " + firstName + " - " + lastName
                + " - " + age + "n";
    }*/
 
    public int getId() {
        return id;
    }
 
    public int getAge() {
        return age;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
}