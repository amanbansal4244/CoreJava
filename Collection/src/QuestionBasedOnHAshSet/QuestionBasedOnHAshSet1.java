package QuestionBasedOnHAshSet;

import java.util.HashSet;

/*
Question : In class A , hash code and equals() method are overridden always return a new random integer 
using Math.round(Math.random) and true respectively  . 
10 objects of class A are added to a HashSet. What will be the output of below line?
*/
public class QuestionBasedOnHAshSet1 {

	QuestionBasedOnHAshSet1() {

	}

	@Override
	public int hashCode() {
		/*
		 * System.out.println("HAshcode : " +(int) Math.round(Math.random()) ); return
		 * (int) Math.round(Math.random());
		 */

		System.out.println("HAshcode : " + super.hashCode());
		return super.hashCode(); // always return different value
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("in equals Method");
		return true;
	}

	public static void main(String[] args) {
		QuestionBasedOnHAshSet1 obj = new QuestionBasedOnHAshSet1();

		HashSet setObj = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			setObj.add("aman");
		}

		System.out.println("Size of hashset is :" + setObj.size());
		System.out.println("Contains: " + setObj.contains(new QuestionBasedOnHAshSet1()));
	}
}
