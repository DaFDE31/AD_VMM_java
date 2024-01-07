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

        page_table page_test = new page_table();
        TLB translator = new TLB();
        pm hard = new pm();
        //Initializes the page table and TLB

        while(scan.hasNextLine()){
            int address = scan.nextInt();// takes each individual address
            int page_num = (address >> 8) & 0x00FF;
            int offset = address & 0x00FF;

            int TLB_result = translator.TLB_search(page_num);

            if (TLB_result == -1){ //TLB miss
                System.out.print("TLB miss");
                int page_result = page_test.table_lookup(page_num);
                if (page_result == -1){ //page fault

                    //THIS WILL BE PHYSICAL MEMORY
                    int newFrame = hard.update(page_num);
                    page_test.table_update(page_num, newFrame);
                    page_result = newFrame;
                    System.out.print(" page fault");
                }
                translator.TLB_update(page_num, page_result);
                TLB_result = page_result;
                    //System.out.println("Page: "+page_num+" Frame: "+ TLB_result);

            }
            System.out.println();
            System.out.println("Page: "+page_num+" Frame: "+ TLB_result);
            System.out.printf("ADDRESS: (%d,%d) %d,%d,%d\n", page_num, offset, address, TLB_result*256+offset, hard.grab(TLB_result, offset));
            System.out.println();
        }

    }
}
