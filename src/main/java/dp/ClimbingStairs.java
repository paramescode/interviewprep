package dp;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/climbing-stairs/

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.

 Example 1:

 Input: 2
 Output: 2
 Explanation: There are two ways to climb to the top.
 1. 1 step + 1 step
 2. 2 steps

 Example 2:

 Input: 3
 Output: 3
 Explanation: There are three ways to climb to the top.
 1. 1 step + 1 step + 1 step
 2. 1 step + 2 steps
 3. 2 steps + 1 step


 *
 * */
public class ClimbingStairs {

    Map<Integer, Integer> map = new HashMap<>();
    {
        map.put(0,0);
        map.put(1,1);
        map.put(2, 2);
    }

    public int climbStairs(int n) {

        if(n <=0)
            return 0;

        if(map.containsKey(n))
            return map.get(n);

        int noOfWays =  climbStairs(n -2) + climbStairs(n -1);

        map.put(n, noOfWays);
        return noOfWays;

    }




}
