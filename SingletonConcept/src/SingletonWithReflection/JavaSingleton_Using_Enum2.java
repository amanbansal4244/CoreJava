package SingletonWithReflection;

public enum JavaSingleton_Using_Enum2 {
	mySingletonObj; 
	
	 public static void main(String[] args) {
		 JavaSingleton_Using_Enum2 tmp = JavaSingleton_Using_Enum2.mySingletonObj;
	      System.out.println("First time : " + tmp.hashCode());
	      JavaSingleton_Using_Enum2 tmp1 = JavaSingleton_Using_Enum2.mySingletonObj; // 2nd object will not be created and Same object(tmp) will be get copied into temp1.
	      System.out.println("2nd time : " + tmp1.hashCode());
}
}  