package intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/problems/interval-list-intersections/

/*Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)



Example 1:

Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.

*
* **/

public class IntervelIntersection {

    public static int[][] intervalIntersection(int[][] A, int[][] B) {

        List<int[]> ptList = new ArrayList<>();

        for(int[] a : A){
            ptList.add(a);
        }

        for(int[] b : B){
            ptList.add(b);
        }

        Collections.sort(ptList, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                if(p1[0] == p2[0]){
                    return p1[1] - p2[1];
                }
                return p1[0] - p2[0];
            }
        });

        List<int[]> res= new ArrayList<>();

        List<int[]> mergedIntervals= new ArrayList<>();

        for(int[] a : ptList){
            if(mergedIntervals.isEmpty()){
                mergedIntervals.add(a);
            }else{
                int s = mergedIntervals.size();
                int[] last = mergedIntervals.get(s -1);
                if(last[1] >= a[0]){
                    if(a[0] < last[1] && a[1] <= last[1])
                        res.add(new int[]{a[0], a[1]});
                    else
                        res.add(new int[]{a[0], last[1]});

                    if(last[1] < a[1])
                        mergedIntervals.get(s -1)[1] = a[1];
                }else{
                    mergedIntervals.add(a);
                }
            }

        }

        int[][] intersection = new int[res.size()][2];
        for(int i =0; i < res.size();  i++){
            intersection[i] = res.get(i);
        }

        return intersection;

    }

    public static void main(String[] args) {
        int[][] res = intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}},
                new int[][]{{1,5},{8,12},{15,24},{25,26}});

        for(int[] r : res){
            System.out.println(r[0] +"," + r[1]);
        }
    }
}
