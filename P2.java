import Base.ListNode;
public class P2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null, tail = null;
        while(l1 != null && l2 != null){
            int sum = (carry + l1.val + l2.val) % 10;
            carry = ((carry + l1.val + l2.val) - sum) / 10;

            l1 = l1.next;
            l2 = l2.next;

            if(head == null){
                head = tail = new ListNode(sum);
            }else{
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
        }

        while(l1 != null){
            int sum = (carry + l1.val) % 10;
            tail.next = new ListNode(sum);
            carry = (carry + l1.val - sum)/10;

            tail = tail.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int sum = (carry + l2.val) % 10;
            tail.next = new ListNode(sum);
            carry = (carry + l2.val - sum)/10;

            tail = tail.next;
            l2 = l2.next;
        }

        if(carry == 1){
            tail.next = new ListNode(1);
        }
        return head;
    }
}
