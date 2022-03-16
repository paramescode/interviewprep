package Arrays;

import java.util.Arrays;

public class ContiguousSubArrayWithMaxSum {

    public static int[] subArrayWithMaxSum(int[] nums){

        if(nums == null || nums.length ==0)
            return null;

        int max_so_far = Integer.MIN_VALUE, curr_sum = 0 , start =0 , end =0, s =0;

        for(int i =0 ; i < nums.length ; i++){

            curr_sum = curr_sum + nums[i];

            if(curr_sum < 0){
                curr_sum = 0;
                s = i + 1;
            }

            if(max_so_far < curr_sum){
                max_so_far = curr_sum;
                start = s;
                end = i;
            }
        }

        return Arrays.copyOfRange(nums, start, end + 1);
    }

    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};

        int[] max_sum = subArrayWithMaxSum(a);
        for (int v: max_sum) {
            System.out.print( v + " ");
        }
        System.out.println();

        a = new int[]{-2, -3, 4, 1};

        max_sum = subArrayWithMaxSum(a);
        for (int v: max_sum) {
            System.out.print( v + " ");
        }
        System.out.println();
        a = new int[]{ 1};

        max_sum = subArrayWithMaxSum(a);
        for (int v: max_sum) {
            System.out.print( v + " ");
        }
        System.out.println();
        a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        max_sum = subArrayWithMaxSum(a);
        for (int v: max_sum) {
            System.out.print( v + " ");
        }
    }
}
