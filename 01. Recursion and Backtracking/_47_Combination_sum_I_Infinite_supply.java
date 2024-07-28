import java.util.ArrayList;
import java.util.List;

public class _47_Combination_sum_I_Infinite_supply {
      private static List<List<Integer>> res;

    // Recursive function to find combinations with infinite supply
    private static void combinations(List<Integer> ans, int[] candidates, int index, int target) {
        if (target == 0) { // Base case: if the target is reached, add the current combination to the result
            res.add(new ArrayList<>(ans));
            return;
        }

        if (index == candidates.length) { // Negative Base case: if all candidates have been considered, stop recursion
            return;
        }

        int val = candidates[index];

        // Iterate from 0 to as many times as the candidate can fit in the target
        for (int i = 0; target - i * val >= 0; i++) {
            for (int j = 1; j <= i; j++) {
                ans.add(val); // Add the current candidate to the combination
            }

            combinations(ans, candidates, index + 1, target - i * val); // Recur to the next candidate

            for (int j = 1; j <= i; j++) {
                ans.remove(ans.size() - 1); // Remove the added candidate instances to backtrack
            }
        }
    }

    // Main function to find all unique combinations that sum up to target
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        combinations(new ArrayList<>(), candidates, 0, target);
        return res;
    }

    public static void main(String[] args) {
        
        // Example input
        int[] candidates = {2,3,5};
        int target = 8;
        
        // Get the list of combinations
        List<List<Integer>> result = combinationSum(candidates, target);
        
        // Print the result
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
