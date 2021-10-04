import java.util.*;

class reverseInKGroup {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    static ListNode thead = null;
    static ListNode ttail = null;
    public static void addFirst(ListNode node) {
        if(node==null) return;
        if(thead==null) {
           thead = node;
            ttail = node;
            System.out.println("tail set");
        }
        else {
            node.next = thead;
            thead = node;
        }
    }
    public static int getLength(ListNode head) {
        int len = 0;
        ListNode t = head;
        while(t!=null) {
            t = t.next;
            len++;
        }
        return len;
    }
    public static ListNode reverseInKGroupFn(ListNode head, int k) {
       if(head==null || head.next==null || k<=1) return head;

       int len = getLength(head);
       
       ListNode ohead = null;
       ListNode otail = null;
       ListNode curr = head;
       while(len>=k) {
           int tempK = k;
           while(tempK-- > 0) {
               ListNode forw = curr.next;
               curr.next = null;
               addFirst(curr);
               curr = forw;
           }
           if(ohead==null) {
               ohead = thead;
               otail = ttail;
           }else {
               otail.next = thead;
               otail = ttail;
           }
           thead = null;
           ttail = null;
           len= len-k;
       }
       otail.next = curr;
       return ohead;
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

        int k = scn.nextInt();
        h1 = reverseInKGroupFn(h1, k);
        printList(h1);
    }
}