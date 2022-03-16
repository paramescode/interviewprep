package Arrays;

import java.util.HashMap;
import java.util.Map;

public class Contigues_Subarray_Sum_Equals_K {

    public static int solution(int[] nums, int k){

        int ans =0;

        Map<Integer, Integer> seen = new HashMap<Integer, Integer>();

        seen.put(0,1);
        int sum = 0;
        for(int i=0;i < nums.length; i++){
            sum += nums[i];
            int remainder = sum - k;
            if(seen.containsKey(remainder)){
                ans += seen.get(remainder);
            }
            seen.put(sum, seen.getOrDefault(sum , 0) + 1);
        }

        return ans;
    }

    //o(n2)

    public static int solution1(int[] nums, int k){
        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1 && nums[0] == k)
            return 1;

        int[] s = new int[nums.length + 1];

        int ans =0;
        for(int i = 1 ; i <= nums.length; i++){
            s[i] = s[i - 1] + nums[i - 1];
            //System.out.println(s[i]);
        }

        for(int i = 0; i <= nums.length; i++){
            for(int j = i+ 1; j <= nums.length; j++){
                if( s[j] - s[i] == k)
                    ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,1},2));
        System.out.println(solution(new int[]{0,0,0,0,0,0,0,0,0,0},0));
    }
}
