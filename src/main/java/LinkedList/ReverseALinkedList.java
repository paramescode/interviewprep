package LinkedList;

public class ReverseALinkedList {

    static class Node{
        int value;
        Node next ;

         public Node (int value, Node next){
             this.value = value;
             this.next = next;

        }
    }


    public static Node createLinkedList(int size){
        Node head = null;
        // 5->null
        //head = 5 = 5 -> null
        //4->5->null
        //head = 4
        //3->4->5->null
        for(int i = size; i >=0;i --){
            Node node = new Node(i, null);
            node.next = head;
            head = node;
        }

        return head;
    }

    public static Node reverse(Node head){

        Node prev = null;
        Node current = head;
        Node following =  head;

        while(current != null){
            following = following.next;
            current.next = prev;
            prev = current;
            current = following;
        }

        return prev;
    }

    public static void main(String[] args) {
        Node list = createLinkedList(5);
        Node head = list;
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
        list = reverse(list);
        head = list;
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }


    }
}
