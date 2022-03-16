package Tree;



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

/*
* */
import java.util.*;

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SerializeDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return root != null ? root.val + "," + serialize(root.left) + ","  +serialize(root.right) : "X";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] elements = data.split(",");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(elements));
        return deserialize(list);
    }

    private TreeNode deserialize(LinkedList<String> queue){
        String value = queue.size() > 0 ? queue.remove() : null;
        if(value == null || value.equals("X"))
            return null;

        int val = Integer.parseInt(value);
        TreeNode node = new TreeNode(val);
        node.left = deserialize(queue);
        node.right = deserialize(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));