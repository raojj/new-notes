package grammar.E_JavaInternet.B1_IPAdress;

import org.testng.annotations.Test;

import java.io.*;
import java.net.*;

/**
 * @Description：
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/211757
 */
public class demo_02 {
    @Test
    //TCP
    public void testClient(){
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);

            os = socket.getOutputStream();
            os.write("你好，我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if (os!=null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket!=null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testServer(){
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        OutputStreamWriter osw = null;
        try {
            ServerSocket ss = new ServerSocket(8899);
            socket = ss.accept();
            is = socket.getInputStream();
            osw = new OutputStreamWriter(new FileOutputStream(new File("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\E_JavaInternet\\B1_IPAdress\\test.txt")));
//        不建议这样写，可能存在乱码
//        byte[] buffer = new byte[1024];
//        int len;
//        while ((len=is.read(buffer))!=-1){
//            String str = new String(buffer,0,len);
//            System.out.print(str);
//        }
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[10];
            int len;
            while ((len = is.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());
            osw.write(baos.toString());
            System.out.println("收到了来自于："+socket.getInetAddress().getHostAddress()+"的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos!=null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }try {
                if (osw!=null) {
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is!=null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket!=null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    //UDP
    public void sender(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            String str = "我是UDP方式发射的导弹";
            byte[] data = str.getBytes();
            InetAddress inet = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket !=null) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void receiver(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9090);
            byte[] buffer = new byte[100];
            DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData(),0,packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket !=null) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    //URL
    public void testURL(){
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("https://t7.baidu.com/it/u=1595072465,3644073269&fm=193&f=GIF");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("D:\\APPs\\IDEA\\Project\\basic_knowledge\\basic_grammar_module\\src\\grammar\\E_JavaInternet\\B1_IPAdress\\beauty.jpg");
            byte[] buffer = new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("下载完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is!=null) {
                    is.close();
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
            try {
                if (urlConnection!=null) {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
