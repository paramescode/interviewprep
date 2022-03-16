package Arrays;

import java.util.HashMap;
import java.util.Map;

import static com.ibm.db2.jcc.am.lm.*;

public class LargestSubArrayWithEqual1s0s {

    public int findMaxLength(int[] nums) {

        //https://leetcode.com/articles/contiguous-array/# , look at 3rd approch
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        int len = 0, sum= 0;
        for(int i=0; i< nums.length;i++){
            if(nums[i] == 1)
                sum+= 1;
            else
                sum+= -1;

            if(map.containsKey(sum)){

                len = Math.max(len, i - map.get(sum));

            }else
                map.put(sum, i);
        }

        return len;
    }

    public static int[] largestSubArrayWithEql1s0s(int [] nums){
         if(nums == null || nums.length <=1 )
             return null;

         int max_len=0, sum= 0 , start_index =0, end_index = 0;
         Map<Integer, Integer> hm = new HashMap<>();

         for(int i = 0; i < nums.length ; i ++){
             nums[i] = nums[i] ==0 ? -1: 1;
         }

         for(int i=0; i < nums.length; i ++){

             sum += nums[i];

             if(sum ==0){
                 max_len = i + 1; // [0,1] i is starting from 0, total 2 elements in array , so max_len = i +1
                 end_index = i;
                 start_index = end_index - max_len + 1;
             }

             if (hm.containsKey(sum )){
                 if(max_len < i - hm.get(sum )){
                     max_len = i - hm.get(sum );
                     end_index = i;
                     start_index = end_index - max_len + 1;
                 }
             }else{
                 hm.put(sum, i);
             }
         }

        for(int i = 0; i < nums.length ; i ++){
            nums[i] = nums[i] == -1 ? 0: 1;
        }

         int[] res = new int[max_len];
         for(int i = start_index ; i <= end_index ; i++)
             res[i - start_index] = nums[i];
         return res;

    }

    public static void main(String[] args) {
        int[]a = new int[]{1,0,1,1,1,0,0};
        int[] res = largestSubArrayWithEql1s0s(a);
        for (int i = 0 ; i < res.length ; i ++)
            System.out.print(res[i] + " ");

        System.out.println();

        a = new int[]{1,0,1};
        res = largestSubArrayWithEql1s0s(a);
        for (int i = 0 ; i < res.length ; i ++)
            System.out.print(res[i] + " ");
    }


}
