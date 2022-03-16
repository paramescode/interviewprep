package Arrays;
import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {


        if(nums.length==0||nums==null)
            return 0;

        int ans=0, diff=Integer.MAX_VALUE;

        Arrays.sort(nums); // sorting makes it scaning easier
        for(int index=0 ;index < nums.length - 2 ; index++){ // you need 3 elements so stop index at length - 2 for last 3 sum
            int left = index + 1, right = nums.length -1;
            while(left < right){
                int sum = nums[index] + nums[left] + nums[right];
                if(sum < target){
                    left ++;
                }else if(sum > target){
                    right --;
                }else{
                    return sum;
                }

                if(diff > Math.abs(sum - target)){
                    diff = Math.abs(sum - target);
                    ans = sum;
                }
            }

        }

        return ans;

    }
}
