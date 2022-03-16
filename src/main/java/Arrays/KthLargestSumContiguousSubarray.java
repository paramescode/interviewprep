package Arrays;

import java.util.PriorityQueue;

public class KthLargestSumContiguousSubarray {

/**
 * Given an array of integers. Write a program to find the K-th largest sum of contiguous subarray within the array of numbers which has negative and positive numbers.
 https://www.geeksforgeeks.org/k-th-largest-sum-contiguous-subarray/

 Examples:

 Input: a[] = {20, -5, -1}
 k = 3
 Output: 14
 Explanation: All sum of contiguous
 subarrays are (20, 15, 14, -5, -6, -1)
 so the 3rd largest sum is 14.

 Input: a[] = {10, -10, 20, -40}
 k = 6
 Output: -10
 Explanation: The 6th largest sum among
 sum of all contiguous subarrays is -10.

 *
 *
 * */

    public static int kthLargestSumContiguousSubarray(int[] nums, int k){
        if(nums == null || nums.length ==0)
            return 0;
        int[] sum = new int[nums.length +1];

        sum[0] = 0;

        for(int i =1 ; i <= nums.length ;i ++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }


        // priority_queue of min heap
        PriorityQueue<Integer> Q = new PriorityQueue<Integer>();

        // loop to calculate the contigous subarray
        // sum position-wise
        for (int i = 0; i <= nums.length; i++)
        {

            // loop to traverse all positions that
            // form contiguous subarray
            for (int j = i + 1; j <= nums.length; j++)
            {
                // calculates the contiguous subarray
                // sum from j to i index
                int x = sum[j] - sum[i]; // this is equal to summing all the elements staring at j index
                System.out.println(x);
                // if queue has less then k elements,
                // then simply push it
                if (Q.size() < k)
                    Q.add(x);

                else
                {
                    // if the min heap has equal to
                    // k elements then just check
                    // if the largest kth element is
                    // smaller than x then insert
                    // else its of no use
                    if (x > Q.peek())
                    {
                        Q.poll();
                        Q.add(x);
                    }
                }
            }
        }

        // the top element will be then kth
        // largest element since the q size is k
        return Q.poll();



    }

    public static void main(String[] args) {
        int[] a = new int[]{20, -5, -1};
        int res = kthLargestSumContiguousSubarray(a, 3);

        System.out.println(res);
    }
}
