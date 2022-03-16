package LinkedList;

public class AddANodeInSortedLinkedList {

    class Node{
        int value;
        Node next;

        Node(int val){
            this.value = val;
        }
    }

    public Node add(Node head, int value){
        Node newNode =  new Node(value);
        if(head == null){
            head = newNode;
            return head;
        }

        Node first = head;
        while(first != null && first.value < value){
            first = first.next;
        }

        if(first == null){ // for adding at the end
            Node node = new Node(value);
            first = node;
            return node;
        }else{ //for adding in the middle
            Node node = new Node(value);
            node.next = first.next;
            first.next = node;
            return node;
        }

    }
}
