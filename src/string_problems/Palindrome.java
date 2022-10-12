package string_problems;

import java.util.Scanner;

public class Palindrome {

    /**
     * INSTRUCTIONS
     * A palindrome is a word that can be reversed, and still remain the same.
     * <p>
     * Example: MOM, DAD, MADAM, RACECAR
     * <p>
     * Create a method to check if any given String is a palindrome or not.
     */
    static boolean isPalindrome(String st)
    {
        int leng = st.length();
        String rev = "";
        for (int i = leng - 1; i >= 0; i--) {
            rev = rev + st.charAt(i);
        }
        System.out.println("Reverse of " + st + " is : " + rev);
        if (st.equals(rev))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) {
        // Implement here
        Scanner stdin = new Scanner(System.in);
        System.out.println("Please enter a word to test Palindrome.");
        String str = stdin.next();
        boolean x = isPalindrome(str);
        System.out.println("\n=========**********======\n");
        if(x == true)
        {
            System.out.println("Your provided word is 'Palindrome'");
        }
        else
        {
            System.out.println("Your provided word is not 'Palindrome'");
        }
    }
}