package grammar.D_HigeLevel_Program.B3_Collection;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @Description：
 * @Version：V1.0
 * @JDK-Version:1.8
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/181938
 */
public class demo_04 {
    @Test
    public void testE(){
        ArrayList <Integer> list = new ArrayList<>();
        list.add(10);
        list.add(15);
        list.add(16);
        list.add(17);
        list.add(11);

        for (Integer obj:list){
            System.out.println(obj);
        }
    }

    @Test
    public void testHashMap(){
        Map<String,Integer> map = new HashMap<>();
        map.put("张三",100);
        map.put("李四",99);
        map.put("王五",80);
        map.put("小二",70);

        System.out.println(map.entrySet());
        System.out.println(map.keySet());
        System.out.println(map.values());

        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key+"-----"+value);
        }
    }
}
