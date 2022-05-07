package examples.Triangle;
/*
子类只能直接使用public
间接使用protected
 */
public class subOrderTest {
    public static void main(String[] args) {
        subOrder o3 = new subOrder();
        int orderPublic = o3.orderPublic;
    }
}
