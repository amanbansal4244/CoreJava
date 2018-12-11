package PatternProblem;

public class PascalTriangle {

	static public void pascal(int n){
		
		for(int i =0; i< n;i++){
			for(int j=0; j<=n-i-2;j++){
				System.out.print(" ");
			}
				for(  int j =0; j<= i; j++){
					int res=fib(i)/(fib(j)*fib(i-j));
				System.out.print(res);
				}
				System.out.println("");
			}
			
		}
	
	
	static public int fib(int n){
		
		int fact=1;
		for(int j=1;j<=n;j++){
			fact = fact*j;
		}
		return fact;
	}
	
	public static void main(String[] args) {
		pascal(5);
	}
}
