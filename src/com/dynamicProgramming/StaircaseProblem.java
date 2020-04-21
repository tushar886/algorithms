package com.dynamicProgramming;

public class StaircaseProblem {

    //memo-table to be used for memoization
    static int memo[];

    private static void triggerMemoTable(int n) {
        memo = new int[n+1];
        for (int i = 0; i <= n ; i++)
            memo[i] = -1;
    }

    public static int findStepsRecursive(int n) {
        /**
         *  Returns count of ways to reach
         *  n-th stair using 1 or 2 or 3 steps.
         */

        //base cases
        if (n == 0 || n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        // recursive method here
        return findStepsRecursive(n-3) + findStepsRecursive(n-2) + findStepsRecursive(n-1);
    }

    public static int findStepsRecursiveMemoization(int n) {
        /**
         *  Returns count of ways to reach
         *  n-th stair using 1 or 2 or 3 steps.
         */

        //first step fill the memo table
        if (memo[n] == -1) {
            //base cases
            if (n == 0 || n == 1) {
                memo[n] = 1;
            }
            else if (n == 2) {
                memo[n] = 2;
            }
            else {
                // recursive method here
                memo[n] = findStepsRecursiveMemoization(n - 3) + findStepsRecursiveMemoization(n - 2) + findStepsRecursiveMemoization(n - 1);
            }
        }

        return memo[n];
    }

    public static int findStepsBottomUp(int n) {
        int[] response = new int[n+1];
        response[0] = 1;
        response[1] = 1;
        response[2] = 2;

        for (int i = 3; i <= n; i++) {
            response[i]= response[i-1]+response[i-2]+response[i-3];
        }
        for (int i =0; i <=n ; i++) {
            System.out.print(response[i] + " ");
        }
        System.out.println();
        return response[n];
    }

    public static void main(String args[]) {
        System.out.println("Brute force finding ways for climbing 7 stairs: " + findStepsRecursive(6));
        triggerMemoTable(6);
        System.out.println("Memoization finding ways for climbing 7 stairs: " + findStepsRecursiveMemoization(6));
        System.out.println("Bottom up finding ways for climbing 7 stairs: " + findStepsBottomUp(6));
    }
}
