import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class _39_Unique_Permutations_Leetcode_Permutation2 {

    // List to store the result of unique permutations
    List<List<Integer>> res;

    // Method to generate permutations
    public void permutations(int[] nums, HashMap<Integer, Integer> freq, int currentBox, List<Integer> ans) {
        // Base case: if we have filled all positions (all boxes), add the current permutation to the result
        if (currentBox == nums.length) {
            ArrayList<Integer> temp = new ArrayList<>(ans);
            res.add(temp);
            return;
        }

        // Iterate through each unique number in the frequency map
        for (Integer key : freq.keySet()) {

            int val = freq.get(key);// we get count of occurence of given number
            // ie. because it can be [1,1,2,2,3]
            // here for 1 val is 3 so in this case it can be used as permutation

            // If the current number can still be used in the permutation 
            if (val > 0) {

                // Add the number to the current permutation (place it in the current box)
                ans.add(key);

                // Decrement its count in the frequency map
                freq.put(key, val - 1);
                
                // Recursively generate permutations for the next position (move to the next box)
                permutations(nums, freq, currentBox + 1, ans);

                // Backtrack: remove the last added number (empty the current box)
                ans.remove(ans.size() - 1);

                // Restore the count of the number in the frequency map
                freq.put(key, val);
            }
        }
    }

    // Method to initiate the generation of unique permutations
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Create a frequency map to count occurrences of each number in the input array
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Fill the frequency map
        // ie [1,1,1,2,2] for 1->3 , 2->2
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                int val = freq.get(nums[i]);
                freq.put(nums[i], val + 1);//next time
            } else {
                freq.put(nums[i], 1);// first time
            }
        }

        // Initialize the result list
        res = new ArrayList<>();
        // Start generating permutations with an empty current permutation
        permutations(nums, freq, 0, new ArrayList<Integer>());
        return res;
    }
}
