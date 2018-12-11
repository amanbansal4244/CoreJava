import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
 
public class UnzipUtility {
    /**
     * Size of the buffer to read/write data
     */
    private static final int BUFFER_SIZE = 4096;
   // String retval = null;
    /**
     * Extracts a zip file specified by the zipFilePath to a directory specified by
     * destDirectory (will be created if does not exists)
     * @param zipFilePath
     * @param destDirectory
     * @param ZipEntry 
     * @throws IOException
     */
    public void unzip(String zipFilePath, String destDirectory) throws IOException {
    	
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        File f = new File(zipFilePath);
        FileInputStream fin = new FileInputStream(f);
        ZipInputStream zipIn = new ZipInputStream(fin);
       
        ZipEntry entry = zipIn.getNextEntry();
        while (entry != null) {
        	//line 32 to 39 : logic written for proper set name of song followed by movie name
        	String temp[]= zipFilePath.split("\\/");
        	String movieName[]=temp[5].split(".zip");
            String str = entry.getName();
        	String retval[]= str.split("-", 0);
        	String str1[]= retval[1].trim().split("\\[");
        	str1[0]= str1[0].trim()+"-"+movieName[0]+".mp3";
            String filePath = destDirectory + File.separator + str1[0].trim();
            
            //below line is for all generic for un zipping if u don't write logic form line 32 to line 39.
            //String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                extractFile(zipIn, filePath);
            } else {
                // if the entry is a directory, make the directory
                File dir = new File(filePath);
                dir.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
        f.delete(); // to delete zip file after unzip
    }
    /**
     * Extracts a zip entry (file entry)
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
}