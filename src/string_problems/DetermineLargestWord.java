package string_problems;

import java.util.*;

public class DetermineLargestWord {

    /** INSTRUCTIONS
     * Implement a solution to find the length of the longest word in the given sentence below
     * Your solution should return a map containing the length of the word as the key & the word itself as the value
     * "10: biological"
     */

    public static void main(String[] args) {
        String s = "Human brain is a biological learning machine";
        Map<Integer, String> wordNLength = findTheLargestWord(s);

    }

    public static Map<Integer, String> findTheLargestWord(String wordGiven) {
        Map<Integer, String> map = new HashMap<Integer, String>();

        String longestWord = Arrays.stream(wordGiven.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse(null).toString();
        //System.out.println(longestWord +", length-"+ longestWord.length());
        System.out.println(" Longest word: "+longestWord);
        System.out.println(" Length: "+longestWord.length());
        map.put(longestWord.length(), longestWord);

        System.out.println("-----------------------");
        System.out.println("Key "+" | " + "Values");
        System.out.println("-----------------------");


        Set<Integer> set = map.keySet();
        for(Integer key: set)
        {
            String value = map.get(key);
            System.out.println(key + "    | "+value);
        }

        // Implement here

        return map;
    }

}
