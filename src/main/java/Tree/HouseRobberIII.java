package Tree;

//https://leetcode.com/problems/house-robber-iii/

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:

 Input: [3,2,3,null,3,null,1]

 3
 / \
 2   3
 \   \
 3   1

 Output: 7
 Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

 Example 2:

 Input: [3,4,5,1,3,null,1]

 3
 / \
 4   5
 / \   \
 1   3   1

 Output: 9
 Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */

public class HouseRobberIII {

    public int rob(TreeNode root) {
        int [] res = dfs(root);
        return Math.max(res[0], res[1]);
    }


    private int[] dfs(TreeNode root){

        if(root == null)
            return new int[]{0,0};

        // [0] - node inculded , [1] node not included

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // node inculded, skip the immidiate child but rob childs childs
        //means, node.val + rob(node.left.left)  + rob(node.left.right)  + rob(node.right.left) + rob(node.right.right)
        int withNode = root.val + left[1]+ right[1] ;

        // node not inculded, skip the node and include max robbary from both left and right child
        //means, rob(node.left) + rob(node.right)
        int withoutNode = Math.max(left[0] , left[1]) + Math.max(right[0] , right[1]);

        return new int[]{withNode,withoutNode};

    }


}
