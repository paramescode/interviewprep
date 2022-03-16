package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *A full binary tree is a binary tree where each node has exactly 0 or 2 children.

 Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.

 Each node of each tree in the answer must have node.val = 0.

 You may return the final list of trees in any order.



 Example 1:

 Input: 7
 Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],
 [0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 *
 *
 * */

//https://leetcode.com/problems/all-possible-full-binary-trees/
public class AllPossibleBinaryTree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
         TreeNode(int x) { val = x; }
      }


        public  static Map<Integer, List<TreeNode>> map = new HashMap<>();

        public static List<TreeNode> allPossibleFBT(int N) {

            return allPossibleTrees(N);
        }

        private static List<TreeNode> allPossibleTrees(int N){

            List<TreeNode> res = new ArrayList<>();
            if(N % 2 ==0)
                return res;

            if(N == 1){
                TreeNode t = new TreeNode(0);
                res.add(t);
                return res;
            }

            int total = N -1 ; // excluding root
            int start = 1;

            while(start <= total){
                List<TreeNode> leftSubTrees = null;
                List<TreeNode> rightSubTrees = null;

                if(map.containsKey(start)){
                    leftSubTrees = map.get(start);
                }else{
                    leftSubTrees = allPossibleTrees(start);
                    map.put(start, leftSubTrees);
                }

                if(map.containsKey(total - start)){ // left is calulated above , so tatal - start
                    rightSubTrees = map.get(total - start);
                }else{
                    rightSubTrees = allPossibleTrees(total - start );
                    map.put(total - start, rightSubTrees);
                }

                for(TreeNode l : leftSubTrees){
                    for(TreeNode r : rightSubTrees){
                        TreeNode node = new TreeNode(0);
                        node.left = l;
                        node.right = r;
                        res.add(node);
                    }
                }

                map.put(N, res);

                start += 2; // left child and cright chiled added so + 2?
            }

            return res;

        }

    public static void main(String[] args) {
        List<TreeNode> res = allPossibleFBT(7);
    }

}
