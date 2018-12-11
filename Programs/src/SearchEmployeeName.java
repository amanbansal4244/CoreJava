/*Given a class Employee


class Employee {
int age;
String fName;
String lName;
}
An UI searches for employees using either 'FirstName LastName' or 'LastName FirstName'. 
Give a solution that will return the employee details, in O(1) time. 
e.g. FirstName - John LastName - Walker 
both John Walker and Walker John should work in O(1). Tried using a hashmap, but search would be O(2).*/
public class SearchEmployeeName {

	/*class Employee{
		String fName;
		String lName;
		public int hashCode(){
		return (fname+lName).hashCode();
		}
		If you check hashcode and equals method hashcode method will return same hashcode for "abc" and "cba" and
				these two strings will be different when equals method will get executed so if we take fName+lName and 
				lName+fName method into account these two methods will be same as per hashcode but we need to provide 
				implementation of equals method in such a way that it will return true even if hashcode is equal so that
				we will get the same object
		}*/
	
}
