package LinkedList;

public class PalindromicLinkedList {



/**
 * Definition for singly-linked list.
 */
    public class ListNode {
      int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }


    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverse = reverseList(slow);
        slow = head;

        while (slow != null && reverse != null)
        {
            if (slow.val != reverse.val)
                return false;
            slow = slow.next;
            reverse = reverse.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}