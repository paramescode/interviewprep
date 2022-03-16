package intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/problems/minimum-time-difference/

/**
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.

 Example 1:

 Input: ["23:59","00:00"]
 Output: 1

 * */
public class MinTimeDifference {

    public static int findMinDifference(List<String> timePoints) {
        List<Integer> mins = new ArrayList<>();
        for(String time : timePoints){
            String hr[] = time.split(":");
            int min = (Integer.parseInt(hr[0]) * 60) + Integer.parseInt(hr[1]);

            mins.add(min);
        }

        Collections.sort(mins, new Comparator<Integer>(){
            public int compare(Integer i, Integer j){
                return i - j;
            }
        });

        int min = Integer.MAX_VALUE;

        for(int i =1; i< mins.size();i++){
            int d = mins.get(i) - mins.get(i -1);
            if(d < min)
                min = d;
        }

        int corner = mins.get(0) + (1440 - mins.get(mins.size()-1));
        //clock is in a circle , so take the difference between first and last element
        //mins to 24:00 from last element + mins away from 24:00 of first element
        //and take a min between min, corner

        return Math.min(min, corner);
    }

    public static void main(String[] args) {

        List<String> in = new ArrayList<>();
        in.add("23:50");
        in.add("00:50");
        in.add("02:00");

        System.out.println(findMinDifference(in));

    }
}
