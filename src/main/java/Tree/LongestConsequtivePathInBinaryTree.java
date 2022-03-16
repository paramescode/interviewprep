package Tree;

//https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/

/*
* Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

Example 1:

Input:

   1
    \
     3
    / \
   2   4
        \
         5

Output: 3

Explanation: Longest consecutive sequence path is 3-4-5, so return 3.

Example 2:

Input:

   2
    \
     3
    /
   2
  /
 1

Output: 2

Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
*
*
* */
public class LongestConsequtivePathInBinaryTree {
    int max = Integer.MIN_VALUE;

    public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;

        dfs(root);

        return max == Integer.MIN_VALUE ? 1 : max;
    }

    private int dfs(TreeNode node){

        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null)
            return 1;

        int lc = dfs(node.left);

        int rc = dfs(node.right);


        if(lc > 0 && node.left != null && node.left.val - node.val == 1 ){
            max = Math.max(lc + 1, max);
            return lc + 1;
        }

        if(rc > 0 && node.right != null && node.right.val - node.val == 1 ){
            max = Math.max(rc + 1, max);
            return rc + 1;
        }

        return 1;


    }
}
