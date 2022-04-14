import java.util.*;
public class P60 {
    public int seq = 0;
    public String getPermutation(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[n];
        int[] list = new int[n];
        List<Integer> path = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list[i] = i + 1;
        }
        dfs(ans, n, list, used, 0, path, k);
        List<Integer> result =  ans.get(k-1);
        StringBuilder sb = new StringBuilder();
        for(Integer i : result)
            sb.append(i);
        return sb.toString();
    }

    public void dfs(List<List<Integer>> ans, int len, int[] list, boolean[] used, int depth, List<Integer> path, int k){
        if(depth == len){
            ans.add(new ArrayList<>(path));
            seq += 1;
            return;
        }

        for(int i = 0; i < len; i++){
            if(!used[i]){
                used[i] = true;
                path.add(list[i]);

                dfs(ans, len, list, used, depth + 1, path, k);
                if(seq == k) return;

                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
