package grammar.D_HigeLevel_Program.B3_Collection;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @Description：
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/162335
 */
public class demo_01 {
    @Test
    public void testCollection(){
        Collection collection = new ArrayList();
        collection.add("AA");
        collection.add("BB");
        collection.add("CC");
        collection.add("EE");
        collection.add("DD");
        collection.add(123);
        collection.add(new String("Tom"));

        Collection collection1 = new ArrayList();
        collection1.addAll(collection);

        System.out.println(collection.size());
        System.out.println(collection1.size());

        collection.clear();
        System.out.println(collection.isEmpty());

        System.out.println(collection1.contains("ff"));

        Collection collection2 = Arrays.asList(123,456);
        System.out.println(collection.containsAll(collection2));
    }

    @Test
    public void testHashSet(){
        Collection collection = new HashSet();
        collection.add(123);
        collection.add(456);
        Collection collection1 = new HashSet();
        collection1.add(123);
        collection1.add(456);
        System.out.println(collection.containsAll(collection1));
        System.out.println(collection.hashCode());
    }

    @Test
    public void testIterator(){
        Collection collection = new ArrayList();
        collection.add("AA");
        collection.add("BB");
        collection.add("CC");
        collection.add("EE");
        collection.add("DD");
        collection.add(123);

        Iterator iterator = collection.iterator();

        while (iterator.hasNext()){
           Object obj = iterator.next();
           if ("EE".equals(obj)){
               iterator.remove();
           }
       }
        iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testForEach(){
        Collection collection = new ArrayList();
        collection.add("AA");
        collection.add("BB");
        collection.add("CC");
        collection.add("EE");
        collection.add("DD");
        collection.add(123);

        for (Object obj: collection){
            System.out.println(obj);
        }
    }
}