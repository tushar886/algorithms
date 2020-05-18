package com.arrays.sliding_window;/* 
    tsrivast created on 4/28/2020 
    Package Name: -> com.arrays.sliding_window 
*/

import java.util.HashMap;
import java.util.Map;

public class StringPermutationPatternMatch {

    public static boolean findPatternMatch(final String str, final String pattern) {
        //validation case if pattern is of length high then fail the execution.
        if (pattern.length() > str.length()) {
            throw new IllegalArgumentException("Invalid pattern provided");
        }

        //Step1: Create the Pattern frequency map
        Map<Character, Integer> patternFreqMap = new HashMap<>();
        for (char ch: pattern.toCharArray()) {
            patternFreqMap.put(ch, patternFreqMap.getOrDefault(ch, 0) + 1);
        }

        //Step 2: Start traversing the string.
        int winStart = 0, matched = 0;
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {
            //pick the first character of window
            char rightChar = str.charAt(winEnd);
            if (patternFreqMap.containsKey(rightChar)) {
                //char is present in pattern, decrement its frequency.
                patternFreqMap.put(rightChar, patternFreqMap.get(rightChar) - 1);
                //check if frequency has become zero then increase the matched counter
                if (patternFreqMap.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == patternFreqMap.size()) {
                // now if the matched is equal to size of map then all chars have matched.
                return true;
            }

            //Now we need to write logic for extending window, there is no need for moving window start
            if (winEnd  >= pattern.length() - 1) {
                char leftChar = str.charAt(winStart++);
                if (patternFreqMap.containsKey(leftChar)) {
                    if (patternFreqMap.get(leftChar) == 0) {
                        matched--;
                    }
                    patternFreqMap.put(leftChar, patternFreqMap.get(leftChar) + 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + findPatternMatch("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + findPatternMatch("odicf", "dc"));
        System.out.println("Permutation exist: " + findPatternMatch("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + findPatternMatch("aaacb", "abc"));
    }
}
