package com.arrays.sliding_window;/* 
    tsrivast created on 4/24/2020 
    Package Name: -> com.arrays.sliding_window 
*/

import java.util.Map;
import java.util.HashMap;

public class NoRepeatSubString {

    public static int findLengthOfNoRepeatSubString(final String str) {

        int winStart = 0, maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for (int winEnd =0; winEnd < str.length(); winEnd++) {
            char rightChar = str.charAt(winEnd);

            //Now check whether map already has that or not.
            if (charMap.containsKey(rightChar)) {
                //key is already present in the map, no need to add it.
                //Time to shhift the sliding window start pointer.
                // The shifting will be max of two values whether the winStart which is starting as that can be case if
                winStart = Math.max(winStart, charMap.get(rightChar) + 1);
            }
            // charMap does not contain put it in.
            charMap.put(rightChar, winEnd);
            maxLength = Math.max(maxLength, winEnd - winStart + 1);
        }
        System.out.println("The patterns is as: " + charMap);
        return maxLength;
    }

    public static void main(String args[]) {
        System.out.println("The NORepeat SubString is as: " + findLengthOfNoRepeatSubString("aabccbb"));
    }
 }
