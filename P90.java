import java.util.*;
public class P90 {
    List<List<Integer>> ans;
    List<Integer> path;
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.ans = new ArrayList<>();
        this.path = new ArrayList<>();
        this.used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[] nums, int startIndex){
        ans.add(new ArrayList<>(path));
        if(startIndex >= nums.length){
            return;
        }

        for(int i = startIndex; i < nums.length; i++){
            if(i > 0 && nums[i - 1] == nums[i] && !used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, i + 1);
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}
