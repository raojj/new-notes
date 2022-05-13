package grammar.D_HigeLevel_Program.B1_Exception_HighLevel.Code;

public class demo_01 {
    public static void main(String[] args) {
        //StackOverflowError
        main(args);
        //OutOfMemoryError
        Integer i = new Integer(1024*1024*1024*1024);
    }
}
