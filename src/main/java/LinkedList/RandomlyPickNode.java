package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class RandomlyPickNode {

    class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    List<ListNode> list = new ArrayList<>();

    public RandomlyPickNode(ListNode head) {
        ListNode temp= head;
        while(temp != null){
            list.add(temp);
            temp = temp.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int randomIndex = (int) (Math.random() * list.size());
        return list.get(randomIndex).val;
    }
}
