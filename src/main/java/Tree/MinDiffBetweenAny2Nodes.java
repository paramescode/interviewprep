package Tree;

//https://leetcode.com/problems/minimum-distance-between-bst-nodes/

/*
*Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \
    1   3

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.

* **/

public class MinDiffBetweenAny2Nodes {

    int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {

        dfs(root, null, null);
        return minDiff == Integer.MAX_VALUE ? 0 : minDiff;
    }

    private void dfs(TreeNode node, Integer min, Integer max){

        if(node == null)
            return;

        if(max != null )
            minDiff = Math.min(minDiff, max - node.val);

        if(min != null)
            minDiff = Math.min(minDiff,  node.val - min);

        dfs(node.left, min, node.val);
        dfs(node.right, node.val, max);

    }


}
