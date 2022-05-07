package examples.Inheritance;

public class Account {
    //属性
    private int id;
    private double balance;
    private double annualInterestRate;
    //无参构造器

    public Account(){

    }
    //全参构造器
    public Account(int id, double balance, double annualInterestRate){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }
    //方法getter/setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    //存取
    public void withdraw(double amount){
        if (amount>this.balance){
            System.out.println("您的余额不足");
            System.out.println("余额为" + this.balance);
        }else {
            this.balance = this.balance - amount;
            System.out.println("余额为" + this.balance);
        }
    }

    public void deposit(double amount){
        if (amount<0){
            System.out.println("请输入正确的金额");
        }else {
            this.balance = this.balance + amount;
            System.out.println("存款成功，余额为" + this.balance);
        }
    }
    //返回月利率
    public double getMonthlyInterest(){
        return (this.annualInterestRate/12);
    }
}
