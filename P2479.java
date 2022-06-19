import Base.tempNode;
public class P2479 {
    public tempNode insert(tempNode head, int insertVal) {
        tempNode ans = new tempNode(insertVal);
        if(head == null){
            ans.next = ans;
            return ans;
        }else if(head.next == head){
            head.next = ans;
            ans.next = head;
            return head;
        }

        tempNode minHead = null;
        tempNode noob = head;
        while(noob.next != head){
            if(noob.val <= insertVal && insertVal <= noob.children.val){
                ans.next = noob.next;
                noob.next = ans;
                return head;
            }
            if(noob.next.val < noob.val){
                minHead = noob;
            }
        }

        if(insertVal <= minHead.val){
            ans.next = minHead.next;
            minHead.next = ans;
        }else if(noob.val <= insertVal){
            noob.next = ans;
            ans.next = head;
        }

        return head;
    }
}
