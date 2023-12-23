public interface project {
    //Struct for an entry in the page table




    void page_establish();// invalidate all entries

    void page_update(int page); //grabs a value from the backing store and puts it in the page table

    int page_search(int page);//Should be changed to return a value to the TLB

    public void PMget(int frame, int offset);

    int findAddress(int targetLineNum);

    int TLB_lookup(int page);

    void TLB_insert(int page, int frame);

    /**
     * addressTranslator - Updates the page number and offset based on the inputted logical address
     */
    void addressTranslator(int logical_address);
}