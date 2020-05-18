package com.arrays.two_pointers;/* 
    tsrivast created on 4/30/2020 
    Package Name: -> com.arrays.two_pointers 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithZeroSum {

    public static List<List<Integer>> findTripletWithZeroSum(final int arr[]) {
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i=0; i < arr.length-2; i++) {
            //we need to find unique triplets so skip any redundant items first
            if (i > 0 && arr[i] == arr[i+1])
                continue;
            //now outside search pair with sum as -arr[i]
            // X + Y +Z =0  -->  X + Y = -Z
            searchPair(arr, -arr[i], i +1, triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {

        int right = arr.length - 1;
        while (left < right) {
            int currSum = arr[left] + arr[right];
            if (currSum == targetSum) {
                //found the triplet
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                // now since we have found the target sum pair, traverse so that we avoid duplicates adding in triplets.
                while (left < right && arr[left] == arr[left - 1])
                    left++; // skip same element to avoid duplicate triplets
                while (left < right && arr[right] == arr[right + 1])
                    right--; // skip same element to avoid duplicate triplets.
            } else if (targetSum > currSum)
                left ++;
              else
                  right--;
        }
    }

    public static void main(String args[]) {
        System.out.println(findTripletWithZeroSum(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(findTripletWithZeroSum(new int[] { -5, 2, -1, -2, 3 }));
    }
}
