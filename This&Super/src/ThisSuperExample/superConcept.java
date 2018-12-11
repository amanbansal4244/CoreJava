package ThisSuperExample;


public class superConcept
{
	int x;
	superConcept()
	{
		System.out.println("Constructor of Base class");
	}
	
	superConcept(int x)
	{
		this();
		this.x=x;
		System.out.println("Par Construcotr of Base Class");
		System.out.println("value of x:"+" "+x);
	}
}

 class Derived extends superConcept
{
	 String name;
	Derived()
	{
		super(20);
		System.out.println("Derived class default constructor");
		
	}
	Derived(String name)
	{
		this(); 
		this.name=name;
		System.out.println("Derived class Par. constructor");
	}
	
	public static void main(String[] args) 
	{
		Derived obj=new Derived("aman");
	}
}