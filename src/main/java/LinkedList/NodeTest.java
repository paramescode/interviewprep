package LinkedList;

public class NodeTest {

    static class Node{

        int a;

        Node(int a){
            this.a = a;
        }
    }

    public static void main(String[] args) {

        Node a = new Node(10); // lets assume its memory location is 100

        Node b = a; // now b points to mem location 100 too

        a  = new Node(20); // a points to new location 200 and b still points 100

        System.out.println(a.a);

        System.out.println(b.a);





    }
}
