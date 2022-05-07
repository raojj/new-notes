package examples.Inheritance;

public class CheckAccount extends Account{
    private double overdraft;

    //无参构造器
    public CheckAccount(){

    }
    //全参构造器
    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount){
        if (amount>(this.getBalance()+this.overdraft)){
            System.out.println("您的余额不足");
            System.out.println("余额为+可透支额度为" + (this.getBalance()+this.overdraft));
        }else {
            this.setBalance(this.getBalance()-amount);
            System.out.println("余额为+可透支额度为" + (this.getBalance()+this.overdraft));
        }
    }
}
