package BinaryTree;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/


public class BinaryTreeFromPreOrderNInorder {

    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder,inorder,0, preorder.length - 1, preorder.length);
    }

    private TreeNode buildTree(int[] pre, int[] inorder, int l, int r, int size){
        if(preIndex >= size || l > r){
            return null;
        }

        TreeNode t = new TreeNode(pre[preIndex++]);

        if(l == r ){
            return t;
        }

        int i;
        for(i = l; i <=r; i++ ){
            if(t.val == inorder[i])
                break;
        }
        //System.out.println(t.val + " " + i + " " + l + " " + r);
        if(i <= r){
            t.left = buildTree(pre, inorder, l, i - 1, size);
            t.right = buildTree(pre, inorder, i+1, r, size);
        }

        return t;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
