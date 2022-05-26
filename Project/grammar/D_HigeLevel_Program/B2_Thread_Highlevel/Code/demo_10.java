package grammar.D_HigeLevel_Program.B2_Thread_Highlevel.Code;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description：Java比较器{Comparable接口、Comparator接口}
 * @Version：V1.0
 * @JDK-Version:1.8nm
 * @SoftWare:IntelliJ-IDEA-2022.1
 * @Author:Joe
 * @CreateTime:2022/5/131913
 */
public class demo_10 {
    @Test
    public void testComparable(){
        String[] arr = new String[]{"AA","GG","JJ","MM","DD","KK"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Goods[] arr1 = new Goods[4];
        arr1[0] = new Goods("lianxiang",50);
        arr1[1] = new Goods("xiaomi",38);
        arr1[2] = new Goods("huawei",50);
        arr1[3] = new Goods("huipu",40);
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    @Test
    public void testComparator(){
        String[] arr = new String[]{"AA","GG","JJ","MM","DD","KK"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;

                    return -s1.compareTo(s2);
                }
                return 0;
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testComparator1(){
        Goods[] arr1 = new Goods[4];
        arr1[0] = new Goods("lianxiang",50);
        arr1[1] = new Goods("xiaomi",38);
        arr1[2] = new Goods("huawei",50);
        arr1[3] = new Goods("huipu",40);
        Arrays.sort(arr1, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                Goods g1 = (Goods) o1;
                Goods g2 = (Goods) o2;

                if (g1.getName().equals(g2.getName())){
                    return -Integer.compare(g1.getPrice(),g2.getPrice());
                }else {
                    return g1.getName().compareTo(g2.getName());
                }
            }
        });
        System.out.println(Arrays.toString(arr1));
    }
}

class Goods implements Comparable{
    private String name;
    private int price;

    public Goods() {

    }

    public Goods( String name,int price) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if ( o instanceof Goods){
            Goods goods = (Goods) o;
            if (this.price>goods.price){
                return 1;
            } else if (this.price<goods.price) {
                return -1;
            }else {
                return this.name.compareTo(goods.name);
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "{Goods: name = " + this.name + ",price = " + this.price+"}";
    }
}

