import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _33_subsets_ii_Leetcode_90 {
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
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums); // Sort so that when we put in Set, if adjacent element is also sorted then there subsets will also same then when we put into Set then duplicates is easily removed 
        // if we dont sort then then adjacent element is not sorted means in that case Set cannot determine if seubsets is same or not because inside array same element can be present in different order.
        

        List<List<Integer>> subset= getSubsets(nums,0);
        Set<List<Integer>> set = new HashSet<>(subset);

        return new ArrayList<>(set);
    }
}
