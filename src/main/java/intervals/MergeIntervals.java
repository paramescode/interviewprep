package intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/*
*
*Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*
*
* https://leetcode.com/problems/merge-intervals/
*
*
* */

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <=1)
            return intervals;

        LinkedList<int[]> result = new LinkedList<>();

        //sort by start time
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for(int[] interval: intervals){
            if(result.isEmpty() || result.getLast()[1] < interval[0]){
                result.add(interval);
            }else{
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }

        int[][] res = new int[result.size()][2];

        for(int i=0; i < result.size(); i++){
            res[i] = result.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] res = merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});

        for(int [] r : res){
            for(int i: r){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
