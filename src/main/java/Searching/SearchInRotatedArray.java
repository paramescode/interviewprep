package Searching;

public class SearchInRotatedArray {


    //search in sorted array which rotated at some point
    //and return the index
    //[0,1,2,3,4,5,6,7,8] rotated to --> [4,5,6,7,8,0,1,2,3]
    /***
     * We do a binary search in one pass, where we recursively iterate on one half or the other of the array, until we reach the base case (1 or 2 elements left).

     The key idea is to only look at the upper half of the array to decide if we iterate on it, otherwise we know that we need to iterate on the lower half. Two cases can happen in the upper half:

     The pivot is in the upper half. Example 1: [3,4,5,6,7,8,0,1,2] (7 is the middle point)
     The pivot is not in the upper half. Example 2: [7,8,0,1,2,3,4,5,6] (2 is the middle point)

     How do we know if we are in case 1 or 2? If middle value > end value, then we know the pivot is in the upper half (so that we are in case 1). So in the first example, we can see that 7 (middle) > 2 (end), so it's case 1, whereas in the second example 2 (middle) <= 6 (end), which mean case 2. The first part of the the "if" on lines 6-7 in the code is to check if we are in case 1 or 2.

     Then, if it's case 1, we need to check if our target is either bigger than the middle value or smaller than the end value. Intuitively, it's because this half will contain all the last numbers of the array (the biggest ones) and the starting numbers of the array (the smallest ones).
     If it's case 2, then it's just a regular sorted array and we can just check than our target is bigger than the middle value and smaller than the end value.

     As mentionned before, if neither of those conditions are valid then we know we can recurse on the lower half.

     The return line is a ternary condition that simply checks if the final start or end values are the target, and if not returns -1.

     Runtime
     This code runs in O(log(N)) time, and O(1) space. It runs faster than 100% of Java submission, with memory less than 100%.
     *
     *
     *
     *
     *
     * **/


    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length-1;
        while(end - start > 1){
            int mid = start + (end - start) / 2;
            if((nums[mid] > nums[end] && (target > nums[mid] || target <= nums[end])) ||
                    (nums[mid] <= nums[end] && target > nums[mid] && target <= nums[end])){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[end] == target ? end : nums[start] == target ? start : -1;
    }

    public static int anotherApproach (int[] nums, int target){
        if(nums == null || nums.length ==0){
            return -1;
        }

        int start =0 ; int end = nums.length -1;

        return binarysearch(nums, target, start, end);

    }

    private static int binarysearch(int[] nums, int target, int start, int end) {

        if(nums[start] == target)
            return start;
        else if(nums[end] == target)
            return end;

        if(end - start > 1){
            int mid = start + (end - start) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[start] < nums[mid]){
                if(target >= nums[start] && target <= nums[mid]){
                    return binarysearch(nums, target, start, mid -1);
                }else{
                    return binarysearch(nums, target, mid+1, end);
                }
            }else{
                if(target >= nums[mid] && target <= nums[end]){
                    return binarysearch(nums, target, mid +1,end);
                }else{
                    return binarysearch(nums, target,start, mid-1);
                }
            }
        }

        return -1;



    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,8,0,1,2,3}, 0));
        System.out.println(anotherApproach(new int[]{4,5,6,7,8,0,1,2,3}, 0));
    }


}
