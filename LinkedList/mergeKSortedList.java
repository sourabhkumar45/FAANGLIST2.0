// A1 -> run mergeTwoList k-1 times T.C -> O(Nk^2) where N is the max no. of element in a list
// A2 -> use of divide and conquer which can solve in it O(Nklogk) base 2 which is the bestest
// A3 -> use the Priority Queue and add all the head of the lists and now pop the minimum in PQ and move that head to next and do not push the nulls
//       this can be done in same T.C as of A2 but it is the worst T.C(reason yet to be found).

import java.util.*;
class mergeKSortedList {
    public static Scanner scn = new Scanner(System.in);
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        if(c1==null) {
            prev.next = c2;
        }
        else if(c2==null){
            prev.next = c1;
        }
        return dummy.next;
    }
    public static ListNode mergeKListsHelper(ListNode[] list, int si, int ei) {
        if(si==ei) return list[si];

        if(si>ei) return null;

        int mid = (si+ei)/2;
        ListNode l1 = mergeKListsHelper(list, si, mid);
        ListNode l2 = mergeKListsHelper(list, mid+1, ei);

        return mergeTwoLists(l1, l2);
    }
    public static ListNode mergeKLists(ListNode[] list ) {
        if(list.length==0) return null;

       return mergeKListsHelper(list, 0, list.length-1);
    }
    public static ListNode mergeKListsPQ(ListNode[] list) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> { //a is self 
            return a.val-b.val; // default behaviour of min priority Queue
        });
        for(ListNode l : list) if(l!=null) pq.add(l);

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(pq.size()!=0) {
            ListNode node = pq.remove();

            prev.next = node;
            prev = prev.next;

            if(node.next!=null) {
                pq.add(node.next);
            }
        }
        return dummy.next;
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
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }

        //ListNode head = mergeKLists(list); // A1
        ListNode head = mergeKListsPQ(list); // A2
        printList(head);
      
    }
}
