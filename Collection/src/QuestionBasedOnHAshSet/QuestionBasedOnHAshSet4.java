package QuestionBasedOnHAshSet;

import java.util.HashSet;

/*
Question : In class A , hash code and equals() method are overridden always return 1 and false respectively  .
 What will be the size of an Hash Set after adding 100 objects of class A to it?
*/public class QuestionBasedOnHAshSet4 {

	QuestionBasedOnHAshSet4(){
		
	}
	
	 @Override
	    public int hashCode() {
		 System.out.println(" In hashcode");
	       return 1;
	    }
	 
	 @Override
	    public boolean equals(Object obj) {
		 System.out.println("In equals method");
	        return false;
	    }
	
	 public static void main(String[] args) {
		 QuestionBasedOnHAshSet4 obj = new QuestionBasedOnHAshSet4();
		 
		 HashSet<QuestionBasedOnHAshSet4> setObj = new HashSet<QuestionBasedOnHAshSet4>();
		 for(int i =0; i< 5; i++){
			 setObj.add(new QuestionBasedOnHAshSet4());
		 }
		 
		 System.out.println("Size of hashset is :" + setObj.size());
		 System.out.println("Contains: " + setObj.contains(new QuestionBasedOnHAshSet4()));
	}
}
