// A1-> use hashMap  and copy the list and map the nodes in original list to copy list and do one traversal and assign random nodes
// A2 -> refer notes;
// T.C of A2 is O(n) and S.C is O(1)
import java.util.*;

class copyLLWithRandomPointer {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copyRandomList(ListNode head) {
        ListNode curr = head;
        // inserting nodes in between the list
        while(curr!=null) {
            ListNode node = new ListNode(curr.val);
            ListNode forw = curr.next;
            curr.next = node;
            node.next = forw;
            curr = forw;
        }
        // setting up the random pointer in the newly inserted node
        curr = head;
        while(curr!=null) {
            if(curr.random!=null) {
                curr.next.random = curr.random.next;
            }
            else {
                curr.next.random = null;
            }
            curr = curr.next.next;
        }
        // extracting our list from original list
        curr = head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(curr!=null) {
            prev.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            prev = prev.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if(idx != -1) arr[i].random = arr[idx];
        }
        scn.close();
        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}