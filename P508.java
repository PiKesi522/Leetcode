import Base.TreeNode;
import java.util.*;

public class P508 {
    Map<Integer, Integer> list;
    int max = Integer.MIN_VALUE;
    public int[] findFrequentTreeSum(TreeNode root) {
        list = new HashMap<>();
        dfs(root);
        List<Integer> ans = new ArrayList<>();
        for(int i : list.keySet()){
            if(list.get(i) == max){
                ans.add(i);
            }
        }
//        int n = ans.size();
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    int dfs(TreeNode root){
        if(root == null) return 0;
        int val = root.val + dfs(root.left) + dfs(root.right);
        list.put(val, list.getOrDefault(val, 0) + 1);
        max = Math.max(max, list.get(val));
        return val;
    }
}
