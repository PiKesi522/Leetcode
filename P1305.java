import java.util.*;
import Base.TreeNode;
public class P1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        midTraversal(root1, list1);
        midTraversal(root2, list2);
        List<Integer> ans = mergeSort(list1, list2);
        return ans;
    }

    public void midTraversal(TreeNode t, List<Integer> l){
        if (t != null){
            midTraversal(t.left, l);
            l.add(t.val);
            midTraversal(t.right, l);
        }
    }

    public List<Integer> mergeSort(List<Integer> a, List<Integer> b){
        List<Integer> ans = new ArrayList<>();
        final int alen = a.size(), blen = b.size();
        int pa = 0, pb = 0;
        while(true){
            if(pa == alen){
                ans.addAll(b.subList(pb, blen));
                break;
            }
            if(pb == blen){
                ans.addAll(a.subList(pa, alen));
                break;
            }

            if(a.get(pa) < b.get(pb)){
                ans.add(a.get(pa++));
            }else{
                ans.add(b.get(pb++));
            }
        }
        return ans;
    }
}
