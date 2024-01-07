package VMM;
import VMM.hashes.TLB_hash;

import java.util.*;
import java.io.File;
import java.util.Scanner;

public class run {


    public static void main(String[] args) throws Exception {
        File addresses = new File("/Users/dadjocy21students.desu.edu/Desktop/dev-me/AD_VMM_java/addresses.txt");
        Scanner scan = new Scanner(addresses);
        //These two lines read the address file
        int i = 1;

        page_table page_test = new page_table();
        TLB translator = new TLB();
        pm hard = new pm();
        //Initializes the page table and TLB

        while(scan.hasNextLine()){
            int address = scan.nextInt();// takes each individual address
            int page_num = (address >> 8) & 0x00FF;
            int offset = address & 0x00FF;

            System.out.print(i + ": " +address+" - page: "+page_num+" - offset: "+offset);
            int TLB_result = translator.TLB_search(page_num);
            if (TLB_result == -1){ //TLB miss
                System.out.print(" TLB miss");
                int page_result = page_test.table_lookup(page_num);
                if (page_result == -1){ //page fault
                    //THIS WILL BE PHYSICAL MEMORY
                    int newFrame = hard.update(page_num);
                    page_test.table_update(page_num, newFrame);
                    translator.TLB_update(page_num, newFrame);
                    System.out.print(" page fault");
                }
                else{// page hit
                    translator.TLB_update(page_num, page_result);
                    System.out.println(" Frame: "+ page_result);
                }
            }
            else{// TLB hit
                System.out.println(" Frame: "+ TLB_result);
            }


            //System.out.println(page_result);

            i++;
            System.out.println();
        }
        //hard.print();


        /*

        for (int i = 0; i<256; i++){
            System.out.println(page_test.getTable(i).getFrame_number());
            System.out.println(page_test.getTable(i).getValid());
        }

         */


    }
}
