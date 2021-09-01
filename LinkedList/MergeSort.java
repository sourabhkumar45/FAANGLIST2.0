import java.util.*;

public class MergeSort {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode middle(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode merge(ListNode l1, ListNode l2) {
        if(l1==null || l2==null) {
            return l1==null?l2:l1;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode c1 = l1;
        ListNode c2 = l2;
        while(c1!=null && c2!=null) {
            if(c1.val<=c2.val) {
                prev.next = c1;
                c1 = c1.next;
            }
            else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
        prev.next = c1==null?c2:c1;
        return dummy.next;
        
    }
    public static ListNode mergeSort(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode mid = middle(head);
        ListNode nHead = mid.next;
        mid.next = null;
        ListNode h1 = mergeSort(head);
        ListNode h2 = mergeSort(nHead);
        return merge(h1, h2);
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
        ListNode h1 = createList(n);

        ListNode head = mergeSort(h1);
        printList(head);
        scn.close();
    }
}
