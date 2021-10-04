import java.util.*;
public  class AddLists {
    public static Scanner scn = new Scanner(System.in);
     public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
   public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
    l1 = reverse(l1);
    l2 = reverse(l2);
    ListNode t1 = l1;
    ListNode t2 = l2;
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    
    int carry = 0;
    while(t1!=null || t2!=null) {
        int ans = 0;
        if(t1!=null) {
            ans+=t1.val;
            t1 = t1.next;
        }
        if(t2!=null) {
            ans+=t2.val;
            t2 = t2.next;
        }
       
        ans = ans + carry;
        carry = ans/10;
        ans = ans%10;
        ListNode node = new ListNode(ans);
        prev.next = node;
        prev = prev.next;
        
    }
    if(carry!=0) {
        ListNode node = new ListNode(carry);
        prev.next = node;
        prev = prev.next;
    }
   return reverse(dummy.next);
    
}
   public static void printList(ListNode node) {
    while (node != null) {
        System.out.print(node.val + " ");
        node = node.next;
    }
}


public static ListNode makeList(int n) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while (n-- > 0) {
        prev.next = new ListNode(scn.nextInt());
        prev = prev.next;
    }

    return dummy.next;
}

public static void main(String[] args) {
    ListNode head1 = makeList(scn.nextInt());
    ListNode head2 = makeList(scn.nextInt());

    ListNode ans = addTwoNumbers(head1, head2);
    printList(ans);
}
}
