import java.util.Scanner;

public class UnfoldOfLL {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
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
    public static void unfold(ListNode head) {
        if(head==null || head.next==null) return;
        
        ListNode c1 = head;
        ListNode c2 = head.next;
        ListNode nHead = c2;
        while(c1.next!=null && c2.next!=null) {
            c1.next = c1.next.next;
            c1 = c1.next;
            c2.next = c2.next.next;
            c2 = c2.next;
        }
        nHead = reverse(nHead);
        c1.next = nHead;
        
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
        unfold(head);
        printList(head);
    }
}
