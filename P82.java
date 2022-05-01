import Base.ListNode;
public class P82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode ans = new ListNode(0,head);
        ListNode p = ans;
        while (p.next != null && p.next.next != null){
            if(p.next.val == p.next.next.val){
                int x = p.next.val;
                while (p.next != null && p.next.val == x){
                    p.next = p.next.next;
                }
            }else {
                p = p.next;
            }
        }
        return ans.next;
    }
}
