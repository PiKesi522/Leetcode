import Base.ListNode;
public class P21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node1 = list1, node2 = list2;
        ListNode head = new ListNode(), node = head;
        if(list1 == null && list2 == null){
            return null;
        }else if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        while(node1 != null && node2 != null){
            if(node1.val > node2.val){
                node.next = new ListNode(node2.val);
                node = node.next;
                node2 = node2.next;
            }else{
                node.next = new ListNode(node1.val);
                node = node.next;
                node1 = node1.next;
            }
        }
        if(node1 != null){
            node.next = node1;
        }else if(node2 != null){
            node.next = node2;
        }
        return head.next;
    }
}
