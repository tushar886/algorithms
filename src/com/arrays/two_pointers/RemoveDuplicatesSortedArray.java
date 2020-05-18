package com.arrays.two_pointers;/* 
    tsrivast created on 4/29/2020 
    Package Name: -> com.arrays.two_pointers 
*/

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesSortedArray {

    public static List<Integer> removeDuplicates(final int arr[]) {
        List<Integer> result = new ArrayList<>();
        int firstIndex = 0, secondIndex = 1;
        while (secondIndex < arr.length) {
            if (arr[firstIndex] != arr[secondIndex]) {
                result.add(arr[firstIndex]);
                firstIndex = secondIndex;
            }
            secondIndex++;
            if (secondIndex == arr.length) {
                result.add(arr[secondIndex - 1]);
            }
        }
        return result;
    }

    public static void main (String args[]) {
        System.out.println("Pinting the duplicates less array " + removeDuplicates(new int[] { 2, 3, 3, 3, 6, 9, 9 }));
        int[] arr = new int[] { 1, 2, 2, 2, 11 };
        System.out.println(removeDuplicates(arr));
    }
}
