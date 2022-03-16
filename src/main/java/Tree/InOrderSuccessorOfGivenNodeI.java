package Tree;

//https://leetcode.com/problems/inorder-successor-in-bst/



public class InOrderSuccessorOfGivenNodeI {

    TreeNode res = null;
    boolean found = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if(root == null || p == null)
            return null;

        find(root, p);

        return res;
    }

    private void find(TreeNode root, TreeNode p){

        if(root == null)
            return;

        find(root.left, p);

        if(found)
        {
            res = root;
            found = false;
            return;
        }

        if(p.val == root.val)
            found =true;

        find(root.right, p);
    }

    public TreeNode inorderSuccessorIterative(TreeNode root, TreeNode p) {

        if(root == null || p == null)
            return null;

        if(p.right != null){
            TreeNode successor = p.right;
            while(successor.left != null){
                successor = successor.left;
            }
            return successor;
        }

        TreeNode ans = null;

        TreeNode curr = root;
        while(curr.val != p.val){
            if(curr.val < p.val){
                curr  = curr.right;
            }else{
                ans  = curr;
                curr = curr.left;
            }
        }

        return ans;
    }
}
