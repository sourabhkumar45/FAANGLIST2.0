import java.util.*;

class segregateEvenOdd {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOddFn(ListNode head) {
        ListNode ohead = null;
        ListNode otail = null;
        ListNode ehead = null;
        ListNode etail = null;
        
        ListNode t = head;
        while(t!=null) {
            if(t.val%2==0) {
                if(ehead==null) {
                    ehead = etail = t;
                }else {
                    etail.next = t;
                    etail = etail.next;
                }
            }else {
                    if(ohead==null) {
                        ohead = otail = t;
                    }
                    else {
                        otail.next = t;
                        otail = otail.next;
                    }
                }
            t = t.next;
        }
        etail.next = ohead;
        if(otail!=null)
        otail.next = null;
        return ehead;
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
        ListNode head = segregateEvenOddFn(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}