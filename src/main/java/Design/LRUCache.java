package Design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//https://leetcode.com/problems/lru-cache/submissions/

class LRUCache {

    Map<Integer, ListNode> map = new HashMap();
    LinkedList<ListNode> list = new LinkedList<>();

    int capacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if(node != null){
            list.remove(node);
            list.addFirst(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {

        ListNode newNode = new ListNode(key, value);
        ListNode node = map.get(key);

        if(node != null){
            list.remove(node);
            list.addFirst(node);
            node.val = value;
        }else{
            list.addFirst(newNode);
            map.put(key, newNode);
        }

        if(list.size() > this.capacity){
            ListNode lastNode = list.getLast();
            map.remove(lastNode.key);
            list.removeLast();
            System.out.println(key + " " +lastNode.key);

        }


    }

    class ListNode{
        int val;
        int key;
        ListNode next;
        ListNode(int key, int value){
            this.key = key;
            this.val = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 *
 *              10
 *       5              12
 *   1      5       11       15
 *
 *   sum = 11, true -- 10, 1
 *   sum = 10, true 5,5
 *   sum = 8, false
 *   sum = 13, true
 *
 */

