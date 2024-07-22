import java.util.HashMap;
import java.util.Scanner;

public class _40_PalindromePermutation_Pepcoding_Version {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        // Input string from user
        String str = scn.next();
        
        // HashMap to store the frequency of each character
        HashMap<Character, Integer> freq = new HashMap<>();
        
        // Fill the frequency map
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            /*

            freq.getOrDefault(ch, 0):
            Checks if the character ch is already in the freq map.
            If it is, returns its current count.
            If it isn't, returns 0.
            
            */

            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            scn.close();
        }

        // Check for characters with odd frequency
        Character oddFreqChar = '0';
        for (Character ch : freq.keySet()) {
            if (freq.get(ch) % 2 == 1) {
                if (oddFreqChar != '0') {
                    // More than one character has an odd frequency, so a palindrome permutation is not possible
                    System.out.println("-1");
                    return;
                }
                oddFreqChar = ch;
            }
        }

        // Initialize a StringBuilder to store the permutation
        StringBuilder permutation = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            permutation.append("0");
        }

        // If the string length is odd, place the odd frequency character in the middle
        if (str.length() % 2 == 1) {
            permutation.setCharAt(str.length() / 2, oddFreqChar);
            freq.put(oddFreqChar, freq.getOrDefault(oddFreqChar, 0) - 1);
        }

        // Generate the palindrome permutations
        generatepw(0, freq, permutation);
    }

    public static void generatepw(int cb, HashMap<Character, Integer> freq, StringBuilder permutation) {
        // Base case: if we have filled half the permutation, print it
        if (cb == permutation.length() / 2) {
            System.out.println(permutation);
            return;
        }

        // Iterate through each character in the frequency map
        for (Character ch : freq.keySet()) {
            if (freq.get(ch) > 0) {

                // Place character at both ends of the current position
                int oldFreq = freq.get(ch);
                freq.put(ch, oldFreq - 2);// because from both end we are taking 2 identical chars/nums

                permutation.setCharAt(cb, ch); // First End
                permutation.setCharAt(permutation.length() - 1 - cb, ch); // Last Indentical End
                
                // Recursively generate permutations for the next position
                generatepw(cb + 1, freq, permutation);
                
                // Backtrack to restore the state for the next iteration
                permutation.setCharAt(cb, '0');
                permutation.setCharAt(permutation.length() - 1 - cb, '0');
                freq.put(ch, oldFreq);
            }
        }
    }
}
