import Base.ListNode;

public class P61 {
    public ListNode rotateRight(ListNode head, int k) {
        int size = 1;
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
            size += 1;
        }
        // 指向尾端变成循环链表，同时获知长度
        tail.next = head;
        // 将循环次数取余，减少冗余循环
        k = k % size;

        ListNode root = head;
        for(int i = 0; i < (size - k) - 1; i++){
            head = head.next;
        }
        // 指向新的头部，并切断头部与之前的连接
        root = root.next;
        head.next = null;

        return root;
    }
}
