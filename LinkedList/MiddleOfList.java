
import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode midNode(ListNode head) {
    
        if(head==null)
        return null;
        
        ListNode slow = head, fast = head;
        
        while(fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // if you want to return the second mid when size of 
        // list is even
        // if(fast.next==null)
        // return slow;
        // else
        //     return slow.next;
        return slow;
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
        ListNode head = midNode(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}