package ExceptionHandlingApproach;

public class ExceptionHandlingApproachJava7 {
	public static void main(String[] args) {
		int [] somenumbers = { 1,2,3,4,5};
		int key =0;
		process(somenumbers,key );
		
	}

	private static void process(int[] somenumbers, int key) {
		for(int i : somenumbers){
			try{
				System.out.println(i/key);
			}catch(Exception e){
				System.out.println("Exception Occurred");
			}
		}
		
	}

}
