package string_problems;



public class DuplicateWord {

    /**
     * INSTRUCTIONS
     * Write a java program to find duplicate words and the number of occurrences of those words in the given string.
     * Also, find the average length of all the words
     */

    public static void main(String[] args) {
        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";

        // Implement here
        st = st.toLowerCase();
        String[] word = st.split("[ .]+");
        int count;
        for (int i = 0; i < word.length; i++) {
            count = 1;
            for (int j = i + 1; j < word.length; j++) {
                if (word[i].equals(word[j])) {
                    count = count + 1;
                    word[j] = "0";
                }
            }
            if (word[i] != "0" && count > 1) {
                System.out.println(word[i] + " " + count);
            }
        }
        System.out.println("Total words: " + word.length);
    }
}
