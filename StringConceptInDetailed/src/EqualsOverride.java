		
class Complex {
 
    private double re, im;
 
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
    
  /*  public int hashCode(){
        System.out.println("In hashcode");
        int hashcode = 0;
        hashcode = Complex*20;
        hashcode += Complex.hashCode();
        return hashcode;
    }*/

 
    // Overriding equals() to compare two Complex objects
    @Override
    public boolean equals(Object o) {
 
        // If the object is compared with itself then return true  
        if (o == this) {
            return true;
        }
 
        if(o == null){
        	return false;
        }
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Complex)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members 
        Complex c = (Complex) o;
        
        // Compare the data members and return accordingly 
       /* return Double.compare(re, c.re) == 0
                && Double.compare(im, c.im) == 0;
   */
        if(this.re != c.re){ //compare 10 of c1 obj and 10 of c2 obj
        	 return false;
        }
        if(this.im != c.im){ ////compare 15 of c1 obj and 16 of c2 obj
        	return false;
        }
        
        return true;
        }
}
 
// Driver class to test the Complex class
public class EqualsOverride {
 
    public static void main(String[] args) {
        Complex c1 = new Complex(10, 15);
        Complex c2 = new Complex(10, 15);
        if (c1.equals(c2)) {
            System.out.println("Equal ");
        } else {
            System.out.println("Not Equal ");
        }
        
        System.out.println("Hashcode of the key: "+c1.hashCode());
    }
}