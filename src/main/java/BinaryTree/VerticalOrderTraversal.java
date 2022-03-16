package BinaryTree;

import javafx.util.Pair;

import java.util.*;

//https://leetcode.com/problems/binary-tree-vertical-order-traversal/

public class VerticalOrderTraversal {




 public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }


    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<TreeNode>> map = new TreeMap<>();
        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;

        Queue<Pair<Integer,TreeNode>> q = new LinkedList<>();
        q.offer(new Pair<Integer, TreeNode>( 0, root));
        //dfs(root, map, 0);

        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                Pair<Integer, TreeNode> p = q.poll();

                TreeNode node = p.getValue();
                int level = p.getKey();

                map.putIfAbsent(level, new ArrayList<TreeNode>());
                map.get(level).add(node);

                if(node.left != null){
                    q.offer(new Pair<Integer, TreeNode>( level -1, node.left));
                }
                if(node.right != null){
                    q.offer(new Pair<Integer, TreeNode>( level +1, node.right));
                }

                size--;
            }
        }

        if(map.size() == 0)
            return result;


        for(Integer key : map.keySet()){
            List<Integer> t = new ArrayList<>();
            for(TreeNode n : map.get(key)){
                t.add(n.val);
            }
            result.add(t);
        }

        return result;

    }


}