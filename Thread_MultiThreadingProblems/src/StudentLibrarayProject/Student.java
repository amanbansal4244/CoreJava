package StudentLibrarayProject;

import java.util.Random;

public class Student implements Runnable {

	/*Every single Student is going to have individual ID, this is how we are going to identify the single Student */
	private int id;
	private Book[] books;

	public Student(int id, Book[] books) {
		this.books = books;
		this.id = id;
	}

	@Override
	public void run() {

		Random random = new Random();

		/*We are going to run infinite time simulation. */
		while (true) {
			/*Generating the random book id between 0 (inclusive) and the specified value (exclusive), */
			int bookId = random.nextInt(Constants.NUMBER_OF_BOOKS);

			try {
				/*Student tries to read a book. If Student is not able to acquire the lock on a particular book
				 * then it will try again to get the lock on different book in while loop by generating the new book random ID...and so on.. */
				books[bookId].readBook(this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String toString() {
		return "Student" + id;
	}
}
