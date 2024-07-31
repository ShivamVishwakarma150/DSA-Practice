import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _52_Unique_Subsets_Leetcode_Subsets_II_Item_On_Level {
       private static List<List<Integer>> ans = new ArrayList<>();

    // Recursive function to generate subsets
    public static void subsets(int currentItem, ArrayList<Integer> unique,
                        HashMap<Integer, Integer> freq, List<Integer> res) {
        // Base case: if we have processed all unique items, add the current subset to the result list
        if (currentItem == unique.size()) {
            ans.add(new ArrayList<>(res));
            return;
        }

        // Get the current unique value
        int val = unique.get(currentItem);

        // Case 1: Do not include the current item in the subset
        subsets(currentItem + 1, unique, freq, res); 

        // Case 2: Include the current item `f` times in the subset, where 0 <= f < freq[val]
        for (int f = 0; f < freq.get(val); f++) {
            res.add(val); // Add the current item to the subset
            subsets(currentItem + 1, unique, freq, res); // Recursive call with next item
        }

        // Backtrack: remove the added items from the subset before returning
        for (int f = 0; f < freq.get(val); f++) {
            res.remove(res.size() - 1);
        }
    }

    // Main function to initialize the unique list and frequency map, and start the subset generation
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> unique = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequency of each element and collect unique elements
        for (int val : nums) {
            if (freq.containsKey(val)) {
                freq.put(val, freq.get(val) + 1); // Increment frequency if already in map
            } else {
                freq.put(val, 1); // Initialize frequency to 1 for a new element
                unique.add(val); // Add to unique elements list
            }
        }

        // Start generating subsets from the 0th index
        subsets(0, unique, freq, new ArrayList<>());
        return ans; // Return the list of unique subsets
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup(nums);
        System.out.println(result); // Print the result
    }
}
