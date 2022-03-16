package Tree;

//https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/

/*
*Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.

Especially, this path can be either increasing or decreasing. For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid. On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.

Example 1:

Input:
        1
       / \
      2   3
Output: 2
Explanation: The longest consecutive path is [1, 2] or [2, 1].



Example 2:

Input:
        2
       / \
      1   3
Output: 3
Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].

* */
public class LongestConsequtivePathInBinaryTreeII {

    int max = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {

        if(root == null)
            return 0;

        dfs(root);

        return max == Integer.MIN_VALUE ? 1 : max;
    }

    private int[] dfs(TreeNode node){

        if(node == null)
            return new int[]{0,0};


        int[] lc = dfs(node.left);
        int[] rc = dfs(node.right);

        if(node.left != null && node.left.val == node.val + 1)
            lc[0]++;
        else
            lc[0] = 1;


        if(node.left != null && node.left.val == node.val - 1)
            lc[1]++;
        else
            lc[1] = 1;

        if(node.right != null && node.right.val == node.val + 1)
            rc[0]++;
        else
            rc[0] = 1;

        if(node.right != null && node.right.val == node.val - 1)
            rc[1]++;
        else
            rc[1] = 1;

        int[] res = new int[2];
        res[0] = Math.max(lc[0], rc[0]);
        res[1] = Math.max(lc[1], rc[1]);

        max = Math.max(max, Math.max(lc[0] + rc[1] - 1, lc[1] + rc[0] - 1));

        return res;
    }
}
