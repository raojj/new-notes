package grammar.D_HigeLevel_Program.B1_Exception_HighLevel.Code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class demo_04 {
    public static void main(String[] args) {

        try {
            methods1();
        }catch (IOException e){
            e.printStackTrace();
        }
        methods2();
    }

    public static void methods2(){
        try {
            methods1();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void methods1() throws IOException {
        methods();
    }

    public static void methods() throws FileNotFoundException, IOException{
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();
        while (data != -1) {
            System.out.println((char) data);
            data = fis.read();
        }
        fis.close();
    }
}
