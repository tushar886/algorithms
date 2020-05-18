package com.arrays.sliding_window;

/*
tsrivast created on 4/22/2020
inside the package - com.arrays.sliding_window
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDistinctChars {

    public static int findMaxLengthKDistinct(final String str, final int k) {
        int windowStart =0, maxLength =0;
        final Map<Character, Integer> frequencyMap = new HashMap<>();

        //Start with traversing the string from left to right
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            //Take the character and first add it to map and extend the window one step ahead.
            char rightChar = str.charAt(windowEnd);
            frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar,  0) + 1);

            //now check for base condition , meaning have we ot violated more than k characters.
            // The best way would be to check the map size.
            while (frequencyMap.size() > k) {
                //if window size is more than k
                char leftChar = str.charAt(windowStart);
                //get the first left char and remove it from the map as we are going to shring the window.
                frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);
                if (frequencyMap.get(leftChar) == 0) {
                    // remove tthat char if its frequency is 0
                    frequencyMap.remove(leftChar);
                }
                //increment window one step ahead
                windowStart ++;
            }
            //After one iteration keep track of maxLength variable
            maxLength = Math.max(windowEnd - windowStart + 1, maxLength);
        }
        System.out.println("The pattern is as: " + frequencyMap);
        return maxLength;
    }

    public static void main (String args[]) {
        System.out.println("Longest Distinct chars for string araaci and k =1 is as: " + findMaxLengthKDistinct("araaci", 1));
    }
}
