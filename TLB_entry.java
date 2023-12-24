public class TLB_entry {
    private int page;
    private int frame;
    public TLB_entry(){
        page = -1;
        frame = -1;
    }

    public void update(int page, int frame){
        this.page = page;
        this.frame = frame;
    }

    public int getPage() {
        return page;
    }

    public int getFrame() {
        return frame;
    }
}
