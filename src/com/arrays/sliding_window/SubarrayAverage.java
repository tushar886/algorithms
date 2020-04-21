package com.arrays.sliding_window;

import java.util.Arrays;

public class SubarrayAverage {


    public static double[] findAverageBruteForce(int[] arr, int k) {
           /*
           This method finds the average of contiguous subarrays of size k in array arr.
           Brute force is used where complexity is O(n*k) and the
            */
           double[] result = new double[k];
           for (int i =0; i <= arr.length - k; i++) {
               // find sum of next k elements
               double sum = 0;
               for (int j=i; j < i + k; j++) {
                   sum += arr[j];
               }
               result[i] = sum/k;
           }
           return result;
    }

    public static double[] findAverageSlidingWindow(int[] arr, int k) {

        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length ; windowEnd++) {
            windowSum  += arr[windowEnd];

            //check whether the window end has reached k size
            if (windowEnd  >=  k-1) {
                result[windowStart] = windowSum / k; // calculate the average
                windowSum -= arr[windowStart]; //subtract the elemnt going out if window
                windowStart++;
            }
        }
        return result;
    }

    public static void main (String args[]) {
        int arr[] = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2};
        System.out.println("Brute force array sum is as : " + Arrays.toString(findAverageBruteForce(arr, 5)));
        System.out.println("Brute force array sum is as : " + Arrays.toString(findAverageSlidingWindow(arr, 5)));
    }
}
