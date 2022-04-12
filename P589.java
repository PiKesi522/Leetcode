import Base.Node;
import java.util.*;
public class P589 {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Solve(root, ans);
        return ans;
    }

    public void Solve(Node root, List<Integer> ans){
        if(root == null){
            return;
        }
        ans.add(root.val);
        for(Node n : root.children){
            Solve(n, ans);
        }
    }
}
