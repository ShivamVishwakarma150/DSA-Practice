import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _45_K_Length_Word_Repetition_Allowed_BOL {

    // Recursive function to generate permutations of length k with character repetition allowed
    public static void permutation(String res, String ustr, HashMap<Character, Integer> unique, int k) {
        if (res.length() == k) { // Base case: when the result string reaches the desired length, print it
            System.out.println(res);
            return;
        }

        // Iterate through the unique characters in ustr and manage their frequency in the permutation
        for (Character ch : ustr.toCharArray()) {
            int oldFreq = unique.get(ch);
            if (oldFreq > 0) { // Only use characters that are still available (frequency > 0)
                unique.put(ch, oldFreq - 1); // Use the character and decrease its frequency
                permutation(res + ch, ustr, unique, k); // Recurse with the updated result and frequency map
                unique.put(ch, oldFreq); // Restore the character's frequency after recursion (Backtracking step)
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // Read the input string
        int k = Integer.parseInt(br.readLine()); // Read the desired permutation length

        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";

        // Build the unique string (ustr) and character frequency map (unique) from the input
        for (char ch : str.toCharArray()) {
            if (!unique.containsKey(ch)) {
                unique.put(ch, 1); // Add new characters to the map with an initial frequency of 1
                ustr += ch; // Append the unique character to ustr
            } else {
                unique.put(ch, unique.get(ch) + 1); // Increment the frequency for repeated characters
            }
        }

        // Start generating permutations with character repetition allowed
        permutation("", ustr, unique, k);
    }
}
