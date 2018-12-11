package Serialization_Deserialization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.sql.Date;

public class Employee implements Serializable {

	private float salary;
	private String address;
	private String name;
	private int emp_id;
	private Date doj;
	
    private static final long serialVersionUID = 2L;
	
    Employee(float s, String a, String n, int id){
		this.salary = s;
		this.address = a;
		this.name = n;
		this.emp_id = id;
		//this.doj = d;
		
	}
	
	void display(){
		System.out.println("Salary"+ salary +"\t" + "Address"+ address +"\t" +"Name" +name +"\t" +"Emp_ID" + emp_id );
	}
	
	static Employee getData() throws NumberFormatException, IOException{
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("Enter Employee ID");
		int E_Id= Integer.parseInt(br.readLine());
		
		System.out.println("Enter Employee Name");
		String E_Name = br.readLine();
		
		System.out.println("Enter Employee Salary");
		float E_Salary = Float.parseFloat(br.readLine());
		
		System.out.println("Enter Employee Address");
		String E_Add = br.readLine();
		
		
		//Date E_doj = new Date();
		Employee e = new Employee(E_Salary,E_Add,E_Name,E_Id);
		return e;
	}
}
