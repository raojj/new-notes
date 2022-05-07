package examples.Triangle;
/*
不同包下只能使用public
 */
import examples.Right.Order;

public class DifferentOrder {
    public static void main(String[] args) {
        Order o2 = new Order();
        int orderPublic = o2.orderPublic;
    }
}
