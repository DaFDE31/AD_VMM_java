package VMM;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class pm {
    private Integer[] physical;
    private int frameNum;
    private byte[] binary = new byte[256*256];
    FileInputStream file;
    public pm() throws IOException{
        file = new FileInputStream("/Users/dadjocy21students.desu.edu/Desktop/dev-me/AD_VMM_java/BACKING_STORE.bin");
        physical = new Integer[256*256];

        int read = file.read(binary);
        frameNum = 0;


        /*/////////////////////////////////////////////
        for (int i = 0; i < binary.length; i++){
            System.out.println(i+": " +binary[i]);
        }
        System.out.println(read);
        /////////////////////////////////////////////*/

        //For testing
        for (int bite = 0; bite < 256*256; bite++){
            physical[bite] =  bite;
        }
        /////////////////////
    }
    public int grab(int frame, int offset){//This function should be used to grab the value at this offset
        return physical[frame*256+offset];
    }

    //Update method grabs a value from backing store and returns that frame into the page table and TLB
    public int update(int page){
        for (int b = 0; b<256; b++){
            physical[frameNum*256+b] = (int) binary[page*256+b]; //may or may not work?????
        }
        frameNum++;//updates the frame number for the next update

        return frameNum-1;//returns that frame number into the page table

    }
    /*public void print(){
        for (Integer hi : physical){
            System.out.println("hello: "+ hi);
        }
    }
     */

}
