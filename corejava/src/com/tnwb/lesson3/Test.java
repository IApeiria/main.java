package com.tnwb.lesson3;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        double salary;
//        int vacationDays;
//        long earthPopulation;
//        boolean done;

//        int vacationDays;
//        System.out.println(vacationDays);

//        Size s = Size.MEDIUM;

//        System.out.println("" + 15/2);

//        int m = 7;
//        int n = 7;
//
//        int a = 2 * ++m;
//        int b = 2 * n++;
//
//        System.out.println("m is " + m);
//        System.out.println("n is " + n);
//        System.out.println("a is " + a);
//        System.out.println("b is " + b);

//        String greeting = "Hello";
//        String s = greeting.substring(0,3);
//
//        System.out.println("s is " + s);
//
//        String expletive = "Expletive";
//        String PG13 = "deleted";
//        String message = expletive + PG13;
//
//        System.out.println("message is " + message);
//
//        int age = 13;
//        String rating = "PG" + age;
//
//        System.out.println("rating is " + rating);

//        double y = 1.0 - 0.9;
//        System.out.println(y);

//        double x = 10000.0 / 3.0;
//        System.out.println(x);
//
//        System.out.printf("%8.2f", x);
//
//        int n;
//
//        {
//            int k;
//            int n;
//        }
//
//        System.out.println(k);

//        int i = -1;
//
//        if(i >= 10 ) {
//            System.out.println("i am in if");
//        } else if (i < 10 && i >= 0) {
//            System.out.println("i am in else if");
//        } else {
//            System.out.println("i am in else");
//        }

//        int sum = 0;
//
//        int i = 101;
//        while (i <= 100) {
//            sum = sum + i;
//
//            i++;
//        }
//
//        System.out.println("sum is " + sum);

//        int sum = 0;
//
//        int i = 101;
//        do {
//            sum = sum + i;
//
//            i++;
//        } while (i <= 100);
//
//        System.out.println("sum is " + sum);

// for语句的语义是：
//
//（1）首先计算表达式1的值，通常为循环变量赋初值；
//
//（2）再计算表达式2的值，即判断循环条件是否为真，若值为真则执行循环体一次，否则跳出循环；
//
//（3）然后再计算表达式3的值，这里通常写更新循环变量的赋值表达式，然后转回第二步重复执行。
//
// 在整个for循环过程中，表达式1只计算一次，表达式2和表达式3则可能计算多次。循环体可能执行多次，也可能一次都不执行。
//
//        for(int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }

//        for(int i = 11; i < 10; i++) {
//            System.out.println(i);
//        }

//        int c= 0;
//        for(int i = 0, j = i; i < 10; i++,c++) {
//            System.out.println("i is " + i);
//
//            System.out.println("c is " + c);
//            System.out.println("j is " + j);
//        }

//        for(int i = 0; i < 10; i++) {
//            if(i == 5) {
//                break;
//            }
//            System.out.println(i);
//        }

//        for(int i = 0; i < 10; i++) {
//            if(i == 5) {
//                continue;
//            }
//
//            System.out.println(i);
//        }

//        BigDecimal bigDecimal1 = new BigDecimal("0.1");
//        BigDecimal bigDecimal2 = new BigDecimal(0.1);
//
//        System.out.println(bigDecimal1);
//        System.out.println(bigDecimal2);

//        int[] a;

//        int[] a = new int[100];
//
//        int[] smallPrimes = {2, 3, 5, 7, 11, 13};

//        int[] a = new int[100];
//        for(int i = 0; i < 100; i++)
//            a[i] = i;
//
//        for(int i = 0; i < a.length; i++)
//            System.out.println(a[i]);
//
//        for(int element : a)
//            System.out.println(element);

        int[] smallPrimes = {2, 3, 5, 7, 11, 13};
//        int[] luckyNumbers = smallPrimes;
//        luckyNumbers[5] = 12;
//
//        System.out.println(luckyNumbers[5]);
//        System.out.println(smallPrimes[5]);

        int[] copiedLuckyNumbers = Arrays.copyOf(smallPrimes, smallPrimes.length);

        copiedLuckyNumbers[0] = 100;

        System.out.println(copiedLuckyNumbers[0]);
        System.out.println(smallPrimes[0]);
    }

}

enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE};
