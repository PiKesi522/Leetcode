import java.util.*;

public class P40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(candidates.length > 0){
            Arrays.sort(candidates);
            dfs(ans, new Stack<>(), candidates, target, 0);
        }
        return ans;
    }

    public void dfs(List<List<Integer>> ans, Stack<Integer> path, int[] candidates, int target, int begin){
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin; i < candidates.length; i++){
            if(target - candidates[i] < 0){
                return;
            }
            if(i > begin && candidates[i] == candidates[i - 1]){
                // **同层不允许存在相同元素**
                continue;
            }
            path.push(candidates[i]);
            dfs(ans, path, candidates, target - candidates[i], i + 1);
            path.pop();
        }
    }
}
