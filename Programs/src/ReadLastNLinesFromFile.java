
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 *  Use a RandomAccessFile, you can use length and seek to get to a specific point near the end of the file
 *   and then read forward from there.
 */
public class ReadLastNLinesFromFile {
    public static String[] tailLines(String filename, int nLinesToRead) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "r");
        long lengthOfFile = randomAccessFile.length();
        long counterFromEnd = 1L;
        long newlineCounterGoal = nLinesToRead;
        int newlineCounter = 0;
        long tailPosition = 0L; // start of the end ;-)

        // If you want to get the last 10 lines,
        // and the last line ends with a newline, then you need to count back 11 newlines
        // if there is no trailing newline, then you only need to count back 10
        randomAccessFile.seek(lengthOfFile - 1L);
        char currentChar = (char) randomAccessFile.readByte();
        if(currentChar == '\n') {
            newlineCounterGoal++;
        }

        while(counterFromEnd <= lengthOfFile) {
            randomAccessFile.seek(lengthOfFile - counterFromEnd);
            if(randomAccessFile.readByte() == '\n') {
                newlineCounter++;
            }
            if(newlineCounter == newlineCounterGoal) {
                tailPosition = randomAccessFile.getFilePointer();
                break;
            }
            counterFromEnd++;
        }
        randomAccessFile.seek(tailPosition);

        String line;
        String[] lines = new String[nLinesToRead];
        int nLine = 0;
        while((line = randomAccessFile.readLine()) != null) {
            lines[nLine++] = line;
        }
        return lines;
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the file location along with file name: "); // e.g. D:\TestInput.txt
		String inputFile=br.readLine();
        String[] lines = tailLines(inputFile, 4);
        for(String line : lines) {
            if(line != null) {
                System.out.println(line);
            }
        }
    }
}