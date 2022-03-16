package Tree;

/**
 * Created by m655222 on 5/25/2017.
 */
/**
 * Created by m655222 on 5/23/2017.
 */
public class BinarySearchTreeTest {

    public static void main(String arg[]){

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(9);
        bst.insert(18);
        bst.insert(12);
        bst.insert(15);
        bst.insert(13);
        bst.insert(8);
        bst.insert(4);
        bst.insert(2);

        BinarySearchTree.Node n = bst.lookup(8);
        System.out.println("NODE VALUE ........ " + n.getValue());
        System.out.println("NODE LEFT VALUE........ " + (n.getLeft() != null ?
                n.getLeft().getValue(): 0));
        System.out.println("NODE RIGHT VALUE ........ " + (n.getRight() != null ?
                n.getRight().getValue():0 ));

        BinarySearchTree.Node n2 = bst.lookup(18);
        System.out.println("NODE VALUE ........ " + n2.getValue());
        System.out.println("NODE LEFT VALUE........ " + (n2.getLeft() != null ?
                n2.getLeft().getValue(): 0));
        System.out.println("NODE RIGHT VALUE ........ " + (n2.getRight() != null ?
                n2.getRight().getValue():0 ));

        bst.printInOrder();
        System.out.println();
        bst.printPostOrder();

    }

}
