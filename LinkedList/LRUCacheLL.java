import java.util.*;

public class LRUCacheLL {
    static class LRUCache {
        class Node {
            int val;
            int key;
            Node prev;
            Node next;
            public Node(int key, int val) {
                this.val = val;
                this.key = key;
                this.prev = null;
                this.next = null;
            }
        }
            Node head;
            Node tail;
            int size;
            int cap;
            HashMap<Integer, Node> map;
        public LRUCache(int capacity) {
            Node h = new Node(-1, 0);
            Node t = new Node(-1, 0);
            this.head = h;
            this.tail = t;
            this.head.next = this.tail;
            this.tail.prev = this.head;
            this.cap = capacity;
            this.size = 0;
            this.map = new HashMap<>();
        }
        
        public int get(int key) {
            if(this.map.containsKey(key)) {
               // System.out.println("Getting value of "+key);
               // System.out.println(this.map);
               // display(this.head);
                Node n = remove(this.map.get(key));
                addToHead(n);
                return this.map.get(key).val;
            }
            else {
                 //System.out.println("Did not Getting value of "+key);
                return -1;
            }
        }
        
        public void put(int key, int value) {
            if(this.map.containsKey(key)==true) {
               // System.out.println("putting key of "+key+" "+ value);
                Node n = remove(this.map.get(key));
                n.val = value;
                addToHead(n);
            }
            else {
                if(this.size<this.cap) {
                    // System.out.println("putting key of "+key+" with value of "+ value);
                    Node n = new Node(key, value);
                    addToHead(n);
                    this.map.put(key, n);
                    this.size++;
                }
                else if(this.cap==this.size){
                     //System.out.println("Cache is full, putting key of "+key+" with value of "+ value+ " and removing "+tail.prev.val);
                    Node n = remove(tail.prev);
                    this.map.remove(n.key);
                    n.val = value;
                    n.key = key;
                    addToHead(n);
                   
                    this.map.put(key, n);
                }
            }
        }
        // private void display(Node head) {
        //     Node t = head;
        //     while(t!=null) {
        //         //System.out.print(t.key+"."+t.val+"   ");
        //         t = t.next;
        //     }
        //     System.out.println();
        // }
        private Node remove(Node n) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            n.next = null;
            n.prev = null;
            return n;
        }
        private void addToHead(Node n) {
            Node forw = this.head.next;
            this.head.next = n;
            n.prev = this.head;
            n.next = forw;
            forw.prev = n;
        }
    }
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int capacity = scn.nextInt();
        scn.close();
        LRUCache obj = new LRUCache(capacity);
    }
}