package grammar.D_HigeLevel_Program.B4_IO;

import org.testng.annotations.Test;

import java.io.*;

/**
 * @Description：
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/192147
 */
public class demo_02 {
    //将hello.txt的内容读入程序中并输出到控制台
    @Test
    public void test_IO_FileReader_Read(){
        //1. 实例化file文件
        File file = new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\hello.txt");
        //2. 提供具体的流
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //3. 数据的读入
        try {
//            read()方法：返回读入的一个字符。如果达到文件末尾，返回-1
//            方式一
            int data = fileReader.read();
            while (data !=-1){
                System.out.print((char)data);
                data = fileReader.read();
            }
            //方式二
            int data1;
            while ((data1 = fileReader.read())!=-1){
                System.out.print((char)data1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        // 流的关闭
        }finally {
            try {
                if (fileReader!=null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test_IO_FileReader_Read_Overload() {
        FileReader fileReader = null;
        try {
            //1.File类实例化
            File file = new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\hello.txt");
            //2.FileReader的实例化
            fileReader = new FileReader(file);
            //3.读入操作
            char[] data = new char[5];
            int flag = 0;
            while (flag!=-1) {
                flag = fileReader.read(data);//read(char[] data):返回每次读入data数组中的字符的个数，如果达到文章末尾，返回-1
                //注意是小于flag
                for (int i = 0; i < flag; i++) {
                    System.out.print(data[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //4.资源的关闭
            try {
                if (fileReader!=null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void test_IO_FileWriter(){
        FileWriter fileWriter =null;
        try {
            //1.File类实例化
            File file = new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\hello.txt");
            //2.FileReader的实例化,文件不存在则自动创建一个，false是覆盖，true是追加
            fileWriter = new FileWriter(file,true);
            //3.写出操作(会覆盖原来的内容)
            fileWriter.write("I have a dream!\n");
            fileWriter.write("I want to learn JAVA!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //4.资源关闭
            try {
                if (fileWriter!=null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void test_IO_FileReader_Writer(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1. 创建File类的对象，指明读入和写出的文件
            File srcFile = new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\hello.txt");
            File destFile = new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\hello_write.txt");
            //2. 实例化FileReader和FileWriter
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            //3. 数据的读取与写入
            char[] cbuf = new char[10];
            int len=0;
            while (len!=-1){
                //以下两条语句顺序不可互换，因为len有等于-1的情况
                fw.write(cbuf,0,len);
                len = fr.read(cbuf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            //4. 资源的关闭
        try {
            if (fr!=null) {
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (fw!=null) {
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_FileInputStream(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1. 造文件
            File file = new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\test.png");
            File file1 = new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\test1.png");

            //2. 造流
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            //3. 读数据
            byte[] bytes = new byte[5];
            int len=0;
            while (len!=-1){
                fos.write(bytes,0,len);
                len = fis.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            try {
                if (fis!=null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }try {
                if (fos!=null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyStream(){
        long start = System.currentTimeMillis();
        String pathOut = "C:/Users/LENOVO/Desktop/3.1ppt.pptx";
        String pathInt = "C:\\Users\\LENOVO\\Desktop\\3.2ppt.pptx";
        copyStream(pathOut,pathInt);
        long end = System.currentTimeMillis();
        System.out.println("复制花费时间为："+(end-start));
    }

    @Test
    // Buffer缓冲流提供更快的读写速度
    public void testBufferedIOStream(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos =null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1. 造文件
            File file = new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\test.png");
            File file1 = new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\test1.png");

            //2. 造流
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3. 读数据
            byte[] bytes = new byte[5];
            int len=0;
            while (len!=-1){
                bos.write(bytes,0,len);
                len = bis.read(bytes);
                //bos.flush(); 清空缓冲器
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源:先关闭外层的流，后关闭内层的流
            try {
                if (bis!=null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos!=null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis!=null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos!=null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testBuffered_Reader_Writer(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //1. 造流
            br = new BufferedReader(new FileReader(new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\hello_write.txt")));

            //2. 写数据,也可以使用String数组，但不包含换行符，可以使用bw.newLine()来提供换行
            char[] chars = new char[10];
            int len = 0;
            while (len!=-1){
                bw.write(chars,0,len);
                len = br.read(chars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3. 资源关闭
            try {
                if (bw!=null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br!=null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    /*

     */
    public void test_InputStreamReader_OutputStreamWriter(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            //1. 创建文件
            File file = new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\hello.txt");
            File file1 = new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\D_HigeLevel_Program\\B4_IO\\hello_write.txt");

            //2. 创建流
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            isr = new InputStreamReader(fis,"utf-8");//使用系统默认的字符集（UTF-8）,具体使用哪个字符集取决于文件保存时所有的字符集
            osw = new OutputStreamWriter(fos,"utf-8");
            //3. 数据的读取
            char[] chars = new char[10];
            int len =0;
            while ((len = isr.read(chars))!=-1){
                String str = new String(chars,0,len);
                System.out.print(str);
                osw.write(chars,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 资源的关闭
            try {
                if (isr!=null) {
                    isr.close();
                }
            } catch (IOException e) {
               e.printStackTrace();
            }
            try {
                if (osw!=null) {
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }try {
                if (fos!=null) {
                    fos.close();
                }
            } catch (IOException e) {
               e.printStackTrace();
            }
            try {
                if (fis!=null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyStream(String pathOut,String pathInt){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1. 造文件
            File file = new File(pathOut);
            File file1 = new File(pathInt);

            //2. 造流
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            //3. 读数据
            byte[] bytes = new byte[1024];
            int len=0;
            while (len!=-1){
                fos.write(bytes,0,len);
                len = fis.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            try{
                if (fis!=null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }try {
                if (fos!=null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
