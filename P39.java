import java.util.*;

public class P39 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if(candidates.length != 0)
            dfs(candidates, target, new Stack<Integer>(), 0);
        return ans;
    }

    public void dfs(int[] candidates, int value, Stack<Integer> path, int begin){
        if(value < 0){
            return;
        }

        if(value == 0){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = begin; i < candidates.length; i++){
            path.push(candidates[i]);
            dfs(candidates, value - candidates[i], path, i);
            path.pop();
        }
    }
}
