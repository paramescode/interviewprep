package graph;

import java.util.*;

/*
*There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.



Example 1:

Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2



[[2,1,1],[2,3,1],[3,4,1]]
4
2

* */
//https://leetcode.com/problems/network-delay-time/


/// This is Dijikstra algorithm
public class TimeTakenToSendSignalToAllNodes {

   static class Pair{
        int time;
        int dest;

        Pair(int dest, int t){
            this.time = t;
            this.dest = dest;
        }
    }


    public static int networkDelayTime(int[][] times, int N, int K) {
        if(K > N || K <= 0 )
            return -1;

        int res = 0;

        boolean [] visited = new boolean [N + 1];
        visited[0] = true;

        Map<Integer, List<Pair>> map = new HashMap<>();

        for(int[] time : times){
            Pair p = new Pair(time[1], time[2]);
            map.putIfAbsent(time[0], new ArrayList<>());
            map.get(time[0]).add(p);
        }

        PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>(){

            public int compare(Pair p1, Pair p2){
                return p1.time - p2.time;
            }
        });

        q.add(new Pair(K,0));
        int c=0;

        while(!q.isEmpty()){
            Pair p = q.poll();
            if(visited[p.dest])
                continue;

            List<Pair> pairs = map.get(p.dest);
            if(pairs != null){
                for(Pair child : pairs){
                    if(!visited[child.dest]){
                        q.add(new Pair(child.dest, p.time+ child.time));

                        //System.out.println(child.dest +" " + ( p.time+ child.time) );
                    }
                }
            }
            visited[p.dest] = true;
            res = Math.max(res, p.time);
            //System.out.println(p.time);
            c++;
        }

        if(c != N)
            return -1;

        return res;
    }

    public static void main(String[] args) {

       int [][] in= new int[][]{{2,1,1},{2,3,1},{3,4,1}};

       int res = networkDelayTime(in, 4, 2);
        System.out.println(res);
    }
}
