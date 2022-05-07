package examples.Triangle;
/*
子类可以使用protected和public
 */
import examples.Right.Order;

public class subOrder extends Order {
    public void test(){
        int orderProtected =  this.orderProtected;
    }
}
