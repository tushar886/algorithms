package com.recursion;

public class BasicRecursion {

    public static void printNumberRecursiveNTo1(int n) {
        /*
        This method prints from n to 1 recursively without using loop
         */

        //base condition
        if (n <= 0)
            return;

        //print the number
        System.out.println(n);

        //now further call the sub-problem with n-1
        printNumberRecursiveNTo1(n-1);
    }

    public static void printNumberRecursive1ToN(int n) {
        /*
        This method prints from n to 1 recursively without using loop
         */

        //base condition
        if (n <= 0)
            return;
        //now further call the sub-problem with n-1
        printNumberRecursive1ToN(n-1);
        //print the number
        System.out.println(n);

    }

    public static void main(String args[]) {
        printNumberRecursive1ToN(10);
    }
}
