/*If two objects are equal according to the equals(Object) method, 
 then calling the hashCode method on each of the two objects must produce the same integer result..
 	
 It is not required that if two objects are unequal according to the equals(java.lang.Object) method, 
 then calling the hashCode method on each of the two objects must produce distinct integer results. However,
  the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hashtables
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.StyledEditorKit.BoldAction;


 class Person{

	 	private String name;
	 	private int age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
		//constructor
		public Person(String name, int age){
			this.name=name;
			this.age=age;
		}
		
		@Override
		public boolean equals(Object o){
			if(o == null || o.getClass() != this.getClass()){
				return false;
			}
			
			
			if(!(o instanceof Person)){
				return false;
			}
			
			Person obj = (Person) o;
			
			if((this.name == null ) ? (obj.name !=null) : !this.name.equals(obj.name))
			{
				return false;
			}
			if(this.age != obj.age){ 
	        	 return false;
	        }
			return true;
			
		}
		
		@Override
		public int hashCode(){
			int hash =3;
			hash = 2* hash+ (this.name!=null ? this.name.hashCode() : 0);
			hash = 2 * hash + this.age;
			return hash;
			
		}
}
 
 
 class EqualsHashCodeOverrides {

	 public static void main(String[] args) {

		ArrayList<Person> al = new ArrayList<Person>();
		al.add(new Person("Aman", 24));
		al.add(new Person("Ama", 24));
		al.add(new Person("Aman", 28));
		al.add(new Person("Aman", 24));
 
		for(int i=0; i < al.size(); i++){
			for(int y= i+1; y<= al.size() -1 ; y++ ){
				System.out.println(" -- " + al.get(i).getName() + "- vs - " + al.get(y).getName());
				boolean check = al.get(i).equals(al.get(y));
				System.out.println("Is objects equals" + " " + check);
				System.out.println("Hash code of first obj" + " " + al.get(i).hashCode() + " and " + " Hash Code of 2nd Object" + " " + al.get(y).hashCode() );
			}
		}
		String checkHashCodeNeeded = "amanbansal";
		 Map<Character, Integer> dupMap = new HashMap<Character, Integer>();
	        int count =0;
	        int max=0;
	        char[] chrs = checkHashCodeNeeded.toCharArray();
	        for(Character ch:chrs){
	            if(dupMap.containsKey(ch)){  //containsKey first checks whether hash code are equal or not, 
	            							 //if yes then further compare with equals method else don't compare with equals method.
	                dupMap.put(ch, dupMap.get(ch)+1);
	            } else {
	                dupMap.put(ch, 1);
	            }
		
	}
	 }
 }