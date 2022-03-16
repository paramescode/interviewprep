package intervals;

import java.util.LinkedList;
/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:

 Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 Output: [[1,5],[6,9]]

 Example 2:

 Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 Output: [[1,2],[3,10],[12,16]]
 Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 *
 *
 *
 *
 */

//https://leetcode.com/problems/insert-interval/

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        LinkedList<int[]> list = new LinkedList<>();

        int[] toAdd = newInterval;

        int size = 0;
        for(int[] i : intervals){
            if(i[0] > toAdd[1]){ // no overlap , toadd appers before currt;
                list.add(toAdd);
                toAdd = i;
            }else if(i[1] >= toAdd[0]){
                toAdd = new int[]{Math.min(i[0], toAdd[0]), Math.max(i[1], toAdd[1])};
                //System.out.println(toAdd[0] + " "+ toAdd[1]);
            }else{ // no overlap , toadd appers after currt;
                list.add(i);
            }
        }
        list.add(toAdd);

        int[][] res = new int[list.size()][2];
        size =0;
        for(int[] i : list){
            res[size] = i;
            size++;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
