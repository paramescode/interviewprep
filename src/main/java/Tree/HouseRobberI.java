package Tree;

import java.util.Arrays;

//https://leetcode.com/problems/house-robber/

/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.


* */
public class HouseRobberI {

    //https://leetcode.com/problems/house-robber/solution/

    //watch this viedo : https://www.youtube.com/watch?v=5dRGRueKU3M&list=PLJULIlvhz0rE83NKhnq7acXYIeA0o1dXb
    static int[] sum = null;

    public static int rob(int[] nums) {

        sum = new int[nums.length + 1];

        Arrays.fill(sum, -1);

        return robHouse(nums, nums.length -1);
    }

    private static int robHouse(int[] nums, int i){

        if(i < 0 )
            return 0;

        if(sum[i] != -1)
            return sum[i];

        sum[i] = Math.max(nums[i] + robHouse(nums, i -2), robHouse(nums, i -1));

        return sum[i];

    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));

        System.out.println(rob(new int[]{2,1,1,2}));
    }
}
