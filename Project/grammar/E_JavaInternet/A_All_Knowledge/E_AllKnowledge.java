package grammar.E_JavaInternet.A_All_Knowledge;
/*
网络编程：

    网络编程概述
        Java是 Internet 上的语言，它从语言级上提供了对网络应用程序的支持，程序员能够很容易开发常见的网络应用程序。
        Java提供的网络类库，可以实现无痛的网络连接，联网的底层细节被隐藏在 Java 的本机安装系统里，由 JVM 进行控制。
        并且 Java 实现了一个跨平台的网络库，程序员面对的是一个统一的网络编程环境。

    网络基础
        计算机网络：
            把分布在不同地理区域的计算机与专门的外部设备用通信线路互连成一个规模大、功能强的网络系统，从而使众多的计算机可以方便地互相传递信息、
            共享硬件、软件、数据信息等资源。
        网络编程的目的：
            直接或间接地通过网络协议与其它计算机实现数据交换，进行通讯。
        网络编程中有两个主要的问题：
            如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
            找到主机后如何可靠高效地进行数据传输

    通讯要素：

        1. IP地址，端口号 B1:demo_01
             IP 地址：InetAddress
                唯一的标识 Internet 上的计算机（通信实体）
                本地回环地址(hostAddress)：127.0.0.1 主机名(hostName)：localhost
                IP地址分类方式1：IPV4 和 IPV6
                IPV4：4个字节组成，4个0-255。大概42亿，30亿都在北美，亚洲4亿。2011年初已经用尽。以点分十进制表示，如192.168.0.1
                IPV6：128位（16个字节），写成8个无符号整数，每个整数用四个十六进制位表示，数之间用冒号（：）分开，如：3ffe:3201:1401:1280:c8ff:fe4d:db39:1984
                IP地址分类方式2：公网地址(万维网使用)和私有地址(局域网使用)。192.168.开头的就是私有址址，范围即为192.168.0.0--192.168.255.255，专门为组织机构内部使用
                特点：不易记忆
             端口号标识正在计算机上运行的进程（程序）
                 不同的进程有不同的端口号
                 被规定为一个 16 位的整数 0~65535。
                 端口分类：
                 公认端口：0~1023。被预先定义的服务通信占用（如：HTTP占用端口80，FTP占用端口21，Telnet占用端口23）
                 注册端口：1024~49151。分配给用户进程或应用程序。（如：Tomcat占用端口8080，MySQL占用端口3306，Oracle占用端口1521等）。
                 动态/私有端口：49152~65535。
                端口号与IP地址的组合得出一个网络套接字：Socket。
             InetAddress类
                Internet上的主机有两种方式表示地址：
                    域名(hostName)：www.baidu.com
                    IP 地址(hostAddress)：202.108.35.210
                InetAddress类主要表示IP地址，两个子类：Inet4Address、Inet6Address。
                InetAddress类对象含有一个Internet主机地址的域名和IP地 址：www.baidu.com 和 202.108.35.210。
                域名容易记忆，当在连接网络时输入一个主机的域名后，域名服务器(DNS)负责将域名转化成IP地址，这样才能和主机建立连接。 -------域名解析
                InetAddress类没有提供公共的构造器，而是提供了如下几个静态方法来获取InetAddress实例
                    public static InetAddress getLocalHost()
                    public static InetAddress getByName(String host)
                InetAddress提供了如下几个常用的方法
                    public String getHostAddress()：返回 IP 地址字符串（以文本表现形式）。
                    public String getHostName()：获取此 IP 地址的主机名
                    public boolean isReachable(int timeout)：测试是否可以达到该地址

        2. 通讯协议
             概述
                网络通信协议
                计算机网络中实现通信必须有一些约定，即通信协议，对速率、传输代码、代码结构、传输控制步骤、出错控制等制定标准。
                问题：网络协议太复杂
                计算机网络通信涉及内容很多，比如指定源地址和目标地址，加密解密，压缩解压缩，差错控制，流量控制，路由控制，如何实现如此复杂的网络协议呢？
                通信协议分层的思想
                在制定协议时，把复杂成份分解成一些简单的成份，再将它们复合起来。最常用的复合方式是层次方式，即同层间可以通信、上一层可以调用下一层，而与
                再下一层不发生关系。各层互不影响，利于系统的开发和扩展。
             TCP/IP协议簇
                传输层协议中有两个非常重要的协议：
                     传输控制协议TCP(Transmission Control Protocol)
                     用户数据报协议UDP(User Datagram Protocol)。
                TCP/IP 以其两个主要协议：传输控制协议(TCP)和网络互联协议(IP)而得名，实际上是一组协议，包括多个具有不同功能且互为关联的协议。
                IP(Internet Protocol)协议是网络层的主要协议，支持网间互连的数据通信。
                TCP/IP协议模型从更实用的角度出发，形成了高效的四层体系结构，即物理链路层、IP层、传输层和应用层。
             TCP协议：
                 使用TCP协议前，须先建立TCP连接，形成传输数据通道
                 传输前，采用“三次握手”方式，点对点通信，是可靠的
                 TCP协议进行通信的两个应用进程：客户端、服务端。
                 在连接中可进行大数据量的传输
                 传输完毕，需释放已建立的连接，效率低
             UDP协议：
                 将数据、源、目的封装成数据包，不需要建立连接
                 每个数据报的大小限制在64K内
                 发送不管对方是否准备好，接收方收到也不确认，故是不可靠的
                 可以广播发送
                 发送数据结束时无需释放资源，开销小，速度快

    Socket
        概述：
             利用套接字(Socket)开发网络应用程序早已被广泛的采用，以至于成为事实上的标准。
             网络上具有唯一标识的IP地址和端口号组合在一起才能构成唯一能识别的标识符套接字。
             通信的两端都要有Socket，是两台机器间通信的端点。
             网络通信其实就是Socket间的通信。
             Socket允许程序把网络连接当成一个流，数据在两个Socket间通过IO传输。
             一般主动发起通信的应用程序属客户端，等待通信请求的为服务端。
        Socket分类：
            流套接字（stream socket）：使用TCP提供可依赖的字节流服务
            数据报套接字（datagram socket）：使用UDP提供“尽力而为”的数据报服务
         Socket类的常用构造器：
             public Socket(InetAddress address,int port)创建一个流套接字并将其连接到指定 IP 地址的指定端口号。
             public Socket(String host,int port)创建一个流套接字并将其连接到指定主机上的指定端口号。
         Socket类的常用方法：
             public InputStream getInputStream()返回此套接字的输入流。可以用于接收网络消息
             public OutputStream getOutputStream()返回此套接字的输出流。可以用于发送网络消息
             public InetAddress getInetAddress()此套接字连接到的远程 IP 地址；如果套接字是未连接的，则返回 null。
             public InetAddress getLocalAddress()获取套接字绑定的本地地址。 即本端的IP地址
             public int getPort()此套接字连接到的远程端口号；如果尚未连接套接字，则返回 0。
             public int getLocalPort()返回此套接字绑定到的本地端口。 如果尚未绑定套接字，则返回 -1。即本端的
            端口号。
             public void close()关闭此套接字。套接字被关闭后，便不可在以后的网络连接中使用（即无法重新连接
            或重新绑定）。需要创建新的套接字对象。 关闭此套接字也将会关闭该套接字的 InputStream 和OutputStream。
             public void shutdownInput()如果在套接字上调用 shutdownInput() 后从套接字输入流读取内容，则流将
            返回 EOF（文件结束符）。 即不能在从此套接字的输入流中接收任何数据。
             public void shutdownOutput()禁用此套接字的输出流。对于 TCP 套接字，任何以前写入的数据都将被发
            送，并且后跟 TCP 的正常连接终止序列。 如果在套接字上调用 shutdownOutput() 后写入套接字输出流，
            则该流将抛出 IOException。 即不能通过此套接字的输出流发送任何数据。

    TCP网络编程B1:demo_02
         客户端Socket的工作过程包含以下四个基本的步骤：
             创建 Socket：根据指定服务端的 IP 地址或端口号构造 Socket 类对象。若服务器端响应，则建立客户端到服务器的通信线路。若连接失败，会出现异常。
                客户端程序可以使用Socket类创建对象，创建的同时会自动向服务器方发起连接。Socket的构造器是：
                    Socket(String host,int port)throws UnknownHostException,IOException：向服务器(域名是
                    host。端口号为port)发起TCP连接，若成功，则创建Socket对象，否则抛出异常。
                    Socket(InetAddress address,int port)throws IOException：根据InetAddress对象所表示的
                    IP地址以及端口号port发起连接。
                客户端建立socketAtClient对象的过程就是向服务器发出套接字连接请求
             打开连接到 Socket 的输入/出流： 使用 getInputStream()方法获得输入流，使用getOutputStream()方法获得输出流，进行数据传输
             按照一定的协议对 Socket 进行读/写操作：通过输入流读取服务器放入线路的信息（但不能读取自己放入线路的信息），通过输出流将信息写入线程。
             关闭 Socket：断开客户端到服务器的连接，释放线路
        服务器程序的工作过程包含以下四个基本的步骤：
            调用 ServerSocket(int port) ：创建一个服务器端套接字，并绑定到指定端口上。用于监听客户端的请求。
                ServerSocket 对象负责等待客户端请求建立套接字连接，类似邮局某个窗口中的业务员。也就是说，
                服务器必须事先建立一个等待客户请求建立套接字连接的ServerSocket对象。
                所谓“接收”客户的套接字请求，就是accept()方法会返回一个 Socket 对象
            调用 accept()：监听连接请求，如果客户端请求连接，则接受连接，返回通信套接字对象。
            调用 该Socket类对象的 getOutputStream() 和 getInputStream ()：获取输出流和输入流，开始网络数据的发送和接收。
            关闭ServerSocket和Socket对象：客户端访问结束，关闭通信套接字。
    UDP网络通信
             类 DatagramSocket 和 DatagramPacket 实现了基于 UDP 协议网络程序。
             UDP数据报通过数据报套接字 DatagramSocket 发送和接收，系统不保证UDP数据报一定能够安全送到目的地，也不能确定什么时候可以抵达。
             DatagramPacket 对象封装了UDP数据报，在数据报中包含了发送端的IP地址和端口号以及接收端的IP地址和端口号。
             UDP协议中每个数据报都给出了完整的地址信息，因此无须建立发送方和接收方的连接。如同发快递包裹一样。
        DatagramSocket 类的常用方法
             public DatagramSocket(int port)创建数据报套接字并将其绑定到本地主机上的指定端口。套接字将被
            绑定到通配符地址，IP 地址由内核来选择。
             public DatagramSocket(int port,InetAddress laddr)创建数据报套接字，将其绑定到指定的本地地址。
            本地端口必须在 0 到 65535 之间（包括两者）。如果 IP 地址为 0.0.0.0，套接字将被绑定到通配符地
            址，IP 地址由内核选择。
             public void close()关闭此数据报套接字。
             public void send(DatagramPacket p)从此套接字发送数据报包。DatagramPacket 包含的信息指示：将
            要发送的数据、其长度、远程主机的 IP 地址和远程主机的端口号。
             public void receive(DatagramPacket p)从此套接字接收数据报包。当此方法返回时，DatagramPacket
            的缓冲区填充了接收的数据。数据报包也包含发送方的 IP 地址和发送方机器上的端口号。 此方法
            在接收到数据报前一直阻塞。数据报包对象的 length 字段包含所接收信息的长度。如果信息比包的
            长度长，该信息将被截短。
             public InetAddress getLocalAddress()获取套接字绑定的本地地址。
             public int getLocalPort()返回此套接字绑定的本地主机上的端口号。
             public InetAddress getInetAddress()返回此套接字连接的地址。如果套接字未连接，则返回 null。
             public int getPort()返回此套接字的端口。如果套接字未连接，则返回 -1。
             public DatagramPacket(byte[] buf,int length)构造 DatagramPacket，用来接收长
            度为 length 的数据包。 length 参数必须小于等于 buf.length。
             public DatagramPacket(byte[] buf,int length,InetAddress address,int port)构造数
            据报包，用来将长度为 length 的包发送到指定主机上的指定端口号。length参数必须小于等于 buf.length。
             public InetAddress getAddress()返回某台机器的 IP 地址，此数据报将要发往该机器或者是从该机器接收到的。
             public int getPort()返回某台远程主机的端口号，此数据报将要发往该主机或者是从该主机接收到的。
             public byte[] getData()返回数据缓冲区。接收到的或将要发送的数据从缓冲区中的偏移量 offset 处开始，持续 length 长度。
             public int getLength()返回将要发送或接收到的数据的长度。
    URL类
        URL(Uniform Resource Locator)：统一资源定位符，它表示 Internet 上某一资源的地址。
        它是一种具体的URI，即URL可以用来标识一个资源，而且还指明了如何locate这个资源。
        通过 URL 我们可以访问 Internet 上的各种网络资源，比如最常见的 www，ftp 站点。浏览器通过解析给定的 URL 可以在网络上查找相应的文件或其他资源。
         URL的基本结构由5部分组成：
        <传输协议>://<主机名>:<端口号>/<文件名>#片段名?参数列表
            例如:
            http://192.168.1.100:8080/helloworld/index.jsp#a?username=shkstart&password=123
                #片段名：即锚点，例如看小说，直接定位到章节
                参数列表格式：参数名=参数值&参数名=参数值....
        为了表示URL，java.net 中实现了类 URL。我们可以通过下面的构造器来初始化一个 URL 对象：
            public URL (String spec)：通过一个表示URL地址的字符串可以构造一个URL对象。例
                如：URL url = new URL ("http://www.baidu.com/");
            public URL(URL context, String spec)：通过基 URL 和相对 URL 构造一个 URL 对象。
                例如：URL downloadUrl = new URL(url, “download.html")
            public URL(String protocol, String host, String file); 例如：new URL("http",
                "www.atguigu.com", “download. html");
            public URL(String protocol, String host, int port, String file); 例如: URL gamelan = new
                URL("http", "www.atguigu.com", 80, “download.html");
         URL类的构造器都声明抛出非运行时异常，必须要对这一异常进行处理，通常是用 try-catch 语句进行捕获。
        一个URL对象生成后，其属性是不能被改变的，但可以通过它给定的方法来获取这些属性：
            public String getProtocol( ) 获取该URL的协议名
            public String getHost( ) 获取该URL的主机名
            public String getPort( ) 获取该URL的端口号
            public String getPath( ) 获取该URL的文件路径
            public String getFile( ) 获取该URL的文件名
            public String getQuery( ) 获取该URL的查询名
        针对HTTP协议的URLConnection类
            URL的方法 openStream()：能从网络上读取数据
            若希望输出数据，例如向服务器端的 CGI （公共网关接口-Common Gateway
            Interface-的简称，是用户浏览器和服务器端的应用程序进行连接的接口）程序发送一
            些数据，则必须先与URL建立连接，然后才能对其进行读写，此时需要使用URLConnection 。
            URLConnection：表示到URL所引用的远程对象的连接。当与一个URL建立连接时，
            首先要在一个 URL 对象上通过方法 openConnection() 生成对应的 URLConnection
            对象。如果连接过程失败，将产生IOException.
                URL netchinaren = new URL ("http://www.baidu.com/index.shtml");
                URLConnectonn u = netchinaren.openConnection( );
            通过URLConnection对象获取的输入流和输出流，即可以与现有的CGI程序进行交互。
                public Object getContent( ) throws IOException
                public int getContentLength( )
                public String getContentType( )
                public long getDate( )
                public long getLastModified( )
                public InputStream getInputStream( )throws IOException
                public OutputSteram getOutputStream( )throws IOException
            URI、URL和URN的区别
                URI，是uniform resource identifier，统一资源标识符，用来唯一的标识一个资源。而URL是uniform resource locator，统一资源定位符，它是一种具体
                的URI，即URL可以用来标识一个资源，而且还指明了如何locate这个资源。而URN，uniform resource name，统一资源命名，是通过名字来标识资源，
                比如mailto:java-net@java.sun.com。也就是说，URI是以一种抽象的，高层次概念定义统一资源标识，而URL和URN则是具体的资源标识的方式。URL
                和URN都是一种URI。在Java的URI中，一个URI实例可以代表绝对的，也可以是相对的，只要它符合URI的语法规则。而URL类则不仅符合语义，还包含了定位该资源的信息，
                因此它不能是相对的。

反射 B3:demo_01
    概述“
        Reflection（反射）是被视为动态语言的关键，反射机制允许程序在执行期借助于Reflection API取得任何类的内部信息，并能直接操作任意对象的内部属性及方法。
        加载完类之后，在堆内存的方法区中就产生了一个Class类型的对象（一个类只有一个Class对象），这个对象就包含了完整的类的结构信息。我们可以通过这个对象看到类
         的结构。这个对象就像一面镜子，透过这个镜子看到类的结构，所以，我们形象的称之为：反射。
        Java反射机制概述 Java Reflection
         正常方式：引入需要的”包类”名称----->通过new实例化----->取得实例化对象
         反射方式：实例化对象----->getClass()方法----->得到完整的“包类”名
    动态语言
        1、动态语言是一类在运行时可以改变其结构的语言：例如新的函数、对象、甚至代码可以被引进，已有的函数可以被删除或是其他结构上的变化。通俗点说就是在运
          行时代码可以根据某些条件改变自身结构。主要动态语言：Object-C、C#、JavaScript、PHP、Python、Erlang。
        2、静态语言
          与动态语言相对应的，运行时结构不可变的语言就是静态语言。如Java、C、C++。
          Java不是动态语言，但Java可以称之为“准动态语言”。即Java有一定的动态性，我们可以利用反射机制、字节码操作获得类似动态语言的特性。Java的动态性让编程的时候更加灵活！
    Java反射机制研究及应用
         Java反射机制提供的功能
            在运行时判断任意一个对象所属的类
            在运行时构造任意一个类的对象
            在运行时判断任意一个类所具有的成员变量和方法
            在运行时获取泛型信息
            在运行时调用任意一个对象的成员变量和方法
            在运行时处理注解
            生成动态代理
         反射相关的主要API
             java.lang.Class:代表一个类
             java.lang.reflect.Method:代表类的方法
             java.lang.reflect.Field:代表类的成员变量
             java.lang.reflect.Constructor:代表类的构造器
             … …
    关于javac.lang.Class类的理解
        类的加载过程
         程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)，接着我们使用java.exe命令对某个字节码文件进行解释运行
         相当于将某个字节码文件加载到内存中，此过程就称为类的加载。加载到内存中的类就叫运行时类，此运行时类就是Class的一个实例
        对象照镜子后可以得到的信息：某个类的属性、方法和构造器、某个类到底实现了哪些接口。对于每个类而言，JRE 都为其保留一个不变的 Class 类型的对象。一个 Class 对象包含
        了特定某个结构(class/interface/enum/annotation/primitive type/void/[])的有关信息。
             Class本身也是一个类
             Class 对象只能由系统建立对象
             一个加载的类在 JVM 中只会有一个Class实例
             一个Class对象对应的是一个加载到JVM中的一个.class文件
             每个类的实例都会记得自己是由哪个 Class 实例所生成
             通过Class可以完整地得到一个类中的所有被加载的结构
             Class类是Reflection的根源，针对任何你想动态加载、运行的类，唯有先获得相应的Class对象
         Class常用方法
            方法名                                       功能说明
            static Class forName(String name)           返回指定类名 name 的 Class 对象
            Object newInstance()                        调用缺省构造函数，返回该Class对象的一个实例
            getName()                                   返回此Class对象所表示的实体（类、接口、数组类、基本类型或void）名称
            Class getSuperClass()                       返回当前Class对象的父类的Class对象
            Class [] getInterfaces()                    获取当前Class对象的接口
            ClassLoader getClassLoader()                返回该类的类加载器
            Class getSuperclass()                       返回表示此Class所表示的实体的超类的Class
            Constructor[] getConstructors()             返回一个包含某些Constructor对象的数组
            Field[] getDeclaredFields()                 返回Field对象的一个数组
            Method getMethod(String name,Class … paramTypes)返回一个Method对象，此对象的形参类型为paramType
         获取Class类的实例(四种方法)
            1）前提：若已知具体的类，通过类的class属性获取，该方法最为安全可靠，程序性能最高
                    实例：Class clazz = String.class;
            2）前提：已知某个类的实例，调用该实例的getClass()方法获取Class对象
                    实例：Class clazz = “www.atguigu.com”.getClass();
            3）前提：已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName()获取，可能抛出ClassNotFoundException
                    实例：Class clazz = Class.forName(“java.lang.String”);
            4）其他方式(不做要求)
                    ClassLoader cl = this.getClass().getClassLoader();
                    Class clazz4 = cl.loadClass(“类的全类名”);
    哪些对象可以获得Class文件
        （1）class：外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类
        （2）interface：接口
        （3）[]：数组
        （4）enum：枚举
        （5）annotation：注解@interface
        （6）primitive type：基本数据类型
        （7）void
    系统类加载器
        //1.获取一个系统类加载器
            • ClassLoader classloader = ClassLoader.getSystemClassLoader();
            • System.out.println(classloader);
        //2.获取系统类加载器的父类加载器，即扩展类加载器
            • classloader = classloader.getParent();
            • System.out.println(classloader);
        //3.获取扩展类加载器的父类加载器，即引导类加载器
            • classloader = classloader.getParent();
            • System.out.println(classloader);
        //4.测试当前类由哪个类加载器进行加载
            • classloader = Class.forName("exer2.ClassloaderDemo").getClassLoader();
            • System.out.println(classloader);
        //5.测试JDK提供的Object类由哪个类加载器加载
            • classloader =
            • Class.forName("java.lang.Object").getClassLoader();
            • System.out.println(classloader);
        //6.关于类加载器的一个主要方法：getResourceAsStream(String str):获取类路径下的指定文件的输入流
            • InputStream in = null;
            • in = this.getClass().getClassLoader().getResourceAsStream("exer2\\test.properties");
            • System.out.println(in);
    获取运行时类的完整结构
        1.实现的全部接口
             public Class<?>[] getInterfaces() 确定此对象所表示的类或接口实现的接口。
        2.所继承的父类
             public Class<? Super T> getSuperclass()返回表示此 Class 所表示的实体（类、接口、基本类型）的父类的Class。
        3.全部的构造器
             public Constructor<T>[] getConstructors()返回此 Class 对象所表示的类的所有public构造方法。
             public Constructor<T>[] getDeclaredConstructors()返回此 Class 对象表示的类声明的所有构造方法。
            Constructor类中：
             取得修饰符: public int getModifiers();
             取得方法名称: public String getName();
             取得参数的类型：public Class<?>[] getParameterTypes();
        4.全部的方法
             public Method[] getDeclaredMethods()返回此Class对象所表示的类或接口的全部方法
             public Method[] getMethods() 返回此Class对象所表示的类或接口的public的方法
             Method类中：
             public Class<?> getReturnType()取得全部的返回值
             public Class<?>[] getParameterTypes()取得全部的参数
             public int getModifiers()取得修饰符
             public Class<?>[] getExceptionTypes()取得异常信息
        5.全部的Field
            public Field[] getFields() 返回此Class对象所表示的类或接口的public的Field。
            public Field[] getDeclaredFields() 返回此Class对象所表示的类或接口的全部Field。
             Field方法中：
             public int getModifiers() 以整数形式返回此Field的修饰符
             public Class<?> getType() 得到Field的属性类型
             public String getName() 返回Field的名称。
        6. Annotation相关
             get Annotation(Class<T> annotationClass)
             getDeclaredAnnotations()
        7.泛型相关
            获取父类泛型类型：Type getGenericSuperclass()
            泛型类型：ParameterizedType
            获取实际的泛型类型参数数组：getActualTypeArguments()
        8.类所在的包 Package getPackage()
*/
