package Arrays.inplace;

/**
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 Output: [5,6,7,1,2,3,4]
 Explanation:
 rotate 1 steps to the right: [7,1,2,3,4,5,6]
 rotate 2 steps to the right: [6,7,1,2,3,4,5]
 rotate 3 steps to the right: [5,6,7,1,2,3,4]


 Input: [-1,-100,3,99] and k = 2
 Output: [3,99,-1,-100]
 Explanation:
 rotate 1 steps to the right: [99,-1,-100,3]
 rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 */
//https://leetcode.com/problems/rotate-array/

public class RotateRight {

    public static void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0|| k == 0)
            return ;

        int lastEle = 0;
        for(int i=0;i < k;i++){
            for(int j=nums.length -1; j > 0; j--){
                if(j == nums.length -1)
                    lastEle = nums[j];
                nums[j] = nums[j -1];
                if(j == 1)
                    nums[j - 1] = lastEle;
            }
        }

        return;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,2,3,4,5,6,7};

        rotate(a, 2);

        for(int n : a){
            System.out.println(n);
        }
        System.out.println("*************");

        a = new int[]{1,2,3,4,5,6,7};

        rotate(a, 3);

        for(int n : a){
            System.out.println(n);
        }
    }
}
