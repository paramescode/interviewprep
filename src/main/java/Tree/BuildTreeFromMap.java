package Tree;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class BuildTreeFromMap {

    public static class Node{
        public Integer val;
        public Node left;
        public Node right;

        public Node(Integer _val){
            val = _val;
        }
    }
    Node root = null;

    public  Node buildTree(Map<Integer, Integer> input){

        Map<Integer, Node> nodes = new HashMap<>();


        if(input == null || input.size() == 0)
            return root;

        for(Map.Entry<Integer, Integer> entry : input.entrySet()){
           buildTree(entry.getKey(), input, nodes);
        }


        return root;

    }

    private  Node buildTree(Integer key, Map<Integer,Integer> input, Map<Integer, Node> nodes){

        if(nodes.containsKey(key))
            return nodes.get(key);

        if(input.get(key).intValue() == 0){
            Node n = new Node(key);
            nodes.put(key, n);
            root = n;
            return n;
        }

        Node parent = buildTree(input.get(key), input, nodes);
        Node child = new Node(key);
        nodes.put(key, child);

        if(parent.left == null)
            parent.left = child;
        else
         parent.right = child;

        return parent;

    }

    public void preOrder(Node node){
        if(node == null)
            return;

        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);

    }


    public static void main(String[] args) {
        Map<Integer, Integer> input = new HashMap<>();
        input.put(1, 0);
        input.put(2, 1);
        input.put(3, 1);
        input.put(4, 2);
        input.put(5, 2);

        BuildTreeFromMap buildTreeFromMap = new BuildTreeFromMap();
        Node root = buildTreeFromMap.buildTree(input);
        buildTreeFromMap.preOrder(root);
    }

}
