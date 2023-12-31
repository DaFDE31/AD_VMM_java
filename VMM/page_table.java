package VMM;

import VMM.entry;

public class page_table {
    private entry[] table;

    public page_table(){
        table = new entry[256];
        for (int index = 0; index < table.length; index++) {
            table[index] = new entry();
        }
    }

    public entry getTable(int index) {
        return table[index];
    }

    public int table_lookup(int page_number){
        if (table[page_number].getValid() == 0)
            return -1; //page fault
        else{
            return table[page_number].getFrame_number();
        }
    }

    public void table_update(int page_number, int frame_number){
        table[page_number].update(frame_number);
    }
}
