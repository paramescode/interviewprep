package Tree;

import java.util.Arrays;

//https://leetcode.com/problems/house-robber-ii/submissions/

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 Example 1:

 Input: [2,3,2]
 Output: 3
 Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 because they are adjacent houses.

 Example 2:

 Input: [1,2,3,1]
 Output: 4
 Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 Total amount you can rob = 1 + 3 = 4.


 *
 * */

public class HouseRobberII {

    int[] sum = null;
    public int rob(int[] nums) {

        if(nums == null || nums.length ==0)
            return 0;

        if(nums.length == 1)
            return nums[0];

        sum = new int[nums.length + 1];

        Arrays.fill(sum, -1);

        //find the max ( including first house , excluding first house)
        // we are doing top down approach here, so we are going from last
        //which means if we rob the last house then we need to skip the 1st house as they are adjacent by being in a circle
        int withRobingFirstHouse =  robHouse(nums, nums.length -1, 1);

        Arrays.fill(sum, -1);

        int withoutRobingFirstHouse =  robHouse(nums, nums.length - 2, 0);

        return Math.max(withRobingFirstHouse, withoutRobingFirstHouse);

    }

    private int robHouse(int[] nums, int i, int lbound){

        if(i < lbound )
            return 0;

        if(sum[i] != -1)
            return sum[i];

        sum[i] = Math.max(nums[i] + robHouse(nums, i -2, lbound), robHouse(nums, i -1, lbound));

        return sum[i];

    }
}
