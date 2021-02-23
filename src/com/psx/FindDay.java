package com.psx;

import java.util.Scanner;

public class FindDay {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入年份：");
        int year = in.nextInt();
        System.out.print("请输入月份：");
        int month = in.nextInt();
        System.out.print("请输入日：");
        int day = in.nextInt();
        boolean flag = false;
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
            flag = true;
        int sumDays = 0;
        switch (month) {
            case 12:
                sumDays += 30;
            case 11:
                sumDays += 31;
            case 10:
                sumDays += 30;
            case 9:
                sumDays += 31;
            case 8:
                sumDays += 31;
            case 7:
                sumDays += 30;
            case 6:
                sumDays += 31;
            case 5:
                sumDays += 30;
            case 4:
                sumDays += 31;
            case 3:
                if (flag)
                    sumDays += 29;
                else
                    sumDays += 28;
            case 2:
                sumDays += 31;
            case 1:
                sumDays += day;
        }
        System.out.println("这是"+year+"年的第"+sumDays+"天");
    }
}
