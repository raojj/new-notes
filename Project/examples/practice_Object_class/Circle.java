package examples.practice_Object_class;

public class Circle extends GeometricObject{
    private double radius;
    //构造器
    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, double weight) {
        this.setRadius(radius);
        super.setColor(color);
        super.setWeight(weight);
    }
    //方法
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea(){
        double s = radius*radius*Math.PI;
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        Boolean result = false;
        if (obj instanceof Circle){
            if (((Circle) obj).radius==this.radius){
                result=true;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Circle [radius="+radius+"]";
    }
}
