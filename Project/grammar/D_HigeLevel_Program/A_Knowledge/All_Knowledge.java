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

    五. Java比较器{Comparable接口、Comparator接口}

    六. System类

    七. Math类

    八. BigInteger & BigDecimal
 */