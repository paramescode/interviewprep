package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class printBoundaryOfTree {


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;


        TreeNode(int x) {
            val = x;
        }

    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        res.add(root.val);

        if (root.left == null && root.right == null)
            return res;

        printLeft(root.left, res);

        printBottom(root.left, res);
        printBottom(root.right, res);


        printRight(root.right, res);

        return res;

    }

    private void printLeft(TreeNode node, List<Integer> res) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            return;
        }

        res.add(node.val);

        if (node.left == null)
            printLeft(node.right, res);
        else
            printLeft(node.left, res);

    }

    private void printBottom(TreeNode node, List<Integer> res) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }

        printBottom(node.left, res);
        printBottom(node.right, res);
    }

    private void printRight(TreeNode node, List<Integer> res) {

        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            return;
        }
        if (node.right == null)
            printRight(node.left, res);
        else
            printRight(node.right, res);

        res.add(node.val);

    }
}