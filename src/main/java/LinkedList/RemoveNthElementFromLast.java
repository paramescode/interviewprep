package LinkedList;

public class RemoveNthElementFromLast {

    private static class Node{
        int value;
        Node next;

        private Node(int value){
            this.value = value;
        }
    }

    //this is in 2 pass
    public Node removeNthNodeFromLast(Node head, int n){

        if(head == null)
            return null;

        Node dummy = new Node(0);
        dummy.next = head;

        //first find size
        int size=0;
        Node first = head;
        while(first != null){
            size++;
            first= first.next;
        }

        //find the position of the node to be removed
        size = size - n;

        first = dummy; //this will help us stop at previous node of node eing removed
        while(size > 0){
            first = first.next;
            size--;
        }
        first.next = first.next.next;
        return head;

    }

    //in one pass

    public Node removeNthNodeFromLastInOnePass(Node head, int n) {
        if (head == null)
            return null;

        Node dummy = new Node(0);
        dummy.next = head;

        Node first = dummy;
        Node second = dummy;
        //move the first poniter by n+1  position
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        //now move first to the end and secnond from the first to the position of previous element
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }

}
