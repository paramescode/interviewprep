package LinkedList;

//https://leetcode.com/problems/reverse-nodes-in-k-group/



public class ReverseNodesInKGroup {

    class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if(k <=0 || head ==null)
            return head;

        ListNode tail = head;
        ListNode prev = null;
        int n =k;

        ListNode start = head;
        ListNode end = head;
        ListNode next = head;

        while(next != null ){
            while(k > 0 && next != null){
                end = next ;
                next = next.next;
                k--;
            }

            if(k > 0)
                return head;

            ListNode nextOfEnd = null;

            //if(k == 0 && end != null){
            nextOfEnd = end.next;
            end.next = null;
            //}

            ListNode rev = reverse(start);
            if(prev == null)
                head = rev;
            else
                prev.next = rev;

            prev = start;
            start.next = nextOfEnd;
            start = nextOfEnd;
            next = nextOfEnd;
            k = n;

        }

        return head;

    }

    private ListNode reverse(ListNode head){

        if(head == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
