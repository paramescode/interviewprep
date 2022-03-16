package Design;

import java.util.Map;
import java.util.HashMap;

public class LRUDDL {

    class Node {
        int key;
        int value;

        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.value = val;
        }
    }

    class DLL{

        int size;
        Node head;
        Node tail;

        DLL(){
            head= new Node(0,0);
            tail = new Node(0,0);

            head.next = tail;
            head.prev = tail;
            tail.next = head;
            tail.prev = head;
            size =0;
        }

        public void addHead(Node node){
            Node next = head.next;
            node.next = next;
            node.prev = head;
            next.prev = node;
            head.next = node;
            size++;

        }

        public void removeNode(Node node){

            Node next = node.next;
            Node prev = node.prev;
            prev.next = next;
            next.prev = prev;
            size--;
        }

        public void removeTail(){
            removeNode(tail.prev);
        }
    }

    Map<Integer, Node> map ;
    DLL list ;
    int capacity;
    LRUDDL(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        list = new DLL();
    }

    public int get(int key){
        Node node = map.get(key);
        if(node == null)
            return -1;

        list.removeNode(node);
        list.addHead(node);
        return node.value;
    }

    public void put(int key, int value){
        if(this.capacity == 0)
            return;

        Node node = new Node(key, value);
        Node curr = map.get(key);
        if(curr != null){
            list.removeNode(curr);
            list.addHead(curr);
            curr.value = value;
        }else{
            list.addHead(node);
            map.put(key, node);
        }

        if(list.size > capacity){
            Node lastNode = list.tail.prev;
            map.remove(lastNode.key);
            list.removeTail();
        }
    }

    public static void main(String[] args) {
        LRUDDL lruddl = new LRUDDL(2);
        lruddl.put(1,1);
        lruddl.put(2,2);
        System.out.println(lruddl.get(1));
        lruddl.put(3,3);
        System.out.println(lruddl.get(2));
        lruddl.put(4,4);
        System.out.println(lruddl.get(1));
        System.out.println(lruddl.get(3));
        System.out.println(lruddl.get(4));
    }

}
