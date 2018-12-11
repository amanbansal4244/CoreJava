package ReadingFileAndCommitingIntoDB;
 
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
/* 
This program is best way to read data from file as per my knowledge, 
i am caculating the time here, you can check simple filereader and my implemenation.
*/
public class Main_Way3_UsingJava8Stream_NIOConcept
{
	@SuppressWarnings("unchecked")
	private static void openFile() {
		long startTime = System.nanoTime();
		try {
			Path path = Paths.get("/Users/bansal/Desktop/Study Material/Workspace/Core_Java_Eclipse_Code/ExecutorFramework_MultiThreading/TestInput.txt");
			Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
			ExecutorService executorService = Executors.newFixedThreadPool(5);
			for(String line:(Iterable<String>) lines :: iterator) {
				//System.out.println("line:"+line);
				Runnable worker = new WorkerThread(line.split("\t")); 
				executorService.execute(worker);
			}
			executorService.shutdown();
		}catch(Exception e) {
			e.printStackTrace();
		}

		long endTime = System.nanoTime();
		long elapsedTimeInMillies = TimeUnit.MILLISECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS);
		System.out.println("Total Elapsed Time :" + elapsedTimeInMillies + "ms");
	}

	public static void main(String[] args) {
		openFile();
	}
}