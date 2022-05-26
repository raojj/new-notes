package grammar.D_HigeLevel_Program.B3_Collection;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @Description：
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/171327
 */
public class demo_02 {
    @Test
    public void testList(){
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);
        list.add(987);
        list.add(123);

        List list1 = new ArrayList();
        list1.addAll(list);

        System.out.println(list);
        System.out.println(list.indexOf(123)+1);
        System.out.println(list.lastIndexOf(123)+1);
    }

    @Test
    public void testArrayList(){
        ArrayList strList = new ArrayList(50);
        strList.add("raojian");
        strList.add("aaojian");
        strList.add("baojian");
        strList.add("zaojian");
        System.out.println(strList.size());
        strList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1.equals(o2)){
                    return 0;
                }else {
                    return o1.toString().compareTo(o2.toString());
                }
            }
        });
        for (Object obj:strList){
            System.out.println(obj);
        }

    }

    @Test
    public void testLinkedList(){
        LinkedList list = new LinkedList();
        list.add("rao");
        list.add("jian");
        System.out.println(list);
    }

    @Test
    public void testVector(){
        String str = "rao";
        System.out.println(str.hashCode());
    }

    @Test
    public void testTreeSet(){
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return -o1.toString().compareTo(o2.toString());
            }
        });

        set.add("ZZ");
        set.add("DD");
        set.add("AA");
        set.add("BB");
        set.add("EE");
        set.add("CC");

        System.out.println(set);
    }
}
