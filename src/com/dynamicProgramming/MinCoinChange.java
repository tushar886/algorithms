package com.dynamicProgramming;

public class MinCoinChange {

    //available denomination coins 10, 6 and 1
    private static int[] coins = new int[]{1, 6, 10};

    private static int makeChangeBruteForce(int change) {
        /*
        Go through every combination of coins and see that sums up to change.
        From those combinations select the minimum one
         */
        if (change == 0) {
            // because even 0 is a ne combination
            return 1;
        }

        if (change < 0) {
            return 0;
        }

        int nCombo = 0;
        for (int coin = 0; coin < coins.length; coin++) {
            nCombo += makeChangeBruteForce(change - coins[coin]);
        }

        return  nCombo;
    }

    private static int makeChangeOptimized(int change) {
        int cache[] = new int[change + 1];
        // initiliaze the cache as -1 for all elements in it.
        for (int i =0; i < change+1; i++) {
            cache[i] = -1;
        }
        return makeChangeDPMemo(change, cache);
    }

    private static int makeChangeDPMemo(int change, int[] cache) {
        //check vallue first in cache to avoid recomputations.
        if(cache[change] >= 0) {
            return cache[change];
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (change - coin >= 0) {
                int currCoin = makeChangeDPMemo(change - coin, cache);
                if (currCoin <= minCoins) {
                    minCoins = currCoin;
                }
             }
        }
        cache[change] = minCoins + 1;
        return cache[change];
    }

    public static int coinChangeBottomUp(int amount) {
        /**
         * This is exampple of bottom up DPmethod where we calculate the ways from botto up approach.
         */

        int[] combinations = new int[amount + 1];
        //initilaize combination 0 as 1
        combinations[0] = 1;

        //first traverse over the coins
        for ( int coin : coins) {
            //pick one coin and now use it to fill the combination array
            for (int i = 1; i < combinations.length; i++) {
                if (i >= coin) {
                    combinations[i] += combinations[i-coin];
                    printAmount(combinations);
                }
            }
            System.out.println();
        }

        return combinations[amount];
    }

    public static void printAmount(int arr[]) {
        for (int i =0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        System.out.println("Coin Change Brute foorce " + makeChangeBruteForce(17));
        System.out.println("Coin change DP Optimized "  + makeChangeOptimized(17));
        System.out.println("Coin change bottom up DP " + coinChangeBottomUp(17));
    }

}
