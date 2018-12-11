
public class CheckPasswordSecurity {

	public static void main(String[] args) {
		String strPassword = "Password";
		char[] charPassword = new char[]{'P','a','s','s','w','o','r','d'};
		
		String word = "samsung";
		String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream"};
//int size = sizeof(dictionary)/sizeof(dictionary[0]);
for (int i = 0; i < dictionary.length; i++){
		if (dictionary[i].compareTo(word) == 0){
			System.out.println("yes");
		}
}
//return true;
		
		System.out.println("String Pass:"+strPassword);  // it will print direct password which can be break security
		System.out.println("Char Pass:"+charPassword);   // it wont print direct password, it will get printed memory location of char array
	}
}
