package File_Java_NIO_Concept;
 
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;
 
public class ReadFileWithMappedByteBuffer
{
    public static void main(String[] args) throws IOException
    {
    	long startTime = System.nanoTime();
    	
    	// Reading file in only read access. You can use '"rw" for read and write purpose.
    	RandomAccessFile aFile = new RandomAccessFile("D:\\AmanLargeFile.txt", "r"); 
        FileChannel inChannel = aFile.getChannel();
        //MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, 32*1024);
        buffer.load(); 
        for (int i = 0; i < buffer.limit(); i++)
        {
           // System.out.print((char) buffer.get());
        }
        buffer.clear(); // do something with the data and clear/compact it.
        inChannel.close();
        aFile.close();
        
        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
    }
}