package Arrays;

import java.util.HashMap;
import java.util.Map;

public class Contigues_Subarray_Sum_Divisible_By_K {
    //o(n^2)
    public static int solution(int[] nums, int K){
        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1 && nums[0] % K == 0)
            return 1;

        int[] s = new int[nums.length + 1];
        for(int i = 1; i <=nums.length; i++){
            s[i] = s[i -1] + nums[i - 1];
        }

        int ans =0;
        for(int i =0 ; i <=nums.length; i++){
            for(int j = i+ 1 ; j <=nums.length; j++){
                int m = s[j] - s[i];
                if( m % K == 0)
                    ans++;
            }
        }

        return ans;

    }

    public static int solution1(int[] nums, int K){
        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1 && nums[0] % K == 0)
            return 1;

        int ans =0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0; i < nums.length;i++){
            sum += nums[i];
            int remainder = sum % K;
            if(remainder < 0)
                remainder += K;
            if(map.containsKey(remainder)){
                ans += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution1(new int[] {4,5,0,-2,-3,1}, 5));
    }
}
