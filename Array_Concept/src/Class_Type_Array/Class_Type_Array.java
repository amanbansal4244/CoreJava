package Class_Type_Array;

public class Class_Type_Array {

	String title;
	String author;
	
}

class BooksTestDrive{
	public static void main(String[] args) {
		Class_Type_Array[] myBooks= new Class_Type_Array[3]; // Creats an array
		int x=0;
		
		myBooks[0]=new Class_Type_Array();  // Remember We have to actually make the Class_Type_Array objects.
		myBooks[1]=new Class_Type_Array();
		myBooks[2]=new Class_Type_Array();
		
	myBooks[0].title="Java";
	myBooks[1].title="Java1";
	myBooks[2].title="Java2";
	
	myBooks[0].author="Aman";
	myBooks[1].author="Aman1";
	myBooks[2].author="Aman2";

	
	while(x<3){
		System.out.println(myBooks[x].title);
		System.out.println("by");
		System.out.println(myBooks[x].author);
		x=x+1;
	}
	}
}