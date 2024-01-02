package VMM;

public class pm {
    private Integer[] physical;
    public pm(){
        physical = new Integer[256*256];

        //For testing
        int num = 256*256-1;
        for (int bite = 0; bite < 256*256; bite++){
            physical[bite] =  num;
            num--;
        }
        /////////////////////
    }

    public int grab(int page, int offset){
        int target = page*256+offset;
        if (physical[target] != null){
            return physical[target]/256;
        }
        return update(page, offset);
    }

    //Update method grabs a value from backing store
    public int update(int page, int offset){
        int target = 0;// TO BE REPLACED TO GRAB A VALUE FROM BACKING STORE
        return physical[target];
    }

}
