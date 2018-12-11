




public class Singleton {

	private volatile static Singleton myObj; 
	/**
     * Create private constructor
     */
	
	private Singleton(){
		
	}
	/**
     * Create a static method to get instance.
     */
	public static Singleton getInstance(){
		if(myObj== null){                         // Single Checked
			synchronized (Singleton.class) {
				if(myObj== null){                  // Double checked
					myObj = new Singleton();
				}
			}
		}
		return myObj;
	}
	 public void getSomeThing(){
	        System.out.println("I am here....");
	    }
	 public static void main(String[] args) {
	      Singleton tmp = Singleton.getInstance( );
	      System.out.println("First time : " + tmp);
	      tmp.getSomeThing();
	      Singleton tmp1 = Singleton.getInstance( ); // 2nd object will not be created and Same object(tmp) will be get copied into temp1.
	      System.out.println("2nd time : " + tmp1);
	      tmp1.getSomeThing();
}
}
  