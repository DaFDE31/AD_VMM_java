package VMM;

public class entry {
    private int frame_number = -1;
    private int valid;

    public entry() {
        valid = 0;
    }

    public void update(int frame_number){
        this.frame_number = frame_number;
        valid = 1;
    }

    public int getFrame_number() {
        return frame_number;
    }

    public int getValid() {
        return valid;
    }
}