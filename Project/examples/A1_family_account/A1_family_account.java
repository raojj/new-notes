package examples.A1_family_account;

public class A1_family_account {
    public static void main(String[] args){
        boolean isFlag = true;
        while (isFlag){
            System.out.println("--------------------家庭收支明细软件--------------------");
            System.out.println("                      1.收支明细                       \n");
            System.out.println("                      2.登记收入                       \n");
            System.out.println("                      3.登记支出                       \n");
            System.out.println("                      4.退    出                       \n");
            System.out.println("                     请选择（1—4）                       \n");
            char selection = Utility.readMenuSelection();
            switch (selection){
                case '1':

                case '2':

                case '3':

                case '4':
                    System.out.println("请问是否确认退出Y/N");
                    char isExit = Utility.readConfirmSelection();
                    if (isExit == 'Y'){
                        isFlag = false;
                    }

            }
        }
    }

}
