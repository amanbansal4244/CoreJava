package NumberProblem;
/*An Armstrong number of three digits is an integer such that the sum of the cubes of its digits is equal to the number itself. 
 * For example, 371 is an Armstrong number since 3**3 + 7**3 + 1**3 = 371.
*/
public class MyArmstrongNumber {
	 
    public boolean isArmstrongNumber(int number){
       
       int remainder=0;
       int sum=0;
       int temp=number;
        while(temp > 0)
        {
        	remainder= temp%10;
        	temp = temp/10;
        	sum=sum+ remainder*remainder*remainder;
           
        }
        if(number == sum) {
            return true;
        } else {
            return false;
        }
    }
     
    public static void main(String a[]){
        MyArmstrongNumber man = new MyArmstrongNumber();
        System.out.println("Is 371 Armstrong number? "+man.isArmstrongNumber(371));
        System.out.println("Is 523 Armstrong number? "+man.isArmstrongNumber(523));
        System.out.println("Is 153 Armstrong number? "+man.isArmstrongNumber(153));
    }
}

