package Arrays;

public class LargestSumSubArrayWithAtleast_K_Number {
    //https://www.geeksforgeeks.org/largest-sum-subarray-least-k-numbers/

    public static int largestSubArrayWithAtleastKNumber(int nums[], int k){

        if(nums == null || nums.length ==0)
            return -1;

        if(k > nums.length )
            return -1;

        int result= 0;
        int[] maxSum = new int[nums.length];
        //int curr_max = nums[0];
        maxSum[0]  = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            //curr_max = Math.max(nums[i], curr_max + nums[i]);
            //maxSum[i] = curr_max;
            //curr_max = curr_max + nums[i];
            maxSum[i] = maxSum[i - 1] + nums[i] ;
        }

        int sum = 0;
        for(int i=0 ; i < k ; i ++){
            sum += nums[i];
        }
        //assign the first window count to result
        result = sum;
        for(int i = k; i < nums.length; i++){

            // Compute sum of k elements ending
            // with a[i].
            sum = sum + nums[i] - nums[i - k]; // for k numbers

            // Update result if required
            //comparing the previous window and current window sum
            result = Math.max(result, sum);

            // Include maximum sum till [i-k] also
            // if it increases overall max.
            //assing the current window count
            result = Math.max(result, sum + maxSum[i- k]); // we need this becoz of atleast so need to see the max sum of i - k

        }

        return result;


    }

    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, -10, -3};
        int k = 3;
        System.out.println(largestSubArrayWithAtleastKNumber(arr, k));

        System.out.println();

        arr= new int[] {1, 1, 1, 1, 1, 1};
        k = 2;
        System.out.println(largestSubArrayWithAtleastKNumber(arr, k));

        arr= new int[] {-4, -2, 1, -3};
        k = 2;
        System.out.println(largestSubArrayWithAtleastKNumber(arr, k));



    }
}
