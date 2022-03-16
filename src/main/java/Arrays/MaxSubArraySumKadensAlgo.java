package Arrays;

import java.util.Arrays;

public class MaxSubArraySumKadensAlgo {

    public static int[] maxSumSubArray(int[] arr){
        if(arr == null || arr.length == 0)
            return new int[] {};

        int max_sum = arr[0];
        int start = 0, end =0, s =0, curr_sum =0;

        for(int i =0; i < arr.length ;i++){
            curr_sum += arr[i];

            if(max_sum < curr_sum){
                max_sum = curr_sum;
                start = s;
                end = i;
            }

            if(curr_sum< 0){
                s = i + 1;
                curr_sum =0;
            }
        }

        return Arrays.copyOfRange(arr, start, end + 1);

    }

    public static void main(String[] args) {
        int[] a = new int[]{2,0,2,-3};
        int[] out = maxSumSubArray(a);
        for(int i : out)
            System.out.println(i);
    }
}

