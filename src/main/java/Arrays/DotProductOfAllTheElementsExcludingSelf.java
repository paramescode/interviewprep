package Arrays;

public class DotProductOfAllTheElementsExcludingSelf {

  //Please solve it without division and in O(n).
    //Input:  [1,2,3,4]
  //Output: [24,12,8,6]
    //https://leetcode.com/problems/product-of-array-except-self/discuss/135882/A-Java-solution-with-an-explanation

    //using one array
    public int[] productExceptSelf(int[] nums) {

        int[] out = new int[nums.length];
        out[0] = 1;

        for(int i = 1; i < nums.length; i++){
            out[i] = out[i-1] * nums[i -1];
            System.out.print(out[i]);
        }

        int right = 1;
        for(int i= nums.length - 1; i >=0;i--){
            out[i] = out[i] * right;
            right = right * nums[i];
        }

        return out;
    }

    //using two arrays
    public int[] dotProduct(int nums[]){

        if(nums == null || nums.length == 0){
            throw new IllegalArgumentException("null or empty input is not supported");
        }

        if(nums.length == 1)
            return nums;


        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i = 1; i < nums.length ; i ++){
            left[i] = left[i-1] * nums[i-1];
        }

        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for(int i = nums.length - 2 ; i >=0; i --){
            right[i] = right[i +1] * nums[i +1];
        }
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length ; i ++){
            result[i] = left[i] * right[i];
        }

        return result;

    }

    public static void main(String[] args) {
        DotProductOfAllTheElementsExcludingSelf dotP = new DotProductOfAllTheElementsExcludingSelf();
        int[] nums =  {1,2,3,4};
        int[] res = dotP.dotProduct(nums);

        for(int i =0;i<res.length;i++) {
            System.out.print(res[i] + " ");
        }
    }


}
