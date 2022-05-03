package grammar.A_Basic_Grammar;

public class A2_Scanner_Print {
    public static void main(String[] args){
        int i = 0;
        while(i<100){
            //1-10
            System.out.println((int)((Math.random())*10+1));
            //0-10
            System.out.println(Math.round((Math.random())*10));
            i++;
        }
    }
}
