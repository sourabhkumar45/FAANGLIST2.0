import java.util.*;

public class removeNthFromLast {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode A = head;
        ListNode B = head;
        int i = 0;
        while(i<n) {
            B = B.next;
            i++;
        }
        if(B==null) {
            head = head.next;
            return head;
        }
        while(B.next!=null) {
            A = A.next;
            B = B.next;
        }
        
         A.next = A.next.next;
         return head;
    }
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode head = createList(n);

        int m = scn.nextInt();
        head = removeNthFromEnd(head, m);
        printList(head);
    }
}
