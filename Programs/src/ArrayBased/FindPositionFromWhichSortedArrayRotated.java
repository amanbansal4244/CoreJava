package ArrayBased;

/*Let’s take few more example arrays >
1, 2, 3, 4  - Array has not been rotated

 2, 3, 4, 1  - Array has been rotated from 3 position

 3, 4, 1, 2  - Array has been rotated from 2 position

 4, 1, 2, 3  - Array has been rotated from 1 position
*/ 
 
public class FindPositionFromWhichSortedArrayRotated {
    
    public static void main(String[] args) {
           int ar[] = { 2, 3, 4, 1 };
         /*  for (int n : ar)
                  System.out.print(n + " ");
           System.out.print(" : ");
           */
           for (int i = 0; i < ar.length; i++) {
                  if (i + 1 == ar.length) {
                        System.out.println("Array has not been rotated");
                  } else {
                        if (ar[i] > ar[i + 1]) {
                               System.out.println("Array has been rotated from " + (i+1)
                                             + " position");
                               break;
                        }
                  }
           } //end for loop
 
    }
}