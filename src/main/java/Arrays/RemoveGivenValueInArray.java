package Arrays;

public class RemoveGivenValueInArray {

    /**
     * Given nums = [3,2,2,3], val = 3,

     Your function should return length = 2, with the first two elements of nums being 2.

     It doesn't matter what you leave beyond the returned length.
     *
     *
     * Given nums = [0,1,2,2,3,0,4,2], val = 2,

     Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

     Note that the order of those five elements can be arbitrary.

     It doesn't matter what values are set beyond the returned length.
     *
     * **/
    public int removeElement(int[] nums, int val) {

        if(nums == null || nums.length ==0)
            return 0;

        int  j = 0;
        for(int index = 0; index < nums.length ; index ++)
        {
            if(nums[index] != val){
                nums[j] = nums[index];
                j ++;
            }

        }

        return j;

    }



}
