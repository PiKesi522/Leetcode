import Base.ListNode;

import java.util.ArrayList;
import java.util.List;

public class P23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r){
        if(l == r)
            return lists[l];
        if(l > r)
            return null;

        int mid = (l + r) >> 1;
        return mergeTwoPart(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public static ListNode mergeTwoPart(ListNode a, ListNode b){
        if(a == null || b == null){
            return (a == null ? b : a);
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while(aPtr != null && bPtr != null){
            if(aPtr.val < bPtr.val){
                tail.next = aPtr;
                aPtr = aPtr.next;
            }else{
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }

        if(aPtr == null){
            tail.next = bPtr;
        }else{
            tail.next = aPtr;
        }
        return head.next;
    }
}
