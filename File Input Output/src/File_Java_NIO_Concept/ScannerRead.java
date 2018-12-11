package File_Java_NIO_Concept;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ScannerRead {

    /**
     * This solution will iterate through all the lines in the file � allowing for processing of each line � 
     * without keeping references to them  i.e. without keeping them in memory.
     */
    
    public static void main(String[] args) {

        long startTime = System.nanoTime();
        try (Scanner sc = new Scanner(new File("D:\\AmanLargeFile.txt"), "UTF-8")) {
            long freeMemoryBefore = Runtime.getRuntime().freeMemory();
            while (sc.hasNextLine()) {
                
                String line = sc.nextLine();
            }
            
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                sc.ioException().printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            
        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms"  );
    }
}