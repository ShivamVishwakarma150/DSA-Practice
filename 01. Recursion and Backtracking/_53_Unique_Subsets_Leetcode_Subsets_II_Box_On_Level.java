import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _53_Unique_Subsets_Leetcode_Subsets_II_Box_On_Level {
    
    static List<List<Integer>> ans = new ArrayList<>();

    // Recursive method to generate subsets
    public static void subsets(int lastItem, ArrayList<Integer> unique, HashMap<Integer, Integer> freq, List<Integer> res) {
        // Add the current subset to the list of answers
        ans.add(new ArrayList<>(res));

        // Iterate over the unique items starting from lastItem
        for (int i = lastItem; i < unique.size(); i++) {
            int val = unique.get(i);
            int oldFreq = freq.get(val); // Get the frequency of the current item

            // Only proceed if the item can still be added to the subset
            if (oldFreq > 0) {
                freq.put(val, oldFreq - 1); // Decrease the frequency of the current item
                res.add(val); // Add the current item to the subset

                // Recurse with the updated parameters
                subsets(i, unique, freq, res);

                // Backtrack: remove the last item and restore its frequency
                res.remove(res.size() - 1);
                freq.put(val, oldFreq);
            }
        }
    }

    // Method to initialize data structures and start the recursion
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> unique = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequency of each element and collect unique elements
        for (int val : nums) {
            if (freq.containsKey(val)) {
                freq.put(val, freq.get(val) + 1); // Increment frequency if already present
            } else {
                freq.put(val, 1); // Initialize frequency to 1 for a new element
                unique.add(val); // Add to the unique list
            }
        }

        // Start the recursion with initial parameters
        subsets(0, unique, freq, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup(nums);
        System.out.println(result); // Print the result
    }
}
