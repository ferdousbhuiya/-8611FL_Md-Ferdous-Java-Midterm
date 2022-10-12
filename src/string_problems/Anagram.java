package string_problems;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    /**
     * INSTRUCTIONS
     * Write a Java Program, `isAnagram`, to check if any two strings are anagrams
     * <p>
     * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all of the
     * original letters exactly once.
     * <p>
     * Ex: "CAT" & "ACT",
     * "ARMY" & "MARY",
     * "FART" & "RAFT"
     */

    // Implement Here
    public static void main(String[] args) {

        System.out.println("Enter your first word to test the Anagram");
        Scanner scr = new Scanner(System.in);
                String s1= scr.next();
        System.out.println("Enter your Second word to test the Anagram");
        String s2 = scr.next();

        if (isAnagrams(s1, s2)) {
            System.out.println("'"+s1 + "' and '" + s2 + "' are anagrams");
        } else {
            System.out.println("'"+s1 + "' and '" + s2 + "' are  not anagrams");
        }
    }

    static boolean isAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        } else {
            char ch1[] = s1.toCharArray();
            char ch2[] = s2.toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);

            if (Arrays.equals(ch1, ch2)) {
                return true;
            } else {
                return false;
            }

        }
    }
}
