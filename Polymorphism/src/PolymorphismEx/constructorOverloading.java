package PolymorphismEx;


public class constructorOverloading 
{

	int accid;
	String name;
	
	public constructorOverloading()
	{
		//this(23); //control does to par constructor
		System.out.println("defaut Constructor");
		// TODO Auto-generated constructor stub
	}
	
	public constructorOverloading(int accno)
	{
		this(); //control does to default constructor
		accid=accno;
		System.out.println("par constructor");
		this.getData(23); // We can call any method of class from constructor but cant call constructor from any method of class
	} 
	
	public void getData(int accno)
	{
		
		accid=accno;
		System.out.println("Acc id is "+accid);
	}
	
	public static void main(String a[])
	{
		//constructorOverloading obj=new constructorOverloading();// call default constructor
		constructorOverloading obj=new constructorOverloading(12);// first call parameterized constructor
		
		
	}
}
