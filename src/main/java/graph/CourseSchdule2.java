package graph;

import java.util.*;

public class CourseSchdule2 {

    // https://leetcode.com/problems/course-schedule-ii/submissions/


    /**There are a total of n courses you have to take, labeled from 0 to n-1.

     Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

     Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

     There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

     Example 1:

     Input: 2, [[1,0]]
     Output: [0,1]
     Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
     course 0. So the correct course order is [0,1] .

     Example 2:

     Input: 4, [[1,0],[2,0],[3,1],[3,2]]
     Output: [0,1,2,3] or [0,2,1,3]
     Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
     courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
     So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
     *
     */

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] resArr = new int[numCourses];

        int[] indegrees = new int[numCourses];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for( int[] course : prerequisites){
            int preCourse = course[1];
            int curCourse = course[0];

            graph.putIfAbsent(preCourse , new ArrayList()); // build the edge ( prevCourse ---- > currCourse)
            graph.get(preCourse).add(curCourse);

            indegrees[curCourse]++; // no of course needed to take curr course
        }

        // topological sort using q


        Queue<Integer> todo = new LinkedList<>();
        // pick all courses with initial indegree as 0
        for (int i = 0; i < numCourses; i++)
            if (indegrees[i] == 0)
                todo.offer(i);

        int k = 0;
        while(!todo.isEmpty()){
            int course = todo.poll();
            resArr[k++] = course;

            //System.out.println(course);

            if(graph.containsKey(course)){
                for(Integer c : graph.get(course)){
                    indegrees[c] --;
                    if(indegrees[c] == 0)
                        todo.offer(c);
                }
            }


        }

        return k == numCourses ? resArr : new int[0];

    }


}
