import Base.TreeNode;

public class P1022 {
    int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    void dfs(TreeNode root, int curVal){
        int newVal = (curVal << 1) + root.val;
        if(root.left != null){
            dfs(root.left, newVal);
        }
        if(root.right != null){
            dfs(root.right, newVal);
        }
        if(root.left == null && root.right == null){
            ans += newVal;
        }
    }
}
