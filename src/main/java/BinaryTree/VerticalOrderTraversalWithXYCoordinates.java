package BinaryTree;

import java.util.*;

//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/



public class VerticalOrderTraversalWithXYCoordinates {

     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Point{
        int x;
        int y;
        TreeNode node;

        Point(int x, int y, TreeNode n){
            this.x= x;
            this.y = y;
            this.node = n;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root== null)
            return result;
        TreeMap<Integer, List<Point>> map = new TreeMap<>();
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0, root));

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                Point p = queue.poll();
                int x = p.x;
                int y = p.y;
                TreeNode node = p.node;

                map.putIfAbsent(x, new ArrayList<Point>());
                map.get(x).add(p);

                if(node.left != null){
                    queue.offer(new Point(x - 1, y -1, node.left));
                }

                if(node.right != null){
                    queue.offer(new Point(x + 1, y -1, node.right));
                }

                size--;
            }
        }

        for(Integer key : map.keySet()){

            List<Point> points = map.get(key);
            Collections.sort(points, new Comparator<Point>(){
                public int compare(Point p1, Point p2){
                    if(p1.x == p2.x && p1.y == p2.y){
                        return p1.node.val - p2.node.val;
                    }// change the order when coordinates are same

                    return 0;
                }
            });
            List<Integer> t = new ArrayList<>();
            for(Point p : points){
                t.add(p.node.val);
            }

            result.add(t);

        }

        return result;

    }
}