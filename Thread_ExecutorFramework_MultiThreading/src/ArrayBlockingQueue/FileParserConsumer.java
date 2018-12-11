package ArrayBlockingQueue;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
 
/**
 * This consumer takes a File from the queue, and parses the file
 * to search for the given keyword.
 *
 */
public class FileParserConsumer extends Thread {
    private BlockingQueue<File> queue;
    private String keyword;
 
    public FileParserConsumer(BlockingQueue<File> queue, String keyword) {
        this.queue = queue;
        this.keyword = keyword;
    }
 
    public void run() {
        while (true) {
            try {
                File file = queue.peek();
 
                if (file != null && !file.getName().equals("END")) {
                    file = queue.take();
                    parseFile(file);
                } else {
                    break;
                }
            } catch (InterruptedException | IOException ex) {
                ex.printStackTrace();
            }
        }
    }
 
    private void parseFile(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        int lineCount = 0;
 
        for (String aLine : lines) {
            lineCount++;
            if (aLine.contains(keyword)) {
                String result = "Found in %s at line %d\n";
                System.out.printf(result, file.getAbsolutePath(), lineCount);
                break;
            }
        }
 
    }
}