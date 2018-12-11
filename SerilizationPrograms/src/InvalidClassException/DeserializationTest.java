package InvalidClassException;
/*Note:
 * Now uncomment the “password” or comment "ID" variable  and it’s getter-setter methods from Employee class and run it. You will get below exception;
 
java.io.InvalidClassException: com.journaldev.serialization.Employee; local class incompatible: stream classdesc serialVersionUID = -6470090944414208496, local class serialVersionUID = -6234198221249432383
    at java.io.ObjectStreamClass.initNonProxy(ObjectStreamClass.java:604)
    at java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:1601)
    at java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1514)
    at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:1750)
    at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1347)
    at java.io.ObjectInputStream.readObject(ObjectInputStream.java:369)
    at com.journaldev.serialization.SerializationUtil.deserialize(SerializationUtil.java:22)
    at com.journaldev.serialization.DeserializationTest.main(DeserializationTest.java:13)
empNew Object::null
 * 
 * */
import java.io.IOException;

public class DeserializationTest {
 
    public static void main(String[] args) {
 
        String fileName="employee.ser";
        Employee empNew = null;
         
        try {
            empNew = (Employee) SerializationUtil.deserialize(fileName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
         
        System.out.println("empNew Object::"+empNew);
         
    }
 
}