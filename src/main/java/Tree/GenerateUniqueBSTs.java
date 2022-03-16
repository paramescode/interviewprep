package Tree;

import java.util.ArrayList;
import java.util.List;

/*
* Given an integer n, generate all structurally unique Tree's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique Tree's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


*
* */

//https://leetcode.com/problems/unique-binary-search-trees-ii/


public class GenerateUniqueBSTs {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {

        if(n ==0){
            List<TreeNode> res = new ArrayList<>();
            return res;
        }

        return dfs(1, n);

    }


    private List<TreeNode> dfs(int start, int end){

        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }

        for(int i =start; i<=end;i++){
            List<TreeNode> leftNodes = dfs(start, i -1);
            List<TreeNode> rightNodes = dfs(i +1, end);
            save(i, leftNodes, rightNodes, res);
        }

        return res;
    }

    private void save(int root, List<TreeNode> leftNodes , List<TreeNode> rightNodes,
                      List<TreeNode> res  ){

        for(int i=0; i< leftNodes.size() ;i++){
            for(int j=0; j < rightNodes.size() ; j++){

                TreeNode rootNode = new TreeNode(root);
                rootNode.left = leftNodes.get(i);
                rootNode.right = rightNodes.get(j);
                res.add(rootNode);
            }
        }
    }
}
