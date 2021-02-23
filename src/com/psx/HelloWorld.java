package com.psx;

/**
 * @author psx
 * @version V1.1
 *
 *
 */
public class HelloWorld {
    static public class student{
        int id;
        String name;
        String address;
        public student(int id,String name,String address){
            this.id=id;
            this.name=name;
            this.address=address;
        }
    }

    public static void main(String[] args) {
        student stu=new student(12,"彭仕鑫","宜宾");
        System.out.println(stu.name);
        System.out.println(stu.address);
        System.out.println("hello world!");

    }

}
