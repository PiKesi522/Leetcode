import java.util.*;
public class P78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        if(nums.length == 0){
            return ans;
        }
        dfs(0, nums, new ArrayList<Integer>(), ans);
        return ans;
    }

    public void dfs(int begin, int[] nums, List<Integer> path, List<List<Integer>> ans){
        ans.add(new ArrayList<>(path));
        for(int i = begin; i < nums.length; i++){
            path.add(nums[i]);
            dfs(i + 1, nums, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
