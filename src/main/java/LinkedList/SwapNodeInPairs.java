package LinkedList;

//https://leetcode.com/problems/swap-nodes-in-pairs/

public class SwapNodeInPairs {

    class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next ==null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next;


        ListNode prev = null;

        while(fast.next != null)
        {
            ListNode t = fast.next;
            fast.next = slow;
            slow.next = t;
            if(prev == null)
                head = fast;
            else{
                prev.next = fast;
            }

            prev = slow;
            slow = t;
            if( t.next != null)
                fast = t.next;
            else
                return head;

        }

        ListNode t = fast.next;
        fast.next = slow;
        slow.next = t;
        if(prev == null)
            head = fast;
        else{
            prev.next = fast;
        }

        return head;




    }
}
