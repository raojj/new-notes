package examples.Triangle;

public class TriangleTest {
    public static void main(String[] args) {
        Triangle t = new Triangle();
        Triangle t2 = new Triangle(4.5,6.9);
        t.setBasement(5.0);
        t.setHeight(7.5);
        System.out.println(t2.printS());
        System.out.println(t.printS());
    }
}
