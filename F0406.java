import Base.TreeNode;
public class F0406 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        if(p.right != null){
            successor = p.right;
            while (successor.left != null){
                successor = successor.left;
            }
            return successor;
        }

        TreeNode node = root;
        while (node != null){
            if (node.val > p.val){
                // node比p大，此时p在node的左子树，往左边找
                successor = node;
                node = node.left;
            }else{
                // node比p小，此时p在node的右子树，往右找，不需要更新successor
                node = node.right;
            }
        }
        return successor;
    }
}