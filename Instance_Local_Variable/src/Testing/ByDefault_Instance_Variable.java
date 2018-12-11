package Testing;

public class ByDefault_Instance_Variable {
	
	private int size;
	private String name; 
	private float value;
	private boolean bb;
	
	//Setters & Getters:
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public boolean isBb() {
		return bb;
	}
	public void setBb(boolean bb) {
		this.bb = bb;
	}
	

		public static void main(String[] args) {
			ByDefault_Instance_Variable obj =new ByDefault_Instance_Variable();
			System.out.println("int" +"=" +obj.getSize());
			System.out.println("String" +"=" + obj.getName());
			System.out.println("Float" +"=" + obj.getValue());
			System.out.println("Boolean" +"=" + obj.isBb());
		}
	}
	

