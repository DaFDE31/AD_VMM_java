package VMM;
import java.util.*;
import java.io.File;
import java.util.Scanner;

public class run {


    public static void main(String[] args) throws Exception {
        File addresses = new File("/Users/dadjocy21students.desu.edu/Desktop/dev-me/AD_VMM_java/addresses.txt");
        Scanner scan = new Scanner(addresses);
        int i = 0;
        page_table page_test = new page_table();

        while(scan.hasNextLine()){
            int address = Integer.valueOf(scan.nextLine()); // takes each individual address
            int page_num = (address >> 8) & 0x00FF;
            int offset = address & 0x00FF;

            /*
            Page Number = (logical_address >> 8) & 0x00FF
            Offset = logical_address & 0x00FF
             */
            System.out.println(i + ": " +address+" - page: "+page_num+" - offset: "+offset);

            System.out.println(page_test.table_lookup(page_num));

            i++;
        }


        /*

        for (int i = 0; i<256; i++){
            System.out.println(page_test.getTable(i).getFrame_number());
            System.out.println(page_test.getTable(i).getValid());
        }

         */


    }
}
