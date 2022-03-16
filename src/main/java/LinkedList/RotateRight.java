package LinkedList;

/**
 *https://leetcode.com/problems/rotate-list/
 * Input: 1->2->3->4->5->NULL, k = 2
 Output: 4->5->1->2->3->NULL
 Explanation:
 rotate 1 steps to the right: 5->1->2->3->4->NULL
 rotate 2 steps to the right: 4->5->1->2->3->NULL

 Input: 0->1->2->NULL, k = 4
 Output: 2->0->1->NULL
 Explanation:
 rotate 1 steps to the right: 2->0->1->NULL
 rotate 2 steps to the right: 1->2->0->NULL
 rotate 3 steps to the right: 0->1->2->NULL
 rotate 4 steps to the right: 2->0->1->NULL
 *
 * */


//https://leetcode.com/problems/rotate-list/
public class RotateRight {

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k ==0)
            return head;

        int size = 0;

        ListNode t = head;
        ListNode tail = head;
        ListNode prev = head;
        while(t != null && t.next != null){
            size++;
            prev = t;
            t = t.next;
        }
        //System.out.println(prev.val);
        size  = size + 1; // count the last node.
        tail = prev.next;

        if(size <= 1)
            return head;

        int n = k > size ?  size - (k % size) : size - k;  // kth node
        //System.out.println(n);

        if(n == 0 || n == size)
            return head;

        t = head;
        while(n > 0 && t != null){
            prev = t;
            t = t.next;
            n--;
            //System.out.println(n);
        }
        //System.out.println(prev.val);
        prev.next = tail.next;
        tail.next = head;
        return t;
    }

    public static void main(String[] args) {

    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
