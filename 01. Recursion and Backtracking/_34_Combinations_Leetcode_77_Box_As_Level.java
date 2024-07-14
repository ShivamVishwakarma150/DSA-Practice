import java.util.ArrayList;
import java.util.List;

// Combination Box as Level
public class _34_Combinations_Leetcode_77_Box_As_Level {
    public void combine(List<List<Integer>> combinations, List<Integer> combination,
            int currentBox, int n, int k) {

        if (currentBox == n) {
            if (combination.size() == k) {
                List<Integer> temp = new ArrayList<Integer>(combination);
                combinations.add(temp);
            }
            return;
        }

        combination.add(currentBox+1);
        combine(combinations, combination, currentBox + 1, n, k); // jab ham item le rhe hain
        combination.remove(combination.size()-1);

        combine(combinations, combination, currentBox + 1, n, k); // jab ham item nhi le rhe hain
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        combine(combinations, combination, 0, n, k);

        return combinations;
    }
}
