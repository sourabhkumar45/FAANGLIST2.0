import java.util.*;

public class reverseList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode head) {
      
      if(head==null || head.next==null) {
          return head;
      }
      ListNode curr = head;
      ListNode prev = null;
      while(curr!=null) {
          ListNode temp = curr.next;
          curr.next = prev;
          prev = curr;
          curr = temp;
      }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = reverse(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
