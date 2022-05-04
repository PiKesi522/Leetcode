import Base.ListNode;

public class P92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(right - left == 0 || head == null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode leftPre = dummyHead;
        for(int i = 0; i < left - 1; i++){
            leftPre = leftPre.next;
        }

        ListNode rightNode = leftPre;
        for(int i = 0; i <= right - left; i++){
            rightNode = rightNode.next;
        }
        ListNode leftNode = leftPre.next;
        ListNode rightNext = rightNode.next;

        leftPre.next = null;
        rightNode.next = null;

        reverseLinkedList(leftNode);

        leftPre.next = rightNode;
        leftNode.next = rightNext;

        return dummyHead.next;
    }

    public void reverseLinkedList(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
    }
}
