// Item on Level
// Box on choice
// Refer Diagram on Notes :- K-words-4

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _43_K_words_4_repitition_allowed_Item_on_level {
    
    // Recursive function to generate combinations of characters
    public static void generateSelection(String ustr, int cs, int ts, int lc, HashMap<Character, Integer> freq, String asf) {
        if (cs > ts) { // If the selection size reaches the target, print the result
            System.out.println(asf);
            return;
        }

        // Negative Base Case 
        if (lc == ustr.length()) { // If all characters have been considered, end recursion
            return;
        }

        for (int i = lc; i < ustr.length(); i++) {
            char ch = ustr.charAt(i); // get character
            int oldFreq = freq.get(ch); // give character frequency
            if (oldFreq > 0) { // Use the character if it's frequency is still available
                freq.put(ch, oldFreq - 1);
                generateSelection(ustr, cs + 1, ts, i, freq, asf + ch); // Recursively add character to the selection
                freq.put(ch, oldFreq); // Restore the frequency after recursion backtracking step
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // Read the input string
        int k = Integer.parseInt(br.readLine()); // Read the target size for combinations

        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";

        // Build a unique character string and frequency map
        for (char ch : str.toCharArray()) {
            if (!unique.containsKey(ch)) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }

        // Generate and print all combinations of the specified length
        generateSelection(ustr, 1, k, 0, unique, "");
    }
}
