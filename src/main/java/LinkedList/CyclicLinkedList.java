package LinkedList;

/**
 * Created by m655222 on 5/26/2017.
 */
public class CyclicLinkedList {

    private Node head;

    public CyclicLinkedList(){
        head = null;
    }

    private class Node {

        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public void add(int value){
        add(head,value);

    }

    private void add(Node node, int value) {
        if(head == null){
            head = new Node(value);
            head.next = head;
            return;
        }

        while(node.next != head) {
            node = node.next;
        }
        node.next = new Node(value);
        node.next.next = head;
    }

    private void printList(){

        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node node = head;
        while(node.next != head){
            System.out.print(node.value);
            node = node.next;
        }
        System.out.print(node.value);
        return;

    }

    public static void main(String args[]){
        CyclicLinkedList cyclicLinkedList = new CyclicLinkedList();

        cyclicLinkedList.add(0);
        cyclicLinkedList.add(1);
        cyclicLinkedList.add(2);
        cyclicLinkedList.add(3);
        cyclicLinkedList.add(4);
        cyclicLinkedList.add(5);
        cyclicLinkedList.add(6);
        cyclicLinkedList.add(7);
        cyclicLinkedList.add(8);
        cyclicLinkedList.add(9);

        cyclicLinkedList.printList();

    }

}
