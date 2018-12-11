package ArrayBlockingQueue;
import java.io.*;
import java.util.concurrent.*;
 /**
  * Let’s see a full example that makes use of ArrayBlockingQueue in a file text search program that searches all text files in a 
  * directory for a given keyword. The program will print which file contains the keyword and at which line.
  * The producer class is a thread that recursively lists the content of a given directory for files that match the given extension, 
  * and then it puts each file on the queue.

 * This program demonstrates using ArrayBlockingQueue
 * in a producer-consumer application.
 *
 */
public class FileTextSearch_Main {
    public static void main(String[] args) {
        String dirPath = args[0];
        String extension = args[1];
        String keyword = args[2];
 
        BlockingQueue<File> queue = new ArrayBlockingQueue<>(100);
 
        DirectoryListerProducer lister = new DirectoryListerProducer(queue, new File(dirPath), extension);
        lister.start();
 
        for (int i = 0; i < 10; i++) {
            FileParserConsumer parser = new FileParserConsumer(queue, keyword);
            parser.start();
        }
    }
}