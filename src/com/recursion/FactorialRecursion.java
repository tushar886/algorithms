package com.recursion;

public class FactorialRecursion {

    public static int computeFactorialHeadRecursion(int n) {
        /*
            This is head recursive since we are not computed anything but rather maintaining the entire stack of recursion.
         */

        if (n == 0 || n ==1)
            return 1;

        return n * computeFactorialHeadRecursion(n-1);
    }

    public static int computeFactorialTailRecursion(int n, int result) {
        /*
        This call is tail recursive since at last we are not returning recursive call but rather returning
        the call with some computed result so far.
         */
        if (n == 0 || n ==1)
            return result;

        return computeFactorialTailRecursion(n-1, result * n);
    }

    public static void main(String args[]) {
        System.out.print(computeFactorialTailRecursion(5, 1));
    }
}
