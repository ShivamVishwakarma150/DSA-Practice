import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _46_Combination_sum_II_Finite_Supply_Leetcode {
      private List<List<Integer>> res;

    // Recursive function to find combinations
    private void combinations(List<Integer> ans, HashMap<Integer, Integer> freq,
        ArrayList<Integer> uniqueCoins, int currentCoin, int target) {


        if (target == 0) { // Base case: if the target is reached, add the current combination to the result
            res.add(new ArrayList<>(ans));
            return;
        }

        if (currentCoin == uniqueCoins.size()) { // Negative Base case: if all coins are considered, stop recursion
            return;
        }

        int val = uniqueCoins.get(currentCoin);
        for (int i = 0; i <= freq.get(val); i++) { // Consider 0 to max frequency of the current coin
            if (target - i * val >= 0) { // If adding this number of current coin does not exceed the target
                for (int j = 1; j <= i; j++) {
                    ans.add(val); // Add the current coin to the answer list
                }

                combinations(ans, freq, uniqueCoins, currentCoin + 1, target - i * val); // Recur with the next coin

                for (int j = 1; j <= i; j++) {
                    ans.remove(ans.size() - 1); // Remove the current coin from the answer list (BackTracking step)
                }
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> uniqueCoins = new ArrayList<>();

        // Build a frequency map and a list of unique candidates
        for (int val : candidates) {
            if (!freq.containsKey(val)) {
                freq.put(val, 1);
                uniqueCoins.add(val);
            } else {
                freq.put(val, freq.get(val) + 1);
            }
        }

        res = new ArrayList<>();
        combinations(new ArrayList<>(), freq, uniqueCoins, 0, target);
        return res;
    }

    public static void main(String[] args) {
        _46_Combination_sum_II_Finite_Supply_Leetcode solution = new  _46_Combination_sum_II_Finite_Supply_Leetcode();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> result = solution.combinationSum2(candidates, target);
        System.out.println(result);
    }
}
