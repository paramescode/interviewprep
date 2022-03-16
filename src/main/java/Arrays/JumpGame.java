package Arrays;

public class JumpGame {

    //https://leetcode.com/problems/jump-game-ii/submissions/

    public static int jump(int[] nums) {
        if(nums == null || nums.length <= 1 || nums[0] ==0)
            return 0;

        int jumps =0;
        int maxReach = 0;
        int i =0;
        int nextJump = 0;

        while(i < nums.length){

            if(i+nums[i] >= nums.length - 1){
                jumps++;
                break;
            }

            for(int j = i + 1; j <= i + nums[i] ; j++){
                if(j + nums[j] > maxReach){
                    maxReach = j + nums[j];
                    nextJump = j;
                }
            }

            if(i == nextJump){
                jumps = -1;
                break;
            }else
            {
                i = nextJump;
                jumps++;
            }
        }


        return jumps;
    }

    public static void main(String[] args) {
        int [] a = new int[]{2,3,1,1,4};
        System.out.println(jump(a));
    }
}
