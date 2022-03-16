package Tree;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {

        return isBST(root, null, null);

    }

    private boolean isBST(TreeNode node, Integer min, Integer max){

        if(node == null)
            return true;

        if(max != null && node.val >= max )
            return false;

        if(min != null && node.val <= min)
            return false;

        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);


    }


    public class TreeNode {
    int val;
      TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
