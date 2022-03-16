package LinkedList;


//https://leetcode.com/problems/sort-list/


public class SortList {

    class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev =null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);


    }

    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode head = null;
        ListNode tail = null;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                if(head == null){
                    head = l1;
                    tail = head;
                }else{
                    tail.next = l1;
                    tail = tail.next;
                }
                l1 = l1.next;

            }else if(l1.val > l2.val){
                if(head == null){
                    head = l2;
                    tail = head;
                }else{
                    tail.next = l2;
                    tail = tail.next;
                }
                l2 = l2.next;
            }else
            {
                if(head == null){
                    head = l1;
                    tail = head;
                }else{
                    tail.next = l1;
                    tail = tail.next;
                }
                l1 = l1.next;
                //l2 = l2.next;

            }
        }

        while(l1 != null){
            tail.next = l1;
            tail = tail.next;
            l1 = l1.next;
        }

        while(l2 != null){
            tail.next = l2;
            tail = tail.next;
            l2 = l2.next;
        }


        return head;
    }
}
