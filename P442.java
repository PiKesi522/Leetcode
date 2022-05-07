import java.util.*;
public class P442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int t = Math.abs(nums[i]);
            if(nums[t-1] < 0){
                ans.add(t);
            }else{
                nums[t - 1] *= -1;
            }
        }
        return ans;
    }
}
