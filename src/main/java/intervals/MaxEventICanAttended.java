package intervals;

import java.util.*;

//https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/

/*
*Given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. Notice that you can only attend one event at any time d.

Return the maximum number of events you can attend.



Example 1:

Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.

Example 2:

Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4

Example 3:

Input: events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
Output: 4

Example 4:

Input: events = [[1,100000]]
Output: 1

Example 5:

Input: events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
Output: 7

* **/

public class MaxEventICanAttended {

    public static int maxEvents(int[][] events) {

        List<int[]> eventsList = new ArrayList<>();

        for(int [] event : events){
            eventsList.add(event);
        }

        Collections.sort(eventsList, new Comparator<int[]>(){
            public int compare(int []a, int[] b){

                if(a[1] == b[1])
                    return a[0] - b[0];

                return a[1] - b[1]; // sort it end time so we have address the overlaping day
            }
        });

        int res = 0;

        Set<Integer> set = new HashSet<>();
        for(int[] event : eventsList){
            for(int i = event[0]; i <= event[1] ; i++){

                if(!set.contains(i)){
                    set.add(i);
                    res++;
                    break;
                }

            }
        }


        return res;
    }


    public static void main(String[] args) {
        System.out.println(maxEvents(new int[][]{{1,2},{2,3},{3,4},{1,2}}));
    }
}
