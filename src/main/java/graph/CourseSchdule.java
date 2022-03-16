package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchdule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> edges = new HashMap<>();

        for (int[] edge : prerequisites) {
            edges.putIfAbsent(edge[0], new ArrayList<>());
            edges.get(edge[0]).add(edge[1]);
        }

        int[] state = new int[numCourses];
        // 0, unvisited, 1 visiting, 2 visited,
        // this is approach has less iteration and better rumtime Vs boolean[] visisted

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, edges, state)) {
                return false;
            }
        }
        return true;
    }

    //DFS
    private boolean hasCycle(int i, Map<Integer,List<Integer>> edges, int[] state) {
        if (state[i] == 2) {
            return false;
        }

        if (state[i] == 1) {
            return true;
        }

        state[i] = 1;
        if (edges.containsKey(i)) {
            for (int child : edges.get(i)) {
                if (hasCycle(child, edges, state)) {
                    return true;
                }
            }
        }
        state[i] = 2;
        return false;
    }


    // this is not topological sort
    private boolean hasCycleUsingBoolean(int i, Map<Integer,List<Integer>> edges, boolean[] visited){

        if(visited[i]){
            return true;
        }

        visited[i] = true;
        for(Integer node : edges.get(i)){
            if(hasCycleUsingBoolean(node, edges,visited)){
                return true;
            }
        }

        visited[i] = false;
        return false;

    }
}
