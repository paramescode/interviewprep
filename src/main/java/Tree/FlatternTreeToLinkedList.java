package Tree;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/


public class FlatternTreeToLinkedList {

    public void flatten(TreeNode root) {

        if(root == null)
            return;

        dfs(root);

    }

    private TreeNode dfs(TreeNode root){

        if(root == null)
            return null;

        if(root.left == null && root.right==null)
            return root;

        TreeNode leftTail = dfs(root.left);
        TreeNode rightTail = dfs(root.right);

        if(leftTail != null){
            TreeNode temp = root.right;
            root.right = root.left;
            leftTail.right = temp;
            root.left = null;
        }

        return rightTail == null ? leftTail : rightTail;
    }


}
