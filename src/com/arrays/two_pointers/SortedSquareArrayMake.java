package com.arrays.two_pointers;/* 
    tsrivast created on 4/30/2020 
    Package Name: -> com.arrays.two_pointers 
*/

import java.util.Arrays;

public class SortedSquareArrayMake {

    public static int[] makeSortedSquareArray(final int arr[]) {
        int result[] = new int[arr.length];
        int first = 0, last = arr.length - 1;
        int highestIndex = arr.length - 1;

        while (first < last) {

            int leftSquare = arr[first] * arr[first];
            int rightSquare = arr[last] * arr[last];

            if (leftSquare == rightSquare) {
                result[highestIndex] = leftSquare;
                result[--highestIndex] = rightSquare;
                first++;
                last--;
            } else if (leftSquare < rightSquare) {
                result[highestIndex] = rightSquare;
                last--;
            } else {
                result[highestIndex] = leftSquare;
                first++;
            }
            highestIndex--;
        }
        return result;
    }

    public static void main (String args[]) {
        System.out.println("Make Sorted array is as : " + Arrays.toString(makeSortedSquareArray(new int[]{-3, -1, 0, 1, 2})));
        System.out.println("Make Sorted array is as : " + Arrays.toString(makeSortedSquareArray(new int[]{-2, -1, 0, 2, 3})));
    }
 }
