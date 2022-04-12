import Base.Node;
import java.util.*;
public class P429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int layerSize = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < layerSize; i++){
                Node head = queue.remove();
                for(int j = 0; j < head.children.size(); j++){
                    queue.add(head.children.get(j));
                }
                temp.add(head.val);
            }
            ans.add(temp);
        }
        return ans;
    }
}
