package grammar.C_FaceTo_Object.B_Code;
/*
代理模式（Proxy）：
1. 概述
   代理模式是Java开发中使用较多的一种设计模式。代理设计就是为其他对象提供一种代理以控制对这个对象的访问
   代理类ProxyInterface<------接口------>InterfaceImpl被代理类
2. 应用
   安全代理：屏蔽对真实对象的直接访问
   远程代理：通过代理类处理远程方法调用(RMI)
   延迟加载：先加载轻量级的代理对象，真正需要再加载真实对象
   静态代理：静态定义代理类
   动态代理：动态定义代理类
       JDK自带的动态代理，需要反射等知识
 */
public class C25_Proxy_Object {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.browse();
    }
}

interface Network{
    public abstract void browse();
}

//被代理类
class Server implements Network{
    @Override
    public void browse() {
        System.out.println("真实的服务器来访问网络");
    }
}

//代理类
class ProxyServer implements Network{

    private Network work;
    public ProxyServer(Network work){
        this.work = work;
    }
    public void check(){
        System.out.println("联网之前的检查工作");
    }
    @Override
    public void browse() {
        check();
        work.browse();
    }
}