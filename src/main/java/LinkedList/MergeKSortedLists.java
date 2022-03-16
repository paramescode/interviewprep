package LinkedList;


//https://leetcode.com/problems/merge-k-sorted-lists/


public class MergeKSortedLists {



/**
 * Definition for singly-linked list.
 *
 */
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0)
            return null;

        if(lists.length ==  1)
            return lists[0];

        ListNode head = null;
        head = merge(lists[0], lists[1]);
        int i=2;
        while(i < lists.length){
            head = merge(head, lists[i]);
            i++;
        }

        return head;
    }

    private ListNode merge(ListNode l1, ListNode l2){

        if(l1 == null)
            return l2;

        if(l2 == null)
            return l1;

        ListNode head = null;
        ListNode current = null;

        while(l1 != null || l2 != null){

            if(l1 == null ){
                current.next = l2;
                return head;
            }

            if(l2 == null){
                current.next = l1;
                return head;
            }

            if(l1.val <= l2.val){
                if(head == null){
                    head = new ListNode(l1.val);
                    current = head;

                }else{
                    ListNode n = new ListNode(l1.val);
                    current.next = n;
                    current = current.next;
                }
                l1 = l1.next;

            }else{

                if(head == null){
                    head =  new ListNode(l2.val);
                    current = head;
                }else{
                    ListNode n = new ListNode(l2.val);
                    current.next = n;
                    current = current.next;
                }
                l2 = l2.next;
            }

        }


        return head;
    }
}