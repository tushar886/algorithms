package com.dynamicProgramming;

public class Fibonacci {

    static int memo[];

    private static void triggerMemoTable(int n) {
        memo = new int[n+1];
        for (int i = 0; i <= n ; i++)
            memo[i] = -1;
    }

    public static int fibBasicRecursion(int n) {
        if (n==0 || n==1) {
            return 1;
        }

        return fibBasicRecursion(n-1) + fibBasicRecursion(n-2);
    }

    public static int fibOpitmizedMemoization(int n) {

        //First step will be filling the memo table and then return the nth entry
        if (memo[n] == -1) {
            if (n == 0 || n == 1) {
                memo[n] = 1;
            } else {
                memo[n] = fibOpitmizedMemoization(n - 1) + fibOpitmizedMemoization(n - 2);
            }
        }

        // it willcome outide of this only whem memo table is full
        return memo[n];
    }

    public static void main(String args[]) {
        System.out.println(fibBasicRecursion(5));
        triggerMemoTable(5);
        System.out.println(fibOpitmizedMemoization(5));

    }


}
