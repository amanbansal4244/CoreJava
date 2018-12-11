package SingletonWithReflection;

import java.lang.reflect.*;

public class TestSingleton_UsingEnum {
  public static void main(String[] args) throws ReflectiveOperationException {
	      
      JavaSingleton_Using_Enum singleton = JavaSingleton_Using_Enum.mySingletonObj;
      Constructor constructor = singleton.getClass().getDeclaredConstructor(new Class[0]);
      constructor.setAccessible(true);
      JavaSingleton_Using_Enum singleton2 = (JavaSingleton_Using_Enum) constructor.newInstance();
      if (singleton == singleton2) {
          System.out.println("Two objects are same");
      } else {
          System.out.println("Two objects are not same");
      }
  
  }
}