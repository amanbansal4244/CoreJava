import java.io.ObjectInputStream.GetField;


public class CloneDemo implements Cloneable{
	int id;
	String name;
	
	public CloneDemo(int id, String name) {
	this.id=id;
	this.name=name;
	}
	
	public void getName()
	{
		System.out.println("id= "+id);
		System.out.println("name= "+name);
	}
	
	public Object myClone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}


class Demo{
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneDemo c1=new CloneDemo(1, "Aman");
		c1.getName();
		System.out.println("class name= "+c1.getClass());
		
		CloneDemo c2=(CloneDemo) c1.myClone();
		c2.getName();
		System.out.println("class name= "+c2.getClass());
	}
}