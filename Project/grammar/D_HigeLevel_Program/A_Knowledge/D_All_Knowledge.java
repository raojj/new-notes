package grammar.D_HigeLevel_Program.A_Knowledge;
/*
异常：
    一.概述
        使用计算机语言进行项目开发的过程中，即使程序员把代码写的尽善尽美，在系统运行过程中仍然会遇到一些问题，因为
        很多问题不是靠代码能够避免的，比如：客户输入的数据格式、读取的文件是否存在、网络是否始终保持通畅等等

    二.异常
        1. 定义：
            在Java语言中，将程序执行中发生的不正常情况称为异常
        2. 分类：
            Error：(B1:demo_01)
                   Java虚拟机无法解决的严重问题。例如：JVM系统内部错误、资源耗尽等严重情况，
                   StackOverflowError 和 OutOfMemoryError。一般不编写针对性的代码进行处理
            Exception：其他因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理
                  分类：非受检异常
                       受检异常

    三.Throwable (B1:demo_02)
        1.java.lang.Throwable
            |-----java.lang.Error：一般不编写针对性的代码进行处理
            |-----java.lang.Exception:可以进行异常处理
                |-----编译时的异常（checked）受检异常
                    |-----IOException
                        |-----FileNotFoundException
                    |-----ClassNotFoundException
                |-----运行时的异常（unchecked）非受检异常
                    |-----NullPointerException
                    |-----ArrayIndexOutOfBoundsException
                    |-----ClassCastException
                    |-----NumberFormatException
                    |-----InputMismatchException
                    |-----ArithmeticException

    四.异常的处理

        在编写程序的时候，经常要在可能出现错误的地方加上检测的代码
            Java采用的异常处理机制，是将异常处理的程序代码集中在一起与正常的程序代码分开，使得程序简洁、优雅、有益于维护
            1.try-catch-finally:解决异常(B1:demo_03) 可以catch多个异常，finally可以省略
                1.1 try{ }catch(异常类型1 变量名1){处理异常的方式1}catch(异常类型2 变量名2){处理异常的方式2}finally{一定会执行的代码}
                1.2 在没有写finally的时候一旦try中的异常匹配到来某个catch，就进入catch异常处理，一旦处理完成，就跳出当前的try-catch，继续执行后面的代码
                1.3 catch中的异常类型，如果没有父子类关系，那么异常类型的排序没有影响，如果满足父子类关系，那么子类一定要排在父类的前面
                1.4 catch里 变量名.getMessage() / 变量名.printStackTrace()
                1.5 在try结构中声明的变量，在出了try以后就不能被调用了，如果需要用的话可以先定义到try结构外面
                1.6 使用try-catch-finally处理编译时异常，使得程序在编译时不再报错，但是运行时仍可能报错
                1.7 finally中声明的是一定会被执行的代码，例如try中有return、catch中也有异常也不影响finally里代码的执行
                1.8 什么时候才会写代码到finally里：需要自己关闭的物理连接(数据库连接、输入输出流、网络编程Socket)需要声明在finall
            2.throws+异常类型:上报异常(B1:demo_04)
                2.1 throws + 异常类型
                2.2 一旦方法体执行，遇到异常后就会在代码处生成对应异常类对象，此对象匹配到throws的异常类型后就会抛出异常对象。异常代码后面的代码就不再执行
                2.3 throws只是将异常抛给方法的调用者，并没有真正的将异常处理
        抓抛模型：
            1.抛：程序在执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象，并将此对象抛出，一旦抛出对象后，其后的代码就不再运行
                关于异常对象的产生：
                    ① 系统自动生成的异常对象
                    ② 手动的生成一个异常对象，并抛出（throw）
            2.抓：可以理解为异常的处理方式：① try-catch-finally ② throws
        自定义异常;
            1.继承于现有的异常结构：RuntimeException、Exception
            2.提供全局变量：serialVersionUID

线程：
    一.概述
        进程可以进一步细分为线程，是一个程序内部的一条执行路径
        >若一个进程同一时间并行执行多个线程，就是支持多线程的
        >线程作为调度和执行的单位，每个线程拥有独立的运行栈和程序计数器（pc），线程切换的开销小
        >一个进程的多个线程共享相同的内存单元/内存地址空间->他们从同一个堆中分配对象，可以访问相同的变量和对象。这使得线程间
         通信更简便、高效。但多个线程操作共享的系统资源可能会有安全隐患

    二.并行和并发：
        并行：多个cpu同时执行多个任务
        并发：一个CPU（利用时间片）同时执行多个任务，比如：秒杀、多个人做一件事

    三.多线程的优点：
        >提高应用程序的响应，对图形化界面更有意义，可以增强用户体验
        >提高计算机系统的利用率
        >改善程序结构，将既长又复杂的进程分为多个线程，独立运行，利于理解和修改

    四.创建多线程（B2：demo_01）
        >通过java.lang.Tread类来实现
        >方式一：创建一个继承Thread类的子类，然后重写run()方法,将此线程执行的操作声明在run方法中,实例化对象，通过对象调用Thread类中的start()
        >方式二：实现Runnable接口：创建实现Runnable接口的类，实现类去实现Runnable中的抽象方法run(),创建实现类的对象，
                将此对象以参数的形式传入到Thread类的构造器中，创建Thread类的对象，通过Thread类的对象调用start()--->调用了Runnable中的target类型
        >方式三：JDK 5.0新增的创建现成的方式，实现Callable接口，重写call()方法  见B2：demo_05
                相比于run():
                >可以有返回值
                >方法可以抛出异常
                >支持泛型的返回值
                >需要借助FutureTask类
                    >可以对具体Runnable、Callable任务的执行结果进行取消、查询是否完成、获取结果等
                    >FutureTask是Future接口的唯一实现类
                    >FutureTask同时实现了Runnable、Future 接口。它既可以作为Runnable被线程执行，又可以作为Future得到Callable的返回值
        >方式四：JDK 5.0使用线程池  见B2：demo_06
                >ExecutorService
                    >真正的线程池接口，常见子类ThreadPoolExecutor
                    >void execute(Runnable command): 执行任务/命令，没有返回值，一般用来执行Runnable
                    ><T>Future<T>submit(Callable<T>task): 执行任务，有返回值，一般用来执行Callable
                    >void shutdown(): 关闭常量池
                >Executors
                    >Executors.newCachedThreadPool():创建一个可以根据需要创建新线程的线程池
                    >Executors.newFixedThreadPool():创建一个可以重用的固定线程数的线程池
                    >Executors.newSingleThreadExecutor():创建只有一个线程的线程池
                    >Executors.newScheduledThreadPool(n):创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行
                >提高响应速度（减少了创建新线程的时间）
                >降低资源消耗，重复利用线程池中的线程，不需要每次都创建
                >便于线程管理
                    >corePoolSize:核心池的大小
                    >maximumPoolSize:最大线程数
                    >keepAliveTime:线程没有任务时最多保持多少时间后会终止
                    >......

        两种方法的比较：
            优先选择方法二：
            1. 实现的方式没有类的单继承局限性
            2. 实现的方式更适合来处理多个线程共享数据的情况
        两种方法的联系：
            1. thread类也是实现runnable的实现类
        Thread常用的方法：
            >start():启动当前线程，调用当前线程的run()
            >run():通常需要重写此方法，通常将线程需要执行的内容放入到此方法中
            >currentThread() 静态方法，返回执行当前代码的线程
            >getName(),setName(),获取线程名和设置线程名
            >yield()释放当前线程的执行权
            >join()结束当前进程，执行调用join()方法的进程
            >sleep(long millis)沉睡毫秒，millis内当前线程处于阻塞状态
            >stop()强制结束线程，不推荐使用
            >isalive()判断调用方法的线程是否存活

    五.Java的调度方法：
        >同优先级线程组成先进先出队列（先到先服务），使用时间片策略
        >对高优先级，使用优先调度的抢占式策略
            getPriority()获取优先级
            setPriority()设置优先级
            MAX_PRIORITY:10
            MIN_PRIORITY:1
            NORM_PRIORITY:5--->默认优先级
            优先级高只是说有很高的概率被CPU优先执行，并不意味着高优先级的执行完了才能执行低优先级

    六.线程的声明周期：
        1. 线程的几种状态
            1.1 新建：当一个Thread类或其子类的对象被声明并创建时，新生的建成处于新建状态
            1.2 就绪：处于新建状态的线程被start()后，将进入线程队列等待CPU时间片，此时它已经具备了运行的条件，只是没有被分配到资源
            1.3 运行：当就绪的线程被调度并分到CPU资源的时候，便进入了运行状态，run()方法定义了线程的操作和功能
            1.4 阻塞：在某种特殊情况下，被认为挂起或者执行输入输出操作时，让出CPU并临时中止自己执行，进入阻塞状态
            1.5 死亡：线程完成了它的全部工作或线程被提前强制性中止或出现异常导致结束

    七.线程的同步（线程的安全问题）B2：demo_02
        1. 多个线程执行的不确定性引起执行结果的不稳定；多个线程对资源的关系，会造成操作的不完整性，会破坏数据
        2. 解决方法
            2.1 当一个线程a在读取共享内存的时候，其他线程不能进来，直到线程a操作完后，其他线程才能操作共享资源，即使线程a阻塞也不能改变
                方式一：同步代码块：
                    synchronized(同步监视器(俗称：锁，任何一个类的对象都可以充当锁,但线程必须共享唯一一把锁可以考虑用this（Runnable）)){需要被同步的代码：操作共享数据（多个线程需要共同操作的数据）的代码}
                    虽然解决了同步问题，但是在同步代码块中相当于单线程，导致效率降低
                方式二：同步方法：见B2：demo_02 private synchronized void show(){}（默认的同步监视器是this）
                      静态的同步方法的同步监视器是类本身
                方式三：Lock锁 JDK5.0新增见，B2：demo_03
                      实例化ReentrantLock，try{clock.lock();.......}catch{}finally{clock.unlock()}
                      lock需要手动开启同步（lock()）和结束同步（(unlock()）
        3. 死锁
            3.1 概述
                不同的线程分别占用对方需要的资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程的死锁
                出现了死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续
            3.2 解决方法
                专门的算法、原则
                尽量减少同步资源的定义
                尽量避免嵌套同步

    八. 线程的通信 B2：demo_04
        1. wait():一旦执行此方法，当前线程就会进入阻塞态，并释放同步监视器
        2. notify():一旦执行此方法，就会唤醒被wait的线程，如果存在多个被wait的线程，优先唤醒优先级最高的线程
        3. notifyAll():一旦执行此方法，就会唤醒所有被wait的线程
        以上三种方法只能在同步代码块和同步方法中使用，方法的调用者，必须是同步代码块或同步方法的同步监视器，否者会出现IllegalMonitorStateException的异常
        这三种方法定义在java.lang.Object类中

常用类：
    一. String、StringBuffer & StringBuilder B2_demo_07
        1.String：
            1.1 String：底层是final char value[]， 所以String创建以后有不可变性，不可变的字符序列
                1.1.1 当对字符串重新赋值时，需要重写指定内存区域赋值，不能在原有的value上进行赋值
                1.1.2 当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
                1.1.3 当调用replace()方法的时候也需要重新指定内存区域赋值，不能使用原有的value进行赋值
            1.2 String类是final的，不可被继承
            1.3 String实现了Serializable接口：表示字符串是支持序列化的
            1.4 String实现了Comparable接口：表示String可以比较大小
            1.5 通过自变量的方式给一个字符串赋值，此时的字符串保存在常量池中，字符串内不会存相同内容的字符串
            1.6 常用方法
                 int length()：返回字符串的长度： return value.length
                 char charAt(int index)： 返回某索引处的字符return value[index]
                 boolean isEmpty()：判断是否是空字符串：return value.length == 0
                 String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
                 String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
                 String trim()：返回字符串的副本，忽略前导空白和尾部空白
                 boolean equals(Object obj)：比较字符串的内容是否相同
                 boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
                 String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
                 int compareTo(String anotherString)：比较两个字符串的大小
                 String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
                 String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
                 boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
                 boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
                 boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始
                 boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
                 int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
                 int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
                 int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
                 int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
                    注：indexOf和lastIndexOf方法如果未找到都是返回-1
                String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
                 String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
                 String replaceAll(String regex, String replacement)：使用给定的replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
                 String replaceFirst(String regex, String replacement)：使用给定的replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
        2.StringBuffer & StringBuilder B2：demo_08
            2.1 StringBuffer：可变的字符序列，线程安全的，效率低，底层使用char[]存储
                2.1.1 常用方法：
                    StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
                    StringBuffer delete(int start,int end)：删除指定位置的内容
                    StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
                    StringBuffer insert(int offset, xxx)：在指定位置插入xxx
                    StringBuffer reverse() ：把当前字符序列逆转
                    public int indexOf(String str)
                    public String substring(int start,int end)
                    public int length()
                    public char charAt(int n )
                    public void setCharAt(int n ,char ch)
            2.2 StringBuilder：可变的字符序列，JDK 5.0 新增，线程不安全的，效率高，底层使用char[]存储

    二. System 静态方法、Date类、Calender类、SimpleDateFormat类  B2：demo_09
            1. java.lang.System:
                1.1 public static long currentTimeMillis()用来返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
            2. java.util.Date 类
                1.常用方法
                     getTime():返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
                     toString():把此 Date 对象转换为以下形式的 String： dow mon dd:hh:mm:ss zzz yyyy 其中： dow 是一周中的某一天 (Sun, Mon, Tue, Wed, Thu, Fri, Sat)，zzz是时间标准。
            3.SimpleDateFormat类
                3.1  Date类的API不易于国际化，大部分被废弃了，java.text.SimpleDateFormat类是一个不与语言环境有关的方式来格式化和解析日期的具体类。
                     它允许进行格式化：日期文本、解析：文本日期
                3.2 格式化：
                     SimpleDateFormat() ：默认的模式和语言环境创建对象
                     public SimpleDateFormat(String pattern)：该构造方法可以用参数pattern，指定的格式创建一个对象，该对象调用：
                     public String format(Date date)：方法格式化时间对象date
                    解析：
                     public Date parse(String source)：从给定字符串的开始解析文本，以生成一个日期。
             4. java.util.Calendar(日历)类
                    4.1 Calendar是一个抽象基类，主用用于完成日期字段之间相互操作的功能。
                        获取Calendar实例的方法
                         使用Calendar.getInstance()方法
                         调用它的子类GregorianCalendar的构造器。
                    4.2 一个Calendar的实例是系统时间的抽象表示，通过get(int field)方法来取得想要的时间信息。比如YEAR、MONTH、DAY_OF_WEEK、HOUR_OF_DAY 、MINUTE、SECOND
                         public void set(int field,int value)
                         public void add(int field,int amount)
                         public final Date getTime()
                         public final void setTime(Date date)
                        注意:
                         获取月份时：一月是0，二月是1，以此类推，12月是11
                         获取星期时：周日是1，周二是2 ， 。。。。周六是7

    三. LocalDate、LocalTime、LocalDateTime（JDK 8）
    四. Instant、DateTimeFormatter、其他类（JDK 8）
    五. Java比较器{Comparable接口、Comparator接口} B2:demo_10
            1. Comparable接口:自然排序
                1.1 类似于String，继承了Comparable接口，重写了comparableTo()方法
            2. Comparator接口:定制排序
                2.1 继承了Comparator接口，重写了compare(object1,object2)方法
    六. System类
    七. Math类
    八. BigInteger & BigDecimal

枚举类 & 注解
    1. 枚举类：B2: demo_11
        1.1 类的对象只有有限个，确定的。当需要定义一组常量时，强烈建议使用枚举类
        1.2 枚举类的定义
            1.2.1 方法一：jdk 5.0 以前，自定义枚举类
                >声明对象的属性：private final修饰
                >私有化类的构造器
                >提供当前枚举类的多个对象
            1.2.2 方法二：jdk 5.0 以后，使用enum关键字定义枚举类
                >继承于java.lang.Enum类
                >常用方法
                    values():返回枚举类类型的对象数组，该方法可以很方便的遍历所有的枚举类
                    valueOf(String str):可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”
                    toString():返回当前枚举类对象常量的名称
                >使用enum关键字的枚举类实现接口的情况
                    情况一：实现接口，在enum类中重写接口的抽象方法
                    情况二：实现接口，每一个枚举类对象都可以重写抽象方法
    2. 注解（Annotation）：一定程度上可以说：框架 = 注解 + 反射 + 设计模式。B2: demo_12
        >从 JDK 5.0 开始, Java 增加了对元数据(MetaData) 的支持, 也就是Annotation(注解)
        >Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。通过使用 Annotation, 程序员
         可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。代码分析工具、开发工具和部署工具可以通过这些补充信息进行验证或者进行部署。
        >Annotation 可以像修饰符一样被使用, 可用于修饰包,类, 构造器, 方法, 成员变量, 参数, 局部变量的声明, 这些信息被保存在 Annotation 的 “name=value” 对中。
            @author 标明开发该类模块的作者，多个作者之间使用,分割
            @version 标明该类模块的版本
            @see 参考转向，也就是相关主题
            @since 从哪个版本开始增加的
            @param 对方法中某参数的说明，如果没有参数就不能写
            @return 对方法返回值的说明，如果方法的返回值类型是void就不能写
            @exception 对方法可能抛出的异常进行说明 ，如果方法没有用throws显式抛出的异常就不能写
            @Override: 限定重写父类方法, 该注解只能用于方法
            @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
            @SuppressWarnings: 抑制编译器警告
            JDK5.0提供了4个标准的meta-annotation类型，分别是：
            Retention:指定注解的生命周期，SOURCE/CLASS（默认）/RUNTIME（运行时会被加载到内存中）
            Target:指定注解可以修饰那些元素，
            Documented:
            Inherited
        自定义：定义新的 Annotation 类型使用 @interface 关键字
                public @interface annotation(){}
                 自定义注解自动继承了java.lang.annotation.Annotation接口
                 Annotation 的成员变量在 Annotation 定义中以无参数方法的形式来声明。其
                方法名和返回值定义了该成员的名字和类型。我们称为配置参数。类型只能
                是八种基本数据类型、String类型、Class类型、enum类型、Annotation类型、
                以上所有类型的数组。
                 可以在定义 Annotation 的成员变量时为其指定初始值, 指定成员变量的初始
                值可使用 default 关键字
                 如果只有一个参数成员，建议使用参数名为value
                 如果定义的注解含有配置参数，那么使用时必须指定参数值，除非它有默认值。格式是“参数名 = 参数值”
                ，如果只有一个参数成员，且名称为value，以省略“value=”
                 没有成员定义的 Annotation 称为标记; 包含成员变量的 Annotation 称为元数据 Annotation
                注意：自定义注解必须配上注解的信息处理流程才有意义。

集合： B3：demo_01
    1. 概述
        集合、数组都是对多个数据进行存储的结构，简称Java容器
        说明：此时的存储指的是内存层面的存储，不涉及到持久化的存储（.txt, .jpg, .avi, 数据库中）
        集合的长度可以进行修改
    2. 分类
        Java 集合可分为 Collection 和 Map 两种体系
        Collection接口：单列数据，定义了存取一组对象的方法的集合
            List：元素有序、可重复的集合---->动态数组
                |----ArrayList、LinkedList、Vector
            Set：元素无序、不可重复的集合---->集合
                |----HashSet、LinkedHashSet、TreeSet
         Map接口：（映射）双列数据，保存具有映射关系“key-value对”的集合
                |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
                Hashtable:作为Map古老的实现类
                    |----Properties:
                HashMap:作为Map主要的实现类
                    |----LinkedHashMap:
    3.Collection:
            3.1 add("AA"); 添加元素
                size(); 返回元素个数
                collection1.addAll(collection); 将collection的元素全部加到collection1中
                clear() 清空元素
                isEmpty() 判断里面有没有元素
                contains(Object obj) 判断集合内是否有obj对象,在调用的时候会调用obj所在类的equals()方法
                containsAll(Collection coll)判断coll中的所有元素是否都在当前的集合中
                remove(Object obj) 删除集合中的元素obj
                removeAll(collection) （差集）删除当前集合中所有collection里的元素
                retainAll(collection) 交集
                HashCode() 返回当前对象的哈希值
                toArray() 集合---->数组
                Arrays.asList(new String[] {"AA","BB"} 数组---->集合
                iterator(): 返回Iterator 对象，用于遍历遍历集合元素
                jdk 5.0 新增foreach循环用于遍历集合、数组 for(集合元素的类型 局部变量 : 集合对象)(内部仍然调用迭代器)
                    迭代器
                    hasNext()
                    next()
                    remove() 移除
                     Iterator对象称为迭代器(设计模式的一种)，主要用于遍历 Collection 集合中的元素。
                     GOF给迭代器模式的定义为：提供一种方法访问一个容器(container)对象中各个元素，而
                    又不需暴露该对象的内部细节。迭代器模式，就是为容器而生。类似于“公交车上的售票员”、“火车上的乘务员”、“空姐”。
                     Collection接口继承了java.lang.Iterable接口，该接口有一个iterator()方法，那么所
                    有实现了Collection接口的集合类都有一个iterator()方法，用以返回一个实现了Iterator接口的对象。
                     Iterator 仅用于遍历集合，Iterator 本身并不提供承装对象的能力。如果需要创建Iterator 对象，则必须有一个被迭代的集合。
                     集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
        3.2 List接口B3：demo_02
             鉴于Java中数组用来存储数据的局限性，我们通常使用List替代数组
             List集合类中元素有序、且可重复，集合中的每个元素都有其对应的顺序索引。
             List容器中的元素都对应一个整数型的序号记载其在容器中的位置，可以根据序号存取容器中的元素。
            共同点：都是元素有序、可重复的集合
            list常用方法：
            void add(int index, Object ele):在index位置插入ele元素
            boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
            Object get(int index):获取指定index位置的元素
            int indexOf(Object obj):返回obj在集合中首次出现的位置
            int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
            Object remove(int index):移除指定index位置的元素，并返回此元素
            Object set(int index, Object ele):设置指定index位置的元素为ele
            List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
            3.2.1 ArrayList（1.2版本）
                作为List接口的主要实现类，线程不安全，效率高，底层使用Object[] elementData存储，频繁的读取数据的时候效率更高
                初始时长度为10，扩容时扩容到原来的1.5倍
                建议开发中使用带参的构造器避免扩容来提高效率
            3.2.2 LinkedList（1.2版本）
                底层使用的是双向链表，对于频繁的增删操作的时候，使用LinkedList的效率更高
                     void addFirst(Object obj)
                     void addLast(Object obj)
                     Object getFirst()
                     Object getLast()
                     Object removeFirst()
                     Object removeLast()

            3.2.3 Vector（1.0版本）
                线程安全，效率较低，底层使用Object[] elementData存储
                     void addElement(Object obj)
                     void insertElementAt(Object obj,int index)
                     void setElementAt(Object obj,int index)
                     void removeElement(Object obj)
                     void removeAllElements()
        3.3 set接口
                 Set接口是Collection的子接口，set接口没有提供额外的方法
                 Set 集合不允许包含相同的元素，如果试把两个相同的元素加入同一个Set 集合中，则添加操作失败。
                 Set 判断两个对象是否相同不是使用 == 运算符，而是根据 equals() 方法
                 无序：（不代表是随机性）存储的数据在底层数组中并非按照数组索引的顺序天剑，而是根据数据的hash值决定的
                 不可重复性：保证添加的元素按照equals方法判断时，不能返回true，即相同的元素只能添加一个
                 添加元素的过程，以HashSet为例
                    1. 调用元素a所在类的hashcode()方法，计算a的哈希值，此哈希值通过某种算法算出a在HashSet底层数组的存放位置
                    2. 判断此位置上是否已经有元素，如果此位置上没有其他元素，则元素添加成功，如果有其他元素b（或者已经存在链表形式的多个数组）
                    3. 若已经存在元素，则比较元素之间的哈希值不相同，则添加成功，如果hash值相同，则调用元素a所在类的equals()方法，判断两个元素是否相同
                ！！！向Set中添加的元素一定要重写hashCode()方法和equals()方法，并且尽可能的保留一致性，即相等的对象一定要有相同的散列码
                 选择系数的时候要选择尽量大的系数。因为如果计算出来的hash地址越大，所谓的“冲突”就越少，查找起来效率也会提高。（减少冲突）
                 并且31只占用5bits,相乘造成数据溢出的概率较小。
                 31可以 由i*31== (i<<5)-1来表示,现在很多虚拟机里面都有做相关优化。（提高算法效率）
                 31是一个素数，素数作用就是如果我用一个数字来乘以这个素数，那么最终出来的结果只能被素数本身和被乘数还有1来整除！(减少冲突
                3.3.1 HashSet
                底层也是数组，初始容量为16，当如果使用率超过0.75，（16*0.75=12）就会扩大容量为原来的2倍。（16扩容为32，依次为64,128....等）
                HashSet 是 Set 接口的典型实现，大多数时候使用 Set 集合时都使用这个实现类。
                HashSet 按 Hash 算法来存储集合中的元素，因此具有很好的存取、查找、删除性能。
                HashSet 具有以下特点：
                    不能保证元素的排列顺序
                    HashSet 不是线程安全的
                    集合元素可以是 null
                HashSet 集合判断两个元素相等的标准：两个对象通过 hashCode() 方法比较相等，并且两个对象的 equals() 方法返回值也相等。
                对于存放在Set容器中的对象，对应的类一定要重写equals()和hashCode(Object obj)方法，以实现对象相等规则。即：“相等的对象必须具有相等的散列码”。
            3.3.2 LinkedHashSet
                LinkedHashSet 是 HashSet 的子类
                LinkedHashSet 根据元素的 hashCode 值来决定元素的存储位置，但它同时使用双向链表维护元素的次序，这使得元素看起来是以插入顺序保存的。
                LinkedHashSet插入性能略低于 HashSet，但在迭代访问 Set 里的全部元素时有很好的性能。
                LinkedHashSet 不允许集合元素重复。
            3.3.3 TreeSet
            Set实现类之三：TreeSet(只能添加同类的元素)
                TreeSet 是 SortedSet 接口的实现类，TreeSet 可以确保集合元素处于排序状态。
                TreeSet底层使用红黑树结构存储数据
                 新增的方法如下： (了解)
                Comparator comparator()
                Object first()
                Object last()
                Object lower(Object e)
                Object higher(Object e)
                SortedSet subSet(fromElement, toElement)
                SortedSet headSet(toElement)
                SortedSet tailSet(fromElement)
                TreeSet 两种排序方法：自然排序和定制排序。默认情况下，TreeSet 采用自然排序。
                    自然排序：
                        自然排序中我们比较两个元素是否相同的标准为：compareTo()返回0
                    定制排序：
                        定制排序中我们比较两个元素是否相同的标准为：comparator()返回0

    4. Map
        4.1 Map结构
        Map 中的 key 用Set来存放（KeySet），不允许重复，即同一个 Map 对象所对应的类，须重写hashCode()和equals()方法
        value是用Collection存的，允许重复，无序的，value所在的类要重写equals()方法
        添加key-value的时候用的是Entry(k,v),无序的不可重复的（set）
        常用String类作为Map的“键”
        4.2 Map分类
        CurrentHashMap:
        Hashtable:作为Map古老的实现类，线程安全，效率低，不可以存储null 的key和value
            |----Properties:用来处理配置文件，key和value都是String类型
        HashMap:作为Map主要的实现类，线程不安全，效率高，可以存储null 的key和value
            |----LinkedHashMap: 保证在遍历map元素的时候，可以按照添加的顺序实现遍历，原因是在原有的HashMap的基础上，添加了两个指针，指向前一个和后一个元素
            自然排序：TreeMap 的所有的 Key 必须实现 Comparable 接口，而且所有的 Key 应该是同一个类的对象，否则将会抛出 ClasssCastException
            定制排序：创建 TreeMap 时，传入一个 Comparator 对象，该对象负责对TreeMap 中的所有 key 进行排序。此时不需要 Map 的 Key 实现Comparable 接口
        TreeMap:保证按照添加的key-value对进行排序（key），实现排序遍历，允许定制排序，底层使用的是红黑树

        4.3 Map接口常用方法：
         添加、删除、修改操作：
         Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
         void putAll(Map m):将m中的所有key-value对存放到当前map中
         Object remove(Object key)：移除指定key的key-value对，并返回value
         void clear()：清空当前map中的所有数据
         元素查询的操作：
         Object get(Object key)：获取指定key对应的value
         boolean containsKey(Object key)：是否包含指定的key
         boolean containsValue(Object value)：是否包含指定的value
         int size()：返回map中key-value对的个数
         boolean isEmpty()：判断当前map是否为空
         boolean equals(Object obj)：判断当前map和参数对象obj是否相等
         元视图操作的方法：
         Set keySet()：返回所有key构成的Set集合
         Collection values()：返回所有value构成的Collection集合
         Set entrySet()：返回所有key-value对构成的Set集合

        4.4 HashMap的底层实现原理，以JDK 7为例
            HashMap map = new HashMap();
            在实例化后，底层创建了长度是16（默认扩容为原来的二倍）的一维数组Entry[] table
            ...可能已经执行了很多次put()...
            map.put(key1,value1);
            首先调用key1所在类的HashCode()方法，计算key1的哈希值，通过某种算法后得到key1在Entry[]中的存放位置
                如果该位置上数据为空，则添加成功
                如果该位置上已经有元素（存在一个或多个元素(链表)）
                    如果key1的哈希值和已经存在的元素中的某一个元素的哈希值相同
                        调用key1所在类的equals()方法比较，如果equals()返回的false，则添加成功
                        调用key1所在类的equals()方法比较，如果equals()返回的ture，则添加失败
                    如果key1的哈希值和已经存在的元素中的任何一个元素的哈希值都不相同，则添加成功
            JDK 8
            1. new HashMap():底层没有创建一个长度为16的数组
            2. JDK 8底层的数组是：Node[],而非Entry[]
            3. 首次调用put()方法时，底层创建长度为16的数组
            4. JDK 7 底层结构只有数组+链表，JDK 8 底层结构：数组+链表+红黑树（当数组的某一个索引位置上的链表存储的元素>8 且当前数组长度>64时
               此时索引位置上的所有数据改为使用红黑树存储）
                DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
                MAXIMUM_CAPACITY ： HashMap的最大支持容量，2^30
                DEFAULT_LOAD_FACTOR：HashMap的默认加载因子
                TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树
                UNTREEIFY_THRESHOLD：Bucket中红黑树存储的Node小于该默认值，转化为链表
                MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量。（当桶中Node的
                数量大到需要变红黑树时，若hash表容量小于MIN_TREEIFY_CAPACITY时，此时应执行
                resize扩容操作这个MIN_TREEIFY_CAPACITY的值至少是TREEIFY_THRESHOLD的4
                倍。）
                table：存储元素的数组，总是2的n次幂
                entrySet：存储具体元素的集
                size：HashMap中存储的键值对的数量
                modCount：HashMap扩容和结构改变的次数。
                threshold：扩容的临界值，=容量*填充因子
                loadFactor：填充因子
        4.5 Properties
            4.5.1 Properties 类是 Hashtable 的子类，该对象用于处理属性文件
                  由于属性文件里的 key、value 都是字符串类型，所以 Properties 里的 key 和 value 都是字符串类型
                  存取数据时，建议使用setProperty(String key,String value)方法和getProperty(String key)方法
        4.6 collections工具类
        Collections 是一个操作 Set、List 和 Map 等集合的工具类
        Collections 中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作，还提供了对集合对象设置不可变、对集合对象实现同步控制等方法
        排序操作：（均为static方法）
        reverse(List)：反转 List 中元素的顺序
        shuffle(List)：对 List 集合元素进行随机排序
        sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
        sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
        swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
        查找、替换
        Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
        Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
        Object min(Collection)
        Object min(Collection，Comparator)
        int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
        void copy(List dest,List src)：将src中的内容复制到dest中 dest.size>=src.size: List dest = Array.asList(new Object[list,size])
        boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值
        同步控制:
        Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题

泛型：B3：demo_04
    1. 定义
         所谓泛型，就是允许在定义类、接口时通过一个标识表示类中某个属性的类型或者是某个方法的返回值及参数类型。这个类型参数将在使用时（例如，
        继承或实现这个接口，用这个类型声明变量、创建对象时）确定（即传入实际的类型参数，也称为类型实参）。
         从JDK1.5以后，Java引入了“参数化类型（Parameterized type）”的概念，允许我们在创建集合时再指定集合元素的类型，正如：List<String>，这表明
        该List只能保存字符串类型的对象。
         JDK1.5改写了集合框架中的全部接口和类，为这些接口、类增加了泛型支持，从而可以在声明集合变量、创建集合对象时传入类型实参。
        Java泛型可以保证如果程序在编译时没有发出警告，运行时就不会产生ClassCastException异常。同时，代码更加简洁、健壮。
    2. 使用
        ArrayList<Integer> list = new ArrayList<>();  //进行类型检查
    3. 自定义泛型
        1.泛型的声明
            interface List<T> 和 class GenTest<K,V>
            其中，T,K,V不代表值，而是表示类型。这里使用任意字母都可以。常用T表示，是Type的缩写。
        2.泛型的实例化：
            一定要在类名后面指定类型参数的值（类型）。如：
            List<String> strList = new ArrayList<String>();
            Iterator<Customer> iterator = customers.iterator();
             方法，也可以被泛型化，不管此时定义在其中的类是不是泛型类。在泛型方法中可以定义泛型参数，此时，参数的类型就是传入数据的类型。
             泛型方法的格式：
            [访问权限] <泛型> 返回类型 方法名([泛型标识 参数名称]) 抛出的异常

             T只能是类，不能用基本数据类型填充。但可以使用包装类填充
             把一个集合中的内容限制为一个特定的数据类型，这就是generics背后的核心思想
            1. 泛型类可能有多个参数，此时应将多个参数一起放在尖括号内。比如：<E1,E2,E3>
            2. 泛型类的构造器如下：public GenericClass(){}。而下面是错误的：public GenericClass<E>(){}
            3. 实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致。
            4. 泛型不同的引用不能相互赋值。
                >尽管在编译时ArrayList<String>和ArrayList<Integer>是两种类型，但是，在运行时只有一个ArrayList被加载到JVM中。
            5. 泛型如果不指定，将被擦除，泛型对应的类型均按照Object处理，但不等价于Object。经验：泛型要使用一路都用。要不用，一路都不要用。
            6. 如果泛型结构是一个接口或抽象类，则不可创建泛型类的对象。
            7. jdk1.7，泛型的简化操作：ArrayList<Fruit> flist = new ArrayList<>();
            8. 泛型的指定中不能使用基本数据类型，可以使用包装类替换。
            9. 在类/接口上声明的泛型，在本类或本接口中即代表某种类型，可以作为非静态属性的类型、非静态方法的参数类型、非静态方法的返回值类型。但在静态方法
               中不能使用类的泛型。
            10. 异常类不能是泛型的
            11. 不能使用new E[]。但是可以：E[] elements = (E[])new Object[capacity];
            参考：ArrayList源码中声明：Object[] elementData，而非泛型参数类型数组。
            12.父类有泛型，子类可以选择保留泛型也可以选择指定泛型类型：
                 子类不保留父类的泛型：按需实现
                 没有类型 擦除
                 具体类型
                 子类保留父类的泛型：泛型子类
                 全部保留
                 部分保留
            结论：子类必须是“富二代”，子类除了指定或保留父类的泛型，还可以增加自
            己的泛型
    3. 继承上的体现
        如果B是A的一个子类型（子类或者子接口），而G是具有泛型声明的类或接口，G<B>并不是G<A>的子类型！
        比如：String是Object的子类，但是List<String >并不是List<Object>的子类。

    4. 通配符
        4.1 定义
            1.使用类型通配符：？比如：List<?> ，Map<?,?>List<?>是List<String>、List<Object>等各种泛型List的父类。
            2.读取List<?>的对象list中的元素时，永远是安全的，因为不管list的真实类型是什么，它包含的都是Object。
            3.写入list中的元素时，不行。因为我们不知道c的元素类型，我们不能向其中添加对象。
                 唯一的例外是null，它是所有类型的成员。
        4.2 使用
             将任意元素加入到其中不是类型安全的：Collection<?> c = new ArrayList<String>();
            c.add(new Object()); // 编译时错误
            因为我们不知道c的元素类型，我们不能向其中添加对象。add方法有类型参数E作为集合的元素类型。我们传给add的任何参数都必须是一个未知类型的子类。因为我们不知
            道那是什么类型，所以我们无法传任何东西进去。
             唯一的例外的是null，它是所有类型的成员。
             另一方面，我们可以调用get()方法并使用其返回值。返回值是一个未知的类型，但是我们知道，它总是一个Object。
            注意点
            注意点1：编译错误：不能用在泛型方法声明上，返回值类型前面<>不能使用?
            public static <?> void test(ArrayList<?> list){}
            注意点2：编译错误：不能用在泛型类的声明上
            class GenericTypeClass<?>{}
            注意点3：编译错误：不能用在创建对象上，右边属于创建集合对象
            ArrayList<?> list2 = new ArrayList<?>();
       4.3 有限制的通配符
         <?>允许所有泛型的引用调用
         通配符指定上限：上限extends：使用时指定的类型必须是继承某个类，或者实现某个接口，即<=
         通配符指定下限：下限super：使用时指定的类型不能小于操作的类，即>=
         举例：
             <? extends Number> (无穷小 , Number]只允许泛型为Number及Number子类的引用调用
             <? super Number> [Number , 无穷大)只允许泛型为Number及Number父类的引用调用
             <? extends Comparable>只允许泛型为实现Comparable接口的实现类的引用调用

IO流：
    1. file B4:demo_01
        1.1 file类的使用：
            1.1.1 File类的一个对象，代表一个对象或一个文件目录(俗称：文件夹)
            1.1.2 File类声明在java.io包下
            1.1.3 常用的构造器
                 public File(String pathname)以pathname为路径创建File对象，可以是绝对路径或者相对路径，如果
                  pathname是相对路径，则默认的当前路径在系统属性user.dir中存储。
                 绝对路径：是一个固定的路径,从盘符开始
                 相对路径：是相对于某个位置开始
                 public File(String parent,String child)以parent为父路径，child为子路径创建File对象。
                 public File(File parent,String child)根据一个父File对象和子文件路径创建File对象
                 路径中的每级目录之间用一个路径分隔符隔开。
                 路径分隔符和系统有关：
                 windows和DOS系统默认使用“\”来表示
                 UNIX和URL使用“/”来表示
                 Java程序支持跨平台运行，因此路径分隔符要慎用。
                 为了解决这个隐患，File类提供了一个常量：public static final String separator。根据操作系统，动态的提供分隔符。
            1.1.4 常用方法
                File类的获取功能
                 public String getAbsolutePath()：获取绝对路径
                 public String getPath() ：获取路径
                 public String getName() ：获取名称
                 public String getParent()：获取上层文件目录路径。若无，返回null
                 public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
                 public long lastModified() ：获取最后一次的修改时间，毫秒值
                如下两个方法适用于文件目录
                 public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
                 public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
                 File类的重命名功能
                需要当前文件存在且dest不能存在
                 public boolean renameTo(File dest):把文件重命名为指定的文件路径
                 File类的判断功能
                 public boolean isDirectory()：判断是否是文件目录
                 public boolean isFile() ：判断是否是文件
                 public boolean exists() ：判断是否存在
                 public boolean canRead() ：判断是否可读
                 public boolean canWrite() ：判断是否可写
                 public boolean isHidden() ：判断是否隐藏
                 File类的创建功能
                 public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
                 public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。
                如果此文件目录的上层目录不存在，也不创建。
                 public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
                注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下。
                 File类的删除功能
                 public boolean delete()：删除文件或者文件夹
                删除注意事项：
                Java中的删除不走回收站。
                要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
    2. IO流原理 B4_demo_02
         I/O是Input/Output的缩写， I/O技术是非常实用的技术，用于处理设备之间的数据传输。如读/写文件，网络通讯等。
         Java程序中，对于数据的输入/输出操作以“流(stream)” 的方式进行。
         java.io包下提供了各种“流”类和接口，用以获取不同种类的数据，并通过标准的方法输入或输出数据。
        输入input：读取外部数据（磁盘、光盘等存储设备的数据）到程序（内存）中。
        输出output：将程序（内存）数据输出到磁盘、光盘等存储备中。
    3. 分类
        按操作数据单位不同分为：字节流(8 bit)，字符流(16 bit)
              (抽象基类) 字节流(图片，视频，音频)     字符流(文本)
            > 输入流     InputStream              Reader
            > 输出流     OutputStream             Writer
        按数据流的流向不同分为：输入流，输出流
        按流的角色的不同分为：节点流，处理流
            > 节点流：直接从数据源或目的地读写数据
            > 处理流：不直接连接到数据源或目的地，而是“连接”在已存在的流（节点流或处理流）之上，通过对数据的处理为程序提
                     供更为强大的读写功能。
            > 转换流(字符流)：utf-8。txt--->字节流转化为字符流--->程序--->字符流转化为字节流--->gbk.txt
                InputStreamReader:将字节流转化为字符流
                OutputStreamReader:将字符流转化为字节流
                解码:字节、字节数组---->字符串，字符数组
                编码:字节、字节数组<----字符串，字符数组
                字符集:
                     编码表的由来
                    计算机只能识别二进制数据，早期由来是电信号。为了方便应用计算机，让它可以识
                    别各个国家的文字。就将各个国家的文字用数字来表示，并一一对应，形成一张表。
                    这就是编码表。
                     常见的编码表
                     ASCII：美国标准信息交换码。
                     用一个字节的7位可以表示。
                     ISO8859-1：拉丁码表。欧洲码表
                     用一个字节的8位表示。
                     GB2312：中国的中文编码表。最多两个字节编码所有字符
                     GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
                     Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
                     UTF-8：变长的编码方式，可用1-4个字节来表示一个字符。

            > 标准输入输出流：B4：demo_03
                System.in:键盘输入 属于InputStream
                System.out:控制台输出 是PrintStream，其是OutputStream的子类
                重定向：通过System类的setIn，setOut方法对默认设备进行改变。
                 public static void setIn(InputStream in)
                 public static void setOut(PrintStream out)

            > 打印流
                实现将基本数据类型的数据格式转化为字符串输出
                打印流：PrintStream和PrintWriter
                     提供了一系列重载的print()和println()方法，用于多种数据类型的输出
                     PrintStream和PrintWriter的输出不会抛出IOException异常
                     PrintStream和PrintWriter有自动flush功能
                     PrintStream 打印的所有字符都使用平台的默认字符编码转换为字节。
                    在需要写入字符而不是写入字节的情况下，应该使用 PrintWriter 类。
                     System.out返回的是PrintStream的实例

            > 数据流
                 为了方便地操作Java语言的基本数据类型和String的数据，可以使用数据流。
                 数据流有两个类：(用于读取和写出基本数据类型、String类的数据）
                     DataInputStream 和 DataOutputStream
                     分别“套接”在 InputStream 和 OutputStream 子类的流上
                 DataInputStream中的方法
                     boolean readBoolean() byte readByte()
                     char readChar() float readFloat()
                     double readDouble() short readShort()
                     long readLong() int readInt()
                     String readUTF() void readFully(byte[] b)
                 DataOutputStream中的方法
                     将上述的方法的read改为相应的write即可。

            > 对象流 B4:demo_04
                 ObjectInputStream和OjbectOutputSteam
                     用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
                 序列化：用ObjectOutputStream类保存基本类型数据或对象的机制
                 反序列化：用ObjectInputStream类读取基本类型数据或对象的机制
                 ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
                >对象序列化
                对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传
                输到另一个网络节点。//当其它程序获取了这种二进制流，就可以恢复成原来的Java对象
                序列化的好处在于可将任何实现了Serializable接口的对象转化为字节数据，使其在保存和传输时可被还原
                序列化是 RMI（Remote Method Invoke – 远程方法调用）过程的参数和返回值都必须实现的机制，而 RMI 是 JavaEE 的基础。因此序列化机制是
                JavaEE 平台的基础
                如果需要让某个对象支持序列化机制，则必须让对象所属的类及其属性是可序列化的，为了让某个类是可序列化的，该类必须实现如下两个接口之一。
                否则，会抛出NotSerializableException异常
                    Serializable
                    Externalizable
                凡是实现Serializable接口的类都有一个表示序列化版本标识符的静态变量：
                    private static final long serialVersionUID;
                    同时也要保证其内部所有属性也必须是可序列化的（默认情况下，基本数据类型是可序列化的,static和transient修饰的成员变量不可序列化）
                    serialVersionUID用来表明类的不同版本间的兼容性。简言之，其目的是以序列化对象进行版本控制，有关各版本反序列化时是否兼容。
                如果类没有显示定义这个静态常量，它的值是Java运行时环境根据类的内部细节自
                动生成的。若类的实例变量做了修改，serialVersionUID 可能发生变化。故建议，
                显式声明。
                 简单来说，Java的序列化机制是通过在运行时判断类的serialVersionUID来验
                证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的
                serialVersionUID与本地相应实体类的serialVersionUID进行比较，如果相同
                就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异
                常。(InvalidCastException)
                若某个类实现了 Serializable 接口，该类的对象就是可序列化的：
                    创建一个 ObjectOutputStream
                    调用 ObjectOutputStream 对象的 writeObject(对象) 方法输出可序列化对象
                    注意写出一次，操作flush()一次
                反序列化
                    创建一个 ObjectInputStream
                    调用 readObject() 方法读取流中的对象
                强调：如果某个类的属性不是基本数据类型或 String 类型，而是另一个
                引用类型，那么这个引用类型必须是可序列化的，否则拥有该类型的
                Field 的类也不能序列化

        >随机存取文件流（RandomAccessFile）B4:demo_05
            RandomAccessFile 声明在java.io包下，但直接继承于java.lang.Object类。并
            且它实现了DataInput、DataOutput这两个接口，也就意味着这个类既可以读也可以写。
            RandomAccessFile 类支持 “随机访问” 的方式，程序可以直接跳到文件的任意地方来读、写文件
                支持只访问文件的部分内容
                可以向已存在的文件后追加内容
            RandomAccessFile 对象包含一个记录指针，用以标示当前读写处的位置。
            RandomAccessFile 类对象可以自由移动记录指针：
            long getFilePointer()：获取文件记录指针的当前位置
            void seek(long pos)：将文件记录指针定位到 pos 位置
            构造器
                public RandomAccessFile(File file, String mode)
                public RandomAccessFile(String name, String mode)
            创建 RandomAccessFile 类实例需要指定一个 mode 参数，该参数指定 RandomAccessFile 的访问模式：
                r: 以只读方式打开
                rw：打开以便读取和写入
                rwd:打开以便读取和写入；同步文件内容的更新
                rws:打开以便读取和写入；同步文件内容和元数据的更新
             如果模式为只读r。则不会创建文件，而是会去读取一个已经存在的文件，
            如果读取的文件不存在则会出现异常。 如果模式为rw读写。如果文件不
            存在则会去创建文件，如果存在则不会创建。

        >JAVA.NIO
         Java NIO (New IO，Non-Blocking IO)是从Java 1.4版本开始引入的一套新
        的IO API，可以替代标准的Java IO API。NIO与原来的IO有同样的作用和目
        的，但是使用的方式完全不同，NIO支持面向缓冲区的(IO是面向流的)、基于
        通道的IO操作。NIO将以更加高效的方式进行文件的读写操作。
         Java API中提供了两套NIO，一套是针对标准输入输出NIO，另一套就是网
        络编程NIO。
            |-----java.nio.channels.Channel
            |-----FileChannel:处理本地文件
            |-----SocketChannel：TCP网络编程的客户端的Channel
            |-----ServerSocketChannel:TCP网络编程的服务器端的Channel
            |-----DatagramChannel：UDP网络编程中发送端和接收端的Channel
         早期的Java只提供了一个File类来访问文件系统，但File类的功能比较有限，所
        提供的方法性能也不高。而且，大多数方法在出错时仅返回失败，并不会提供异常信息。
         NIO. 2为了弥补这种不足，引入了Path接口，代表一个平台无关的平台路径，描
        述了目录结构中文件的位置。Path可以看成是File类的升级版本，实际引用的资
        源也可以不存在。
         在以前IO操作都是这样写的:
            import java.io.File;
            File file = new File("index.html");
         但在Java7 中，我们可以这样写：
            import java.nio.file.Path;
            import java.nio.file.Paths;
            Path path = Paths.get("index.html");
         同时，NIO.2在java.nio.file包下还提供了Files、Paths工具类，Files包含
        了大量静态的工具方法来操作文件；Paths则包含了两个返回Path的静态工厂方法。
         Paths 类提供的静态 get() 方法用来获取 Path 对象：
            static Path get(String first, String … more) : 用于将多个字符串串连成路径
            static Path get(URI uri): 返回指定uri对应的Path路径
        PATH接口：
         Path 常用方法：
             String toString() ： 返回调用 Path 对象的字符串表示形式
             boolean startsWith(String path) : 判断是否以 path 路径开始
             boolean endsWith(String path) : 判断是否以 path 路径结束
             boolean isAbsolute() : 判断是否是绝对路径
             Path getParent() ：返回Path对象包含整个路径，不包含 Path 对象指定的文件路径
             Path getRoot() ：返回调用 Path 对象的根路径
             Path getFileName() : 返回与调用 Path 对象关联的文件名
             int getNameCount() : 返回Path 根目录后面元素的数量
             Path getName(int idx) : 返回指定索引位置 idx 的路径名称
             Path toAbsolutePath() : 作为绝对路径返回调用 Path 对象
             Path resolve(Path p) :合并两个路径，返回合并后的路径对应的Path对象
             File toFile(): 将Path转化为File类的对象
         java.nio.file.Files 用于操作文件或目录的工具类。
         Files常用方法：
             Path copy(Path src, Path dest, CopyOption … how) : 文件的复制
             Path createDirectory(Path path, FileAttribute<?> … attr) : 创建一个目录
             Path createFile(Path path, FileAttribute<?> … arr) : 创建一个文件
             void delete(Path path) : 删除一个文件/目录，如果不存在，执行报错
             void deleteIfExists(Path path) : Path对应的文件/目录如果存在，执行删除
             Path move(Path src, Path dest, CopyOption…how) : 将 src 移动到 dest 位置
             long size(Path path) : 返回 path 指定文件的大小
         Files常用方法：用于判断
             boolean exists(Path path, LinkOption … opts) : 判断文件是否存在
             boolean isDirectory(Path path, LinkOption … opts) : 判断是否是目录
             boolean isRegularFile(Path path, LinkOption … opts) : 判断是否是文件
             boolean isHidden(Path path) : 判断是否是隐藏文件
             boolean isReadable(Path path) : 判断文件是否可读
             boolean isWritable(Path path) : 判断文件是否可写
             boolean notExists(Path path, LinkOption … opts) : 判断文件是否不存在
             Files常用方法：用于操作内容
             SeekableByteChannel newByteChannel(Path path, OpenOption…how) : 获取与指定文件的连接，how 指定打开方式。
             DirectoryStream<Path> newDirectoryStream(Path path) : 打开 path 指定的目录
             InputStream newInputStream(Path path, OpenOption…how):获取 InputStream 对象
             OutputStream newOutputStream(Path path, OpenOption…how) : 获取 OutputStream 对象


*/