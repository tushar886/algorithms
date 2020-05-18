package com.arrays.two_pointers;/* 
    tsrivast created on 5/18/2020 
    Package Name: -> com.arrays.two_pointers 
*/

public class DutchNationalFlagAlgorithm {

    public static void dutchSort(int arr[]) {
        /*
        maintain two pointers low and high.
        The idea is to have all 0's before low index, all 2's after high index and all 1's between low and high
         */
        int low = 0, high = arr.length - 1;
        for (int i =0; i <= high;) {
            if (arr[i] == 0) {
                //swap the low with i as 0's will remain before low.
                swap(arr, i, low);
                i++;
                low++;
            }
            else if (arr[i] == 1) {
                //do nothing
                i++;
            }
            else if (arr[i] == 2) {
                //swap high with i
                swap(arr, i, high);
                high--;
            }
        }
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =  temp;
    }


    public static void  main (String args[]) {
        int arr[] = new int[] {1, 0, 2, 1, 0, 1, 0};
        System.out.println("Dutch Sort array is as: " );
        dutchSort(arr);
        for (int i =0; i < arr.length; i++) {
            System.out.print(arr[i] + " , ");
        }
    }
}
