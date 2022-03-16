package intervals;

import sun.jvm.hotspot.utilities.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/problems/employee-free-time/

/*
*We are given a list schedule of employees, which represents the working time for each employee.

Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

(Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.



Example 1:

Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation: There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.

Example 2:

Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]

* **/

public class EmployeesFreeTime {

    static class Interval{
        int start;
        int end;

        public Interval(int s, int e){
            this.start  = s;
            this.end = e;
        }
    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> flatSchdules = new ArrayList<>();
        for(List<Interval> i : schedule){
            flatSchdules.addAll(i);
        }

        Collections.sort(flatSchdules, new Comparator<Interval>(){

            public int compare(Interval i1, Interval i2){

                if(i1.start == i2.start){
                    return i1.end - i2.end;
                }

                return i1.start - i2.start;
            }
        });

        List<Interval> mergedSchdules = new ArrayList<>();

        for(Interval i : flatSchdules){
            if(mergedSchdules.isEmpty()){
                mergedSchdules.add(i);
                continue;
            }

            int lastIndex = mergedSchdules.size() - 1;
            Interval lastS = mergedSchdules.get(lastIndex);
            if(lastS.end >= i.start){
                if(lastS.end < i.end)
                    lastS.end = i.end;
            }else{
                mergedSchdules.add(i);
            }

        }

        List<Interval> res = new ArrayList<>();

        for(int i=0; i< mergedSchdules.size() - 1; i++){
            Interval rest = new Interval(mergedSchdules.get(i).end, mergedSchdules.get(i+1).start);
            res.add(rest);
            //System.out.println(mergedIn.start + " : " + mergedIn.end);

        }


        return res;

    }

    public static void main(String[] args) {

    }
}
