package ReadingFileAndCommitingIntoDB;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileExample1 {

	private static final String FILENAME = "/Users/bansal/Desktop/Study Material/Workspace/Core_Java_Eclipse_Code/ExecutorFramework_MultiThreading/TestInput.txt";

	public static void main(String[] args) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String str1 ="Aman";
			String str2 ="Kumar";
			String str3 ="Bansal";
			String content = str1+"	"+str2+"		"+str3+"		"+"\n";

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			for(int i =0; i<150000; i++) {
				str1 = str1+i;
				str2 = str2+i;
				str3 = str3+i;
				bw.write(str1+"	"+str2+"		"+str3+"		"+"\n");
				str1 ="Aman";
				str2 ="Kumar";
				str3 ="Bansal";
			}

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}