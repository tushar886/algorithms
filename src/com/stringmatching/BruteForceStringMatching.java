package com.stringmatching;

public class BruteForceStringMatching {

    public static void matchPatternWithString(final String text, final String pattern) {
        /**
         * Brute Force compare each charecter with text and pattern and return True or False.
         */

        //we start with default match as True and make it false if match does not happens.

        int textlen = text.length();
        int patternlen = pattern.length();
        char[] textArray = text.toCharArray();
        char[] patternArray = pattern.toCharArray();

        int i = 0;
        while (i < textlen - patternlen +1) {

            int j;
            for (j = 0 ; j < patternlen; j++) {
                if (textArray[i + j] != patternArray[j]) {
                    break;
                }
            }

            if (j == patternlen) {
                System.out.println("There is match at:  " + i);
            }

            i++;
        }
    }

    public static void main (String args[]) {
        matchPatternWithString("DoYouSeeADogHere", "Dog");
    }
}
