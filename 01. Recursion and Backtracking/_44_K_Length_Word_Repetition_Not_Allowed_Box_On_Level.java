import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _44_K_Length_Word_Repetition_Not_Allowed_Box_On_Level {

    // Recursive function to generate permutations of length k
    public static void permutation(String res, String ustr, HashSet<Character> unique, int k) {
        if (res.length() == k) { // Base case: if the result's length equals k, print the result
            System.out.println(res);
            return;
        }

        // Iterate through each character in the unique string
        for (Character ch : ustr.toCharArray()) {
            if (unique.contains(ch)) { // Check if the character is still available for use
                unique.remove(ch); // Remove the character from the set to mark it as used
                permutation(res + ch, ustr, unique, k); // Recurse with the updated result string
                unique.add(ch); // Re-add the character to the set for further iterations (Backtracking step)
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // Read the input string
        int k = Integer.parseInt(br.readLine()); // Read the desired length of permutations

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";

        // Create a unique character string and a set of unique characters
        for (char ch : str.toCharArray()) {
            if (!unique.contains(ch)) { // Check if the character is not already added
                unique.add(ch); // Add the character to the set
                ustr += ch; // Add the character to the unique string
            }
        }

        // Generate and print all permutations of the specified length
        permutation("", ustr, unique, k);
    }
}
