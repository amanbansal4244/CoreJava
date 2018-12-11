package SingletonWithReflection;

import java.lang.reflect.*;

public class TestSingleton_ThrowsExceptionInPrivateConstrutor {
  public static void main(String[] args) throws ReflectiveOperationException {
    System.out.println("Inside main(): Getting the singleton instance using getInstance()...");
    JavaSingleton_ThrowsExceptionInPrivateConstrutor s1 = JavaSingleton_ThrowsExceptionInPrivateConstrutor.getInstance();
    System.out.println("First time : " + s1);
    
    System.out.println("Inside main(): Trying to use reflection to get another instance...");
    Class<JavaSingleton_ThrowsExceptionInPrivateConstrutor> clazz = JavaSingleton_ThrowsExceptionInPrivateConstrutor.class;
    Constructor<JavaSingleton_ThrowsExceptionInPrivateConstrutor> cons = clazz.getDeclaredConstructor();
    cons.setAccessible(true);
    JavaSingleton_ThrowsExceptionInPrivateConstrutor s2 = cons.newInstance();
    System.out.println("2nd time : " + s2);

  }
}