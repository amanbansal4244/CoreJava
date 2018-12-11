
 class toStringConcept {
		
		 int i=10;
		 
	//@Override
		/*public String toString() {                // If i dont override toString() method then it will print hashCode
			return "StringBuffer1 [i=" + i + "]";
		}*/


	public void method(){     
		System.out.println(i);
	}

	public static void main(String[] args) {
		String st = new String("Aman Bansal"); // String is not a wrapper class but String also already overrided toString() method of object class
												//that mean will internally call toString() of Object class
			System.out.println(st);
			
			Integer in= new Integer(1); // Interger is wrapper class
			System.out.println(in);
			
			Character c = new Character('A');
			
		toStringConcept obj=new toStringConcept();
		System.out.println(obj);		// Will print hashCode
		obj.method();
}
	
}
