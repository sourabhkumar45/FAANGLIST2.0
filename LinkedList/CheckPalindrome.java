import java.util.*;
public class CheckPalindrome {
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
    public static boolean isPalindrome(ListNode head) {
    
       ListNode mid = middle(head);
        ListNode nHead = mid.next;
        mid.next = null;
        
        nHead = reverse(nHead);
        ListNode t1 = head;
        ListNode t2 = nHead;
        while(t1!=null && t2!=null)
        {
            if(t2.val!=t1.val) {
                return false;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        return true;
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
        System.out.println(isPalindrome(dummy.next));
    }
}
