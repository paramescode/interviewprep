package Tree;


//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/


public class FindCommonAncestorBinaryTree {

    //Definition for a binary tree node.

      public class TreeNode {
         int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
      }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || p == null || q == null){
                return null;
            }

            if(hasChild(root.left, p) && hasChild(root.left,  q)){
                return lowestCommonAncestor(root.left, p, q);
            }

            if(hasChild(root.right, p) && hasChild(root.right, q)){
                return lowestCommonAncestor(root.right, p, q);
            }

            return root;
        }

        private boolean hasChild(TreeNode root, TreeNode child){

            if(root == null)
                return false;

            if(root.val == child.val){
                return true;
            }

            if(hasChild(root.left, child))
                return true;
            else
                return hasChild(root.right , child);

        }
    }
}
