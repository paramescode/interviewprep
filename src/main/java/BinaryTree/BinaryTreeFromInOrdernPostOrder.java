package BinaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

public class BinaryTreeFromInOrdernPostOrder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> inordrMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int p : postorder){
            stack.push(p);
        }

        for(int i =0; i < inorder.length; i ++){
            inordrMap.put(inorder[i], i);
        }

        return buildTree(inordrMap, stack, 0, inorder.length - 1);

    }

    private TreeNode buildTree(Map<Integer, Integer> inordrMap, Stack<Integer> stack, int left, int right){

        if(left > right){
            return null;
        }

        TreeNode t = new TreeNode(stack.pop());

        int i = inordrMap.get(t.val);
        t.right = buildTree(inordrMap, stack, i + 1, right);
        t.left = buildTree(inordrMap, stack, left, i - 1);
        return t;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            val = val;
        }
    }


}
