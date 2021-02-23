package com.psx;



public class FamilyAccount {
    public static void main(String[] args) {
        boolean isFlag=true;
        String details="收支\t账户金额\t收支金额\t\t说  明\n";
        int account=10000;
        while(isFlag){
            System.out.print("----------------家庭收支记账软件---------------\n");
            System.out.print("                1、收支明细\n");
            System.out.print("                2、登记收入\n");
            System.out.print("                3、登记支出\n");
            System.out.print("                4、退   出\n");
            System.out.print("                请选择（1-4）:");

            char selection=Utility.readMenuSelection();
            switch (selection){
                case '1':
                    System.out.print("----------------当前收支明细记录---------------\n");
                    System.out.println(details);
                    System.out.println("---------------------------------------------");
                    break;
                case '2':
                    System.out.print("请输入此次收入金额:");
                    int money=Utility.readNumber();
                    System.out.print("请输入此次收入说明:");
                    String info=Utility.readString();
                    account+=money;
                    details=details+"收入\t"+account+"\t"+money+"\t\t\t"+info+"\n";
                    System.out.println();
                    break;
                case '3':
                    System.out.print("请输入此次支出金额:");
                    int money1=Utility.readNumber();
                    System.out.print("请输入此次支出说明:");
                    String info1=Utility.readString();
                    account-=money1;
                    details=details+"支出\t"+account+"\t"+money1+"\t\t\t"+info1+"\n";
                    System.out.println();
                    break;
                case '4':
                    System.out.print("确认是否退出？（Y/N）:");
                    char confirmSelection=Utility.readConfirmSelection();
                    if(confirmSelection=='Y')
                        isFlag=false;

                    break;
            }

        }
    }
}
