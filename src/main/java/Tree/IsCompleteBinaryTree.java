package Tree;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/check-completeness-of-a-binary-tree/

/*Given a binary tree, determine if it is a complete binary tree.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.



Example 1:

Input: [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.

Example 2:

Input: [1,2,3,4,5,null,7]
Output: false
Explanation: The node with value 7 isn't as far left as possible.

* */

public class IsCompleteBinaryTree {

    public boolean isCompleteTree(TreeNode root) {

        if(root == null)
            return false;

        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean foundNull = false;
        while(!q.isEmpty()){

            TreeNode n = q.poll();
            if(n == null){
                foundNull = true;
            }else{
                if(foundNull)
                    return false;

                q.add(n.left);
                q.add(n.right);
            }

        }

        return true;

        //return dfs(root);

    }
}
