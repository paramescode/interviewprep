package BinaryTree;

import java.util.Comparator;
import java.util.Arrays;

public class BTree {
    /*
    *

       Order(m) of B-tree defines (max and min) no. of children for a particular node.

        Degree(t) of B-tree defines (max and min) no. of keys for a particular node. Degree is defined
        as minimum degree of B-tree.

        A B-tree of order m : All internal nodes except the root have at most m nonempty children and
        at least ⌈m/2⌉ nonempty children.

        A B-tree of (minimum) degree t :

                each node has at most 2t-1 keys
                if node is not root, it has at least t-1 keys.
                // Key : t - 1 >= noOfKeys <= 2t - 1;
                // children : t >= noOfChild <= 2t
    *
    *
    *
    * */

    // Default to 2-3 Tree , minchild - maxchild
    private int minKeySize = 1;
    private int minChildrenSize = minKeySize + 1; // 2
    private int maxKeySize = 2 * minKeySize; // 2
    private int maxChildrenSize = maxKeySize + 1; // 3

    private Node root = null;
    private int size = 0;


    public BTree() { }

    /**
     * Constructor for B-Tree of ordered parameter. Order here means minimum
     * number of keys in a non-root node.
     *
     * @param order
     *            of the B-Tree.
     */
    public BTree(int order) {
        this.minKeySize = order;
        this.minChildrenSize = minKeySize + 1;
        this.maxKeySize = 2 * minKeySize;
        this.maxChildrenSize = maxKeySize + 1;
    }

    public boolean insert(int value){
        if(root == null){
            Node node = new Node(null,this.maxKeySize, this.maxChildrenSize);
            node.addKey(value);
            root = node;
        }else{

            Node node = root;
            while(node != null){
                if(node.numberOfChildren() == 0){
                    node.addKey(value);
                    if(node.numberOfKeys() <= maxKeySize)
                        break;

                    split(node);
                    break;

                }

                //left
                int less = node.getKey(0);
                if(value < less){
                    node = node.getChild(0);
                    continue;
                }

                //right
                int maxOfKey = node.numberOfKeys();
                int lastIndex = maxOfKey - 1 ;
                int larger = node.getKey(lastIndex);
                if(value > larger){
                    node = node.getChild(lastIndex);
                    continue;
                }

                //search in middle node
                for(int i =1  ; i < node.numberOfKeys() ; i ++){
                    int prev = node.getKey(i -1);
                    int next = node.getKey(i);
                    if(value > prev && value < next){
                        node = node.getChild(i);
                        break; // exit the for loop and continue
                    }

                }

            }

        }

        size ++;
        return true;


    }

    private void split(Node nodeToBeSplited) {

        Node node = nodeToBeSplited;
        int medianIndex = node.numberOfKeys() / 2 ;
        int medianValue = node.getKey(medianIndex);

        //left side
        Node left = new Node(null, maxKeySize, maxChildrenSize);
        for(int i= 0; i < medianIndex ; i ++){
            left.addKey(node.getKey(i));
        }

        if(node.numberOfChildren() > 0){
            for(int i = 0; i < medianIndex ; i++){
                left.addChild(node.getChild(i));

            }

        }

        //right side
        Node right = new Node(null, maxKeySize,maxChildrenSize);
        for(int j= medianIndex + 1; j < node.numberOfKeys() ; j++){
                right.addKey(node.getKey(j));
        }

        if(node.numberOfChildren() >0){
            for(int j = medianIndex +1 ; j < node.numberOfChildren(); j ++){
                right.addChild(node.getChild(j));
            }

        }

        if(node.parent == null){
            Node parent = new Node(null, maxKeySize,maxChildrenSize);
            left.parent = parent;
            right.parent = parent;
            parent.addKey(medianValue);
            parent.addChild(left);
            parent.addChild(right);
            root = parent;

        }else{
            Node parent = node.parent;
            parent.addKey(medianValue);
            parent.removeChild(node);
            parent.addChild(left);
            parent.addChild(right);
            if(parent.numberOfKeys() > maxKeySize)
                split(parent);

        }


    }


    private static class Node {

        private int [] keys = null;
        private int keysSize = 0;
        private Node [] children = null;
        private int childrenSize = 0;
        private Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node arg0, Node arg1) {
                return arg0.getKey(0) - (arg1.getKey(0));
            }
        };

        protected Node parent = null;

        private Node(Node parent, int maxKeySize, int maxChildrenSize) {
            this.parent = parent;
            this.keys =  new int[maxKeySize + 1];
            this.keysSize = 0;
            this.children = new Node[maxChildrenSize + 1];
            this.childrenSize = 0;
        }

        private int getKey(int index) {
            return keys[index];
        }

        private int indexOf(int value) {
            for (int i = 0; i < keysSize; i++) {
                if (keys[i] == (value)) return i;
            }
            return -1;
        }

        private void addKey(int value) {
            keys[keysSize++] = value;
            Arrays.sort(keys, 0, keysSize);
        }

        private int removeKeyByValue(int value) {
            int removed = 0;
            boolean found = false;
            if (keysSize == 0) return 0;
            for (int i = 0; i < keysSize; i++) {
                if (keys[i] == (value)) {
                    found = true;
                    removed = keys[i];
                } else if (found) {
                    // shift the rest of the keys down, hits by next iteration
                    keys[i - 1] = keys[i];
                }
            }
            if (found) {
                keysSize--;
                keys[keysSize] = 0;
            }
            return removed;
        }

        /*private int removeKeyByIndex(int index) {
            if (index >= keysSize)
                return 0;
            int value = keys[index];
            for (int i = index + 1; i < keysSize; i++) {
                // shift the rest of the keys down
                keys[i - 1] = keys[i];
            }
            keysSize--;
            keys[keysSize] = 0;
            return value;
        }*/

        private int numberOfKeys() {
            return keysSize;
        }

        private Node getChild(int index) {
            if (index >= childrenSize)
                return null;
            return children[index];
        }

       /* private int indexOf(Node child) {
            for (int i = 0; i < childrenSize; i++) {
                if (children[i].equals(child))
                    return i;
            }
            return -1;
        }*/

        private boolean addChild(Node child) {
            child.parent = this;
            children[childrenSize++] = child;
            Arrays.sort(children, 0, childrenSize, comparator);
            return true;
        }

        private boolean removeChild(Node child) {
            boolean found = false;
            if (childrenSize == 0)
                return found;
            for (int i = 0; i < childrenSize; i++) {
                if (children[i].equals(child)) {
                    found = true;
                } else if (found) {
                    // shift the rest of the keys down
                    children[i - 1] = children[i];
                }
            }
            if (found) {
                childrenSize--;
                children[childrenSize] = null;
            }
            return found;
        }

        /*private Node removeChildByIndex(int index) {
            if (index >= childrenSize)
                return null;
            Node value = children[index];
            children[index] = null;
            for (int i = index + 1; i < childrenSize; i++) {
                // shift the rest of the keys down
                children[i - 1] = children[i];
            }
            childrenSize--;
            children[childrenSize] = null;
            return value;
        }*/

        private int numberOfChildren() {
            return childrenSize;
        }

    }



}
