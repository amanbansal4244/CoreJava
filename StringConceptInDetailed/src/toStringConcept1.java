
 class toStringConcept1 {
	 int i=10;
	 
	@Override
		public String toString() {
			//return "[i=" + "dd" + "]";
	return "aman";	
	}



	public static void main(String[] args) {
		String st = new String("Aman Bansal"); // String is not a wrapper class but String also alreay overrided toString() method of object class
												//that mean will internally call toString() of Object class
		
		System.out.println(st);   // it will print the value of st becuae we over rided toString() method.
		
		toStringConcept1 obj=new toStringConcept1();
		System.out.println(obj);		// Will print value of i
		
		
}
	
}
