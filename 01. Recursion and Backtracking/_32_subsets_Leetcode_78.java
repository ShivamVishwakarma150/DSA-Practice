import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _32_subsets_Leetcode_78 {
        public List<List<Integer>> getSubsets(int[]nums ,int idx){

        if(idx==nums.length){
            List<List<Integer>> base=new ArrayList<>();
            base.add(new ArrayList<Integer>());
            return base;
        }

        List<List<Integer>> lt = getSubsets(nums,idx+1);

        List<List<Integer>> ans=new ArrayList<>();

        // 10,20,30,40
        for(List<Integer> sub:lt){ // 40 X
            ans.add(sub);
        }
        
        
        for(List<Integer> sub:lt){ //40 lena hai
            List<Integer> subset=new ArrayList<Integer>();
            subset.add(nums[idx]);

            for(Integer it:sub){
                subset.add(it);
            }

            ans.add(subset);
        }



        return ans;


    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans= getSubsets(nums,0);

        Set<List<Integer>> set=new HashSet<>(ans);

        return new ArrayList<>(set);

    }
}
