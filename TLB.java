public class TLB {
    private TLB_entry[] TLB_table;
    private int index = 0;
    public TLB(){
        TLB_table = new TLB_entry[16];
        for (int pop = 0; pop < 16; pop++) {
            TLB_table[pop] = new TLB_entry();
        }
    }

    public void TLB_update(int page, int frame){
        TLB_table[index].update(page, frame);
        if (index <15){
            index++;
        }
        else{
            index = 0;
        }
    }
    public int TLB_search(int page){
        for (TLB_entry subject : TLB_table){
            if (subject.getPage() == page){
                return subject.getFrame();
            }
            if (subject.getPage() == -1){
                return -1;
            }
        }
        return -1;
    }
}
