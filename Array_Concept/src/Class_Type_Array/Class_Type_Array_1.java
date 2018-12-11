package Class_Type_Array;

public class Class_Type_Array_1 {
	String title;
}
class BooksTestDrive1{
	public static void main(String[] args) {
		Class_Type_Array_1[] myBooks= new Class_Type_Array_1[3]; // Creats an array
		int x=-1;
		
		while(x<2)
		{
			x=x+1;
		
		myBooks[x]=new Class_Type_Array_1();  // Remember We have to actually make the Class_Type_Array_1 objects.
		if(x==0){
		myBooks[x].title="Java";
		}
		if(x==1){
			myBooks[x].title="Java1";
			}
		if(x==2){
			myBooks[x].title="Java2";
			}
		
		System.out.println(myBooks[x].title);
		
	}
	}
}