package Tree;

/**
 * Created by m655222 on 5/23/2017.
 */
public class BinarySearchTree {

    private Node root;

     class Node {

        private int value;
        private Node left;
        private Node right;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        private Node(int value){
            this.value = value;
        }

    }

    public Node insert(int value){
        if(root == null){
            root = new Node(value);
            return root;
        }else{
            return insert(root,value) ;
        }

    }

    private Node insert(Node node, int value) {

        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.value){
            node.left = insert(node.left,value);
        }

        if(value > node.value){
            node.right = insert(node.right,value);
        }

        return node ;
    }

    public Node lookup (int value){
        return lookup(root,value);
    }

    private Node lookup(Node node, int value) {
        if(node == null || node.value == value){
            return node;
        }
        Node n = null;
        if(value < node.value){
            n = lookup(node.left,value);
        }
        if(value > node.value){
            n = lookup(node.right,value);
        }
        return n;
    }

    public void delete(int value){
        delete(root, value);

    }

    private Node delete(Node node, int value){

        if(node == null)
            return null;
        if(value < node.value)
            node.left = delete(node.left, value);
        else if(value > node.value)
            node.right = delete(node.right, value);
        else{// deletion on node with no or 1 child
            if(node.left == null)
                return node.right;
            else if(node.right == null)
                return node.left;

            //deletion for node with 2 child
            //Get the inorder successor (smallest in the right subtree)
            node.value = minValue(node.right); // copy the value of inorder successor
            // Delete the inorder successor
            node.right = delete(node.right, node.value); //  the value of deleted node  == the value of inorder successor
        }
        return node;


    }

    private int minValue(Node node){

        int min = node.value;
        while(node.left != null){
            node = node.left;
            min = node.value;
        }
        return min;

    }

    public Node mirror(){
         return mirror(root);
    }

    public Node mirror(Node node){
        if (node == null)
            return node;

        /* do the subtrees */
        Node left = mirror(node.left);
        Node right = mirror(node.right);

        /* swap the left and right pointers */
        node.left = right;
        node.right = left;

        return node;
    }

    public int maxDepth(){
        return maxDepth(root);
    }

    private int maxDepth(Node node) {
        if(node == null)
            return 0;


        if(root.left == null)
            return 1 + maxDepth(root.right);
        if(root.right == null)
            return 1 + maxDepth(root.left);

        int lMin = maxDepth(node.left);
        int rMin = maxDepth(node.right);

        return Math.max(lMin, rMin) + 1;
    }

    public int minDepth(){
        return minDepth(root);
    }

    private int minDepth(Node node) {
        if(node == null)
            return 0;


        if(root.left == null)
            return 1 + minDepth(root.right);
        if(root.right == null)
            return 1 + minDepth(root.left);

        int lMin = minDepth(node.left);
        int rMin = minDepth(node.right);

        return Math.min(lMin, rMin) + 1;
    }

    public void printInOrder(){
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if(node == null)
            return ;
        else{
            printInOrder(node.left);
            System.out.print(node.value);
            printInOrder(node.right);
        }

    }

    public void printPostOrder(){
        printPostOrder(root);
    }

    private void printPostOrder(Node node) {
        if(node == null)
            return ;
        else{
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.value);
        }

    }

    public void printPreOrder(Node node){

        if(node == null)
            return;
        else{
            System.out.print(node.value);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    
}
