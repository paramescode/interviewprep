package Tree;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/

/**
 *Given a non-empty binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

 Example 1:

 Input: [1,2,3]

 1
 / \
 2   3

 Output: 6

 Example 2:

 Input: [-10,9,20,null,null,15,7]

 -10
 / \
 9  20
 /  \
 15   7

 Output: 42


 *
 * */
public class BinaryTreeMaxPathSum {

    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        if(root == null)
            return 0;

        dfs(root);
        return sum == Integer.MIN_VALUE ? 0 : sum;

    }

    private int dfs(TreeNode node){

        if(node == null )
            return 0;

        int lsum = dfs(node.left);
        int rsum = dfs(node.right);

        sum = Math.max(sum, lsum + node.val + rsum);
        sum = Math.max(sum, lsum + node.val );
        sum = Math.max(sum, node.val + rsum);
        sum = Math.max(sum, node.val);

        int nodeMaxToReturn = Math.max(lsum, rsum) + node.val;
        return Math.max(nodeMaxToReturn, node.val);

    }


}
