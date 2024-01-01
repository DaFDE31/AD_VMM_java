package VMM;
import java.util.*;
import java.io.File;
import java.util.Scanner;

public class run {


    public static void main(String[] args) throws Exception {
        File addresses = new File("/Users/dadjocy21students.desu.edu/Desktop/dev-me/AD_VMM_java/addresses.txt");
        Scanner scan = new Scanner(addresses);
        int i = 0;

        while(scan.hasNextLine()){
            System.out.println(i + ": " +scan.nextLine());
            i++;
        }
        /*
        page_table page_test = new page_table();
        for (int i = 0; i<256; i++){
            System.out.println(page_test.getTable(i).getFrame_number());
            System.out.println(page_test.getTable(i).getValid());
        }

         */


    }
}
