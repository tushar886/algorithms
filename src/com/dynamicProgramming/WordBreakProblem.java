package com.dynamicProgramming;
import java.util.List;
import java.util.Arrays;

public class WordBreakProblem {

    public static boolean wordBreakRecursive(List<String> dict, String word) {

        //base case if the length of word is 0
        if (word.length() == 0) {
            return true;
        }

        for (int i =1; i <=word.length(); i++) {
            //first consider the prefix from 0 to i
            String prefix = word.substring(0, i);

            //Take the prefix and also the substring from i to length of string
            if (dict.contains(prefix) && wordBreakRecursive(dict, word.substring(i))) {
                return true;
            }
        }
        //return falsse if string can't be segmented.
        return false;
    }

    public static void wordBreakRecursivePrintPassthrough(List<String> dict, String word, String out) {

        // if we have reached the end of the String,
        // print the output String

        if (word.length() == 0)
        {
            System.out.println(out);
            return;
        }

        for (int i = 1; i <= word.length(); i++)
        {
            // consider all prefixes of current String
            String prefix = word.substring(0, i);

            // if the prefix is present in the dictionary, add prefix to the
            // output String and recur for remaining String.
            if (dict.contains(prefix)) {
                wordBreakRecursivePrintPassthrough(dict, word.substring(i), out + " " + prefix);
            }
        }
    }

    public static void main (String args[]) {
        // List of Strings to represent dictionary
        List<String> dict = Arrays.asList("this", "th", "is", "famous",
                "Word", "break", "b", "r", "e", "a", "k",
                "br", "bre", "brea", "ak", "problem");

        // input String
        String str = "Wordbreakproblem";

        if (wordBreakRecursive(dict, str)) {
            System.out.print("String can be segmented");
        } else {
            System.out.print("String can't be segmented");
        }
    }
}
