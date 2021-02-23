package com.psx;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author psx
 * @date 2021/2/22 9:31
 */
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer=new Customer("张三",'男',23,"1231234214324","123@qq.com");
        customerList.addCustomer(customer);
    }

    public void enterMainMenu() {
        boolean isFlag=true;
        while(isFlag) {
            System.out.print("----------------客服信息管理软件---------------\n");
            System.out.print("                1、添加客户\n");
            System.out.print("                2、修改客户\n");
            System.out.print("                3、删除客户\n");
            System.out.print("                4、客户列表\n");
            System.out.print("                5、退出\n");
            System.out.print("请选择（1-5）:");
            char menu=CMUtility.readMenuSelection();
            switch (menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAl1Customers();
                    break;
                case '5':
                    System.out.print("是否确认退出？（Y/N）:");
                    char ch=CMUtility.readConfirmSelection();
                    if(ch=='Y') {
                        System.out.println("已退出！");
                        isFlag = false;
                    }
            }

        }
    }

    private void addNewCustomer(){
        System.out.println("-------------------------添加客户-------------------------------");

        System.out.print("客户姓名:");
        String name=CMUtility.readString(20);
        System.out.print("客户性别:（男/女）");
        char sex=CMUtility.readChar();
        System.out.print("客户年龄:");
        int age=CMUtility.readInt();
        System.out.print("客户电话:");
        String phone=CMUtility.readString(11);
        System.out.print("客户邮箱:");
        String address=CMUtility.readString(20);
        Customer customer=new Customer(name,sex,age,phone,address);
        boolean flag=customerList.addCustomer(customer);
        if(flag)
            System.out.println("-----------------------添加客户完成-------------------------------");
        else
            System.out.println("-----------------------添加客户失败-------------------------------");
    }

    private void modifyCustomer(){
        System.out.println("-------------------------修改客户-------------------------------");
        Customer customer = new Customer();
        int num;
        while(true) {
            System.out.print("请输入修改的编号(-1退出):");
             num = CMUtility.readInt();
            if (num == -1) {
                return;
            }

            customer = customerList.getCustomer(num - 1);
            if (customer == null)
                System.out.println("无法找到指定客户");
            else {
                break;
            }
        }
        System.out.print("请输入修改的姓名("+customer.getName()+"):");
        String newName=CMUtility.readString(20,customer.getName());

        System.out.print("请输入修改的性别("+customer.getGender()+"):");
        char newGender=CMUtility.readChar(customer.getGender());

        System.out.print("请输入修改的年龄("+customer.getAge()+"):");
        int newAge=CMUtility.readInt(customer.getAge());

        System.out.print("请输入修改的电话("+customer.getPhone()+"):");
        String newPhone=CMUtility.readString(11,customer.getPhone());

        System.out.print("请输入修改的邮箱("+customer.getEmail()+"):");
        String newEmail=CMUtility.readString(20,customer.getEmail());

        Customer newCustomer=new Customer(newName,newGender,newAge,newPhone,newEmail);
        customerList.replaceCustomer(num-1,newCustomer);
        System.out.println("-----------------------修改客户完成-------------------------------");

    }

    private void deleteCustomer(){
        System.out.println("-------------------------删除客户-------------------------------");
        int num;
        while(true){
            System.out.print("请输入删除的编号（-1退出）:");
            num=CMUtility.readInt();
            if(num!=-1) {
                Customer customer=customerList.getCustomer(num-1);
                if(customer==null)
                    System.out.println("无法找到指定客户");
                else{
                    System.out.print("是否确认删除？（Y/N）:");
                    char ch = CMUtility.readConfirmSelection();
                    if (ch == 'Y') {
                        boolean flag = customerList.deleteCustomer(num - 1);

                        if (flag) {
                            System.out.println("已删除！");
                            System.out.println("-----------------------删除客户完成-------------------------------");
                        } else
                            System.out.println("-----------------客户目录已满，添加客户失败-------------------------------");
                    }
                    break;
                }

            }

        }

    }

    private void listAl1Customers (){
        System.out.println("-------------------------客户列表-------------------------------");

        if(customerList.getTotal()==0)
            System.out.println("没有客户记录");
        else{
            Customer[] customers=customerList.getAllCustomers();
            System.out.println("编号      姓名      性别      年龄      电话          邮箱           ");
            for(int i=0;i<customers.length;i++){
                String str="";
                str+=(i+1)+"        "+customers[i].getName()+"      "+customers[i].getGender()+"        "+customers[i].getAge()+"      "+customers[i].getPhone()+"          "+customers[i].getEmail();
                System.out.println(str);
            }
        }

        System.out.println("-----------------------客户列表显示完成-------------------------------");
    }

    public static void main( String[] args){
        CustomerView customerView=new CustomerView();
        customerView.enterMainMenu();


    }


}
