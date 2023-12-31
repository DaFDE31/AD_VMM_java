package VMM.hashes;
import java.util.*;
public class TLB_hash {
    private HashMap<Integer, Integer> TLB;
    private int [] pages;
    public TLB_hash(){ // Sets up the TLB to allow entries of page and frames.
        TLB = new HashMap<>();
        pages = new int[16];
    }
    public int TLB_search(int page){
        
        if (TLB.get(page) == null){
            return -1;
        }
        return TLB.get(page);
    }
//HAHAHAHAHAHAHAHAHAHAH

}
