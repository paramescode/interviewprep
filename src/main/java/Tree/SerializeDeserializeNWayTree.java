package Tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/

public class SerializeDeserializeNWayTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null)
            return "X";

        String r = root.val +  "," + root.children.size() ;
        for(Node n : root.children){
            r +=  "," + serialize(n);
        }

        System.out.println(r);
        return r;
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.equals("X"))
            return null;

        String[] arr = data.split(",");

        List<String> list = new ArrayList<>(Arrays.asList(arr));

        return deserialize(list);
    }

    private Node deserialize(List<String> list){
        if(list == null || list.size() ==0)
            return null;

        String value = list.remove(0);

        String noOfChildStr = list.remove(0);

        int noOfChilds = Integer.parseInt(noOfChildStr);
        int val = Integer.parseInt(value);

        Node n = new Node(val, new ArrayList<Node>());
        for(int i=0; i < noOfChilds ; i++){
            n.children.add(deserialize(list));
        }

        return n;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));