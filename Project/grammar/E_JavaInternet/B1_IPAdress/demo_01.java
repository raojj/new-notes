package grammar.E_JavaInternet.B1_IPAdress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description：
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/211508
 */
public class demo_01 {
    public static void main(String[] args){
        try {
            InetAddress inet = InetAddress.getByName("192.168.10.14");
            System.out.println(inet);
            InetAddress inet1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet1);
            System.out.println(InetAddress.getLocalHost());
            System.out.println(inet1.getHostName());
            System.out.println(inet1.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
