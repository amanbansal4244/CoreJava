package AvoidAnotherInstanceFromDeserializationProces;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;

public class AvoidAnotherInstanceFromDeserializationProcesWithoutOveridereadResolveMethod implements Serializable{
   
   private static final long serialVersionUID = 1L;
   private static AvoidAnotherInstanceFromDeserializationProcesWithoutOveridereadResolveMethod INSTANCE = null;
   //method returns instance of Singleton class.
   public static AvoidAnotherInstanceFromDeserializationProcesWithoutOveridereadResolveMethod getInstance() {
       if (INSTANCE == null) {
          synchronized (AvoidAnotherInstanceFromDeserializationProcesWithoutOveridereadResolveMethod.class) {
                 INSTANCE = new AvoidAnotherInstanceFromDeserializationProcesWithoutOveridereadResolveMethod();
                 }         
       }
       return INSTANCE;
   }
   //constructor
   private AvoidAnotherInstanceFromDeserializationProcesWithoutOveridereadResolveMethod() {}
   /**
    *customize Serialization process.
    */
   private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
      System.out.println("in readObject()");
          ois.defaultReadObject();
       synchronized (AvoidAnotherInstanceFromDeserializationProcesWithoutOveridereadResolveMethod.class) {
        if (INSTANCE == null) {
              INSTANCE = this;
        }
       }
   }
   /**
    * Method ensures that we don't break singleton pattern during DeSerialization process- method must not be called other than DeSerialization time.
    */
  /* private Object readResolve() throws ObjectStreamException {
      System.out.println("in readResolve()");
      return INSTANCE;
   }*/
   public static void main(String[] args) throws Throwable {
          System.out.println("Are objects same before serialization : "+ (getInstance() == getInstance()) );
                 OutputStream fout = new FileOutputStream("ser.txt");
                 ObjectOutput oout = new ObjectOutputStream(fout);
          System.out.println("Serialization process has started...");
        oout.writeObject(getInstance());
        fout.close();
        oout.close();
          System.out.println("Object Serialization completed.");
          //DeSerialization process >>>>>>>.
                     
          InputStream fin=new FileInputStream("ser.txt");
          ObjectInput oin=new ObjectInputStream(fin);
          System.out.println("\nDeSerialization process has started...");
          AvoidAnotherInstanceFromDeserializationProcesWithoutOveridereadResolveMethod deSerializedObj = (AvoidAnotherInstanceFromDeserializationProcesWithoutOveridereadResolveMethod)oin.readObject();
           fin.close();
        oin.close();
        System.out.println("Object DeSerialization completed.");
          System.out.println("Are objects same after serialization : "+ (deSerializedObj == getInstance()) );
          
   
}}
/*OUTPUT
Are objects same before serialization : true
Serialization process has started...
Object Serialization completed.

DeSerialization process has started...
in readObject()
Object DeSerialization completed.
Are objects same after serialization : false

*/


/*Note:
 * If we note output, objects are same before and after DeSerialization. 
 * So, we have succeeded in not to break Singleton pattern during DeSerialization process.
 * If we don't over- ride readResolve() method then  Are objects same after serialization : false 
 * and
 * its independent of over-riding of 
readObject() method( means no effect in this case if we do or don't over-ride readObject() method)

 * */
 