public class run {

    public static void main(String[] args) {
        page_table page_test = new page_table();
        for (int i = 0; i<256; i++){
            System.out.println(page_test.getTable(i).getFrame_number());
            System.out.println(page_test.getTable(i).getValid());
        }


    }
}
