import java.util.*;

public class FoldOfLL {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
         public static ListNode middle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while(current!=null) {
            ListNode t = current.next;
            current.next = prev;
            prev = current;
            current = t;
        }
        return prev;
    }
    public static void fold(ListNode head) {
        if(head==null || head.next==null) {
            return;
        }
        
        ListNode mid = middle(head);
        ListNode nHead = mid.next;
        nHead = reverse(nHead);
        mid.next = null;
        ListNode cur1 = head;
        ListNode cur2 = nHead;
        while(cur1!=null && cur2!=null) {
            ListNode temp = cur1.next;
            cur1.next = cur2;
            ListNode temp2 = cur2.next;
            cur2.next = temp;
            cur2 = temp2;
            cur1 = temp;
            
        }
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }
        scn.close();
        ListNode head = dummy.next;
        fold(head);
        printList(head);
    }
}
