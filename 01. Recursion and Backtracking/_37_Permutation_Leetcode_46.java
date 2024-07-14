import java.util.ArrayList;
import java.util.List;

public class _37_Permutation_Leetcode_46 {
        public static void permutations(List<List<Integer>> ans,int[] nums,ArrayList<Integer> output){
        if(nums.length==output.size()){
            ans.add(new ArrayList<>(output));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!output.contains(nums[i])){
            output.add(nums[i]);
            permutations(ans,nums,output);
            output.remove(output.size()-1);
            }
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        permutations(ans,nums,new ArrayList<>());

        return ans;
    }
}
