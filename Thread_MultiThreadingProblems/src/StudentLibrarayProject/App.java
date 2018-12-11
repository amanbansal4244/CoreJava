package StudentLibrarayProject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	
	public static void main(String[] args) {
		
		Student[] students=null;
		Book[] books = null;
		/*Number of threads is going to be equal to the no of the Student.*/
		ExecutorService executor = Executors.newFixedThreadPool(Constants.NUMBER_OF_STUDENTS);
		
		try{
			
			books=new Book[Constants.NUMBER_OF_BOOKS];
			students=new Student[Constants.NUMBER_OF_STUDENTS];
			
			//Initializing the Book.
			for(int i=0;i<Constants.NUMBER_OF_BOOKS;i++){
				books[i]=new Book(i);
			}
			
			//Initializing the Student.
			for(int i=0;i<Constants.NUMBER_OF_STUDENTS;i++){
				//Every single Student object is going to have one directional array of Books.
				students[i]=new Student(i,books);
				//running the given thread of Student.
				executor.execute(students[i]);
			}						
		}catch(Exception e){
			e.printStackTrace();
			executor.shutdown();
		}finally{
			executor.shutdown();
		}
	}
}