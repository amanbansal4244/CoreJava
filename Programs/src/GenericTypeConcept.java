//Problem:
/*Define a generic class Starts , having an instance method getmax(), which returns the maximum
 value in an array of any type of number, including integers, floats and doubles. 
 
 GenericTypeConcept class is already given
 */
class Starts<T>
{
	T obj;
	T [] newArray;
	
	
	
	public Starts(T[] inums) {
		this.newArray=inums;
	}
	
	
	public  <T extends Comparable<T>> T getmax() {
	   
	    T max =(T) newArray[0];
	    
	    for (int i = 0; i < newArray.length; i++){
	    	 if (((Comparable<T>) newArray[i]).compareTo(max) > 0)
	                max = (T) newArray[i];
	    }
	    
	    return max;
	}
}



//Preventing applicant from terminating JVM..
class MySecurityManager extends SecurityManager {
 @Override public void checkExit(int status) {
     throw new SecurityException();
 }	
}


class GenericTypeConcept {
    public static void main(String args[]) {
        
        // Preventing applicant from terminating JVM..
        MySecurityManager secManager = new MySecurityManager();
        System.setSecurityManager(secManager);
        
        Integer inums[] = { 4, 8, 0, 6, 1 };
        Starts<Integer> iob = new Starts<Integer>(inums);
        int i = -1;
        try {
            i = iob.getmax();
        }
        catch(SecurityException e) {
                System.out.println("Your method contains a statement that terminates the currently running JVM");
        }
        System.out.println("Maximum value in integer array : " + i);
        
        Double dnums[] = { 7.1, 3.2, 9.1, 9.4, 5.5 };
        Starts<Double> dob = new Starts<Double>(dnums);
        double d = dob.getmax();
        System.out.println("Maximum value in double array : " + d);
        
        Float fnums[] = { 8.1f, 5.9f, 9.7f, 7.4f, 9.9f };
        Starts<Float> fob = new Starts<Float>(fnums);
        float f = fob.getmax();
        System.out.print("Maximum value in float array : " + f);
    }
}

