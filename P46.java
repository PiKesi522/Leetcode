import java.util.*;

public class P46 {
    public List<List<Integer>> permute(int[] nums) {
        final int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(len == 0) return ans;
        dfs(nums, len, 0, new ArrayList<>(), new boolean[len], ans);
        return ans;
    }

    public void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> ans){
        if(depth == len){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < len; i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, ans);

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
