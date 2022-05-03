package examples.Triangle;

public class Triangle {
    //属性
    private double basement;
    private double height;

    //无参构造器
    public  Triangle(){

    }
    //单参构造器
    public Triangle(double height){
        this.height = height;
    }
    //全参构造器
    public Triangle(double basement,double height){
        this.basement = basement;
        this.height = height;
    }

    //方法
    public double getBasement() {
        return basement;
    }

    public void setBasement(double basement) {
        this.basement = basement;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double printS(){
        return (this.height*this.basement);
    }
}
