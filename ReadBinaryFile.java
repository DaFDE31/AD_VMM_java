import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadBinaryFile {

    public static void main(String[] args) throws IOException {
        // Create a File object representing the binary file.
        File file = new File("/Users/dadjocy21students.desu.edu/Desktop/dev-me/AD_VMM_java/BACKING_STORE.bin");


        // Create a FileInputStream object to read the file.
        FileInputStream fis = new FileInputStream(file);

        // Read the file using the read() method.
        byte[] bytes = new byte[(int) file.length()];
        int read = fis.read(bytes);

        // Close the FileInputStream object.
        fis.close();

        // Print the contents of the binary file.
        int count = 1;
        for (byte b : bytes) {
            System.out.println(count+": "+b);
            count++;
        }
    }
}