package dp;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/min-cost-climbing-stairs/

/**
 *  On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

 Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

 Example 1:

 Input: cost = [10, 15, 20]
 Output: 15
 Explanation: Cheapest is start on cost[1], pay that cost and go to the top.

 Example 2:

 Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 Output: 6
 Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].

 * */

public class MinCostToClimbStairs {


    public int minCostIterative(int cost[]){

        for(int i =2 ;i < cost.length ; i++){
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }

        return Math.min(cost[cost.length -1], cost[cost.length - 2]);
    }

    // recursive... bottom up approch so the halting conditions are n -1 or n -2 as we can
    //move 1 or 2 steps

    Map<Integer, Integer> costMap = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {

        if(cost.length == 1)
            return cost[0];

        if(cost.length == 2)
            return Math.min(cost[0], cost[1]);

        int n = cost.length;

        int costFromStep0 =  findCost(cost,  0);
        int costFromStep1 =  findCost(cost,  1);

        return Math.min(costFromStep0, costFromStep1);

    }

    private int findCost(int cost[], int n ){

        //the halting conditions are n -1 or n -2 as we can move 1 or 2 steps
        if(n == cost.length -1 || n == cost.length -2 )
            return cost[n];

        if(costMap.containsKey(n))
            return costMap.get(n);

        int costByStep =  cost[n] + Math.min(findCost(cost, n + 1 ), findCost(cost, n +2)) ;

        costMap.put(n,costByStep);

        return costByStep;
    }
}
