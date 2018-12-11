/*1. All the wrapper classes are already overrided toStirng() Method of object class
 		And toString() method of object class always print the hashcode.
 		
 		StringBuffer sb=new StringBuffer("amab"); // StringBuffer is not Wrapper Class but StringBuffer also already overrided toString() method of object class
												//that mean will internally call toString() of Object class
 		
 		System.out.println(sb);  // will print amab
 		
 		
 		If you try to print own class obj: will print fully Qualified class Name:
 		means classname+@+hashcode
 		
 		Aman obj= new Aman();
 		system.out.println(obj);   o/p:   aman@2276
 		
  2. Whenever we do in non wrapper class:   anything.toString()
  			then it first see ki us class ne toString() method ko override krva rakha h ya ni
  				agar krva rakha h to vo uske implementation ke acc value hume de dega
  				otherwise  vo object class ke toString() vale ko call krke hashcode m hume value de dega.
 
 
  */