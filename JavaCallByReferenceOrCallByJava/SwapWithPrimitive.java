package Testing;

public class SwapWithPrimitive {

	
	public static void swap(int a1, int a2) {
		int temp = 0;
		temp = a1;
		a1 = a2;
		a2 = temp;
	}
	
	public static void main(String args[]) {
		 int a1 = 5;
		 int a2 = 7;
		
		
		System.out.println("Before Swap:- a1:" + a1 + "; a2:" + a2);
		swap(a1, a2);
		System.out.println("After Swap:- a1:" + a1 + "; a2:" + a2);
	}
}