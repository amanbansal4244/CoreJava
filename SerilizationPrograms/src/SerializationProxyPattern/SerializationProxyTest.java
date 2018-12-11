package SerializationProxyPattern;

import java.io.IOException;
 
public class SerializationProxyTest {
 
    public static void main(String[] args) {
        String fileName = "data.ser";
         
        Data data = new Data("Pankaj");
         
        try {
            SerializationUtil.serialize(data, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        try {
            Data newData = (Data) SerializationUtil.deserialize(fileName);
            System.out.println(newData);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
 
}

/*Note:
 * When we run above class, we get below output in console.
   O/p: Data{data=Pankaj}

If you will open the data.ser file, you can see that DataProxy object is saved as stream in the file.
 * */
 