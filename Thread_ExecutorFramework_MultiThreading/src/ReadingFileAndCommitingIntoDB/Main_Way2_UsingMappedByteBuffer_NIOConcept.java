package ReadingFileAndCommitingIntoDB;
 
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
/* 
This program is best way to read data from file as per my knowledge, 
i am calculating the time here, you can check simple filereader and my implemenation.
*/
public class Main_Way2_UsingMappedByteBuffer_NIOConcept
{
	private static final String records = null;
	//private static String fileName = "/Users/bansal/Desktop/Study Material/Workspace/Core_Java_Eclipse_Code/ExecutorFramework_MultiThreading/TestInput.txt";

	@SuppressWarnings("unchecked")
	private static void openFile() throws IOException {

		long startTime = System.nanoTime();

		RandomAccessFile aFile = new RandomAccessFile("/Users/bansal/Desktop/Study Material/Workspace/Core_Java_Eclipse_Code/ExecutorFramework_MultiThreading/TestInput.txt", "rw"); 
		FileChannel inChannel = aFile.getChannel();
		
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		//byteBuffer.load(); 
		 StringBuffer line = new StringBuffer();
		while(inChannel.read(byteBuffer) > 0)
        {
			byteBuffer.flip();
            for (int i = 0; i < byteBuffer.limit(); i++)
            {
                char ch = ((char) byteBuffer.get());
                if(ch=='\r'){
                    System.out.print(line+"[EOL]");
                    line=new StringBuffer();
                }else{
                    line.append(ch);
                }
            }
            byteBuffer.clear(); // do something with the data and clear/compact it.
        }
		
		/*for (int i = 0; i < byteBuffer.limit(); i++)
		{
			byte[] bytes;
			if(byteBuffer.hasArray()) {
			    bytes = byteBuffer.array();
			    String v = new String(bytes, Charset.forName("UTF-8" ));
			} else {
			    bytes = new byte[byteBuffer.remaining()];
			    byteBuffer.get(bytes);
			    String v = new String(bytes, Charset.forName("UTF-8" ));
			    System.out.println();
			}
			
			
		}*/
		byteBuffer.clear(); // do something with the data and clear/compact it.
		inChannel.close();
		aFile.close();

		long endTime = System.nanoTime();
		long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
		System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");

	}

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		java.sql.Timestamp timeStampStart = new java.sql.Timestamp(startTime);
		System.out.println("timeStampStart :" + timeStampStart);

		openFile();
	}	
}