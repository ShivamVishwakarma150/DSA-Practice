import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _42_K_words_2_Repetition_Not_Allowed_Box_as_level {

    // Method to generate combinations of characters
    public static void generateSelection(int i, String ustr, int ssf, int ts, String asf) {
        // Base case: if we have considered all characters
        if (i == ustr.length()) {
            // If the number of selected characters equals the desired size, print the combination
            if (ssf == ts) {
                System.out.println(asf);
                return;
            }
        }

        char ch = ustr.charAt(i);
        // Include the current character in the combination
        generateSelection(i + 1, ustr, ssf + 1, ts, asf + ch);
        // Exclude the current character from the combination
        generateSelection(i + 1, ustr, ssf, ts, asf+"");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Reading input string
        String str = br.readLine();
        
        // Reading the combination length k
        int k = Integer.parseInt(br.readLine());

        HashSet<Character> unique = new HashSet<>();
        StringBuilder ustr = new StringBuilder();

        // Removing duplicates and preparing the unique character string
        for (char ch : str.toCharArray()) {
            if (!unique.contains(ch)) {
                unique.add(ch);
                ustr.append(ch);
            }
        }

        // Generating combinations
        generateSelection(0, ustr.toString(), 0, k, "");
    }
}
