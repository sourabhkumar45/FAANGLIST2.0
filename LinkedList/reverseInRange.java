import java.util.*;

class reverseInRange {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode reverse(ListNode head, int m) {
      
      if(head==null || head.next==null) {
          return head;
      }
      ListNode curr = head;
      ListNode prev = null;
      int t = 1;
      while(t<=m) {
          ListNode temp = curr.next;
          curr.next = prev;
          prev = curr;
          curr = temp;
          t++;
      }
        head.next = curr;
        head = prev;
        return head;
    }
    public static ListNode reverseInRangeFn(ListNode head, int n, int m) {
        if(n==1) {
            head = reverse(head, m);
            return head;
        }
        int k = 1;
        ListNode t = head;
        
        while(k<n-1) {
            t = t.next;
            k++;
        }
        ListNode head2 = t.next;
        ListNode tail1 = t;
        tail1.next = null;
        
        
        //printList(head2);
        head2 = reverse(head2, m-k);
        
        tail1.next = head2;
        
        return head;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
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
        int sz = scn.nextInt();
        ListNode h1 = createList(sz);

        int m = scn.nextInt();
        int n = scn.nextInt();

        h1 = reverseInRangeFn(h1, m, n);
        printList(h1);
    }
}