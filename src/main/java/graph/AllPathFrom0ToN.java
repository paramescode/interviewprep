package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/all-paths-from-source-to-target/

/*
*
* Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []]
Output: [[0,1,3],[0,2,3]]
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
*/

public class AllPathFrom0ToN {


    // using backtracking...

    public List<List<Integer>> allPathsSourceTarget1(int[][] graph) {
        List<List<Integer>> result = new ArrayList();
        helper(graph, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int[][] graph, int n, List<Integer> l, List<List<Integer>> result) {
        l.add(n);
        if (n == graph.length - 1)
            result.add(new ArrayList(l));

        for (int b : graph[n])
            helper(graph, b, l, result);

        l.remove(l.size()-1);
    }


    class Node{
        int value;
        List<Integer> path;

        Node(int v, List<Integer> s){
            this.value = v;
            this.path = s;
        }
    }

    //using BFS... less performaent one..
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();

        int[][] a = new int[graph.length][graph.length];

        for(int i=0; i < graph.length; i++){
            //System.out.println("l" + g.length);
            for(int j=0; j < graph[i].length ; j++){
                //System.out.print(i+ " ");
                a[i][graph[i][j]] = 1;
            }
            //System.out.println();
        }

        Queue<Node> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        l.add(0);
        q.add(new Node(0, l));

        while(!q.isEmpty()){
            Node n = q.poll();

            if(n.value == graph.length - 1)
                res.add(new ArrayList<>(n.path));

            for(int i =-0; i < a[n.value].length; i++){
                if(a[n.value][i] ==1){
                    List<Integer> nl = new ArrayList<>(n.path);
                    nl.add(i);
                    q.add(new Node(i , nl));
                }

            }
        }

        return res;
    }
}
