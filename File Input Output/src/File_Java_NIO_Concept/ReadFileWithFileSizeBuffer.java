package File_Java_NIO_Concept;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;
 
public class ReadFileWithFileSizeBuffer
{
    public static void main(String args[])
    {
    	 long startTime = System.nanoTime();
        try
        {
            RandomAccessFile aFile = new RandomAccessFile("D:\\AmanLargeFile.txt", "rw");
            FileChannel inChannel = aFile.getChannel();
            long fileSize = inChannel.size();
            ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);
            inChannel.read(buffer);
            //buffer.rewind();
            buffer.flip();
            for (int i = 0; i < fileSize; i++)
            {
                //System.out.print((char) buffer.get());
            }
            inChannel.close();
            aFile.close();
        }
        catch (IOException exc)
        {
            System.out.println(exc);
            System.exit(1);
        }
        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
    }
}