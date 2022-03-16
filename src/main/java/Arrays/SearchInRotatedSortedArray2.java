package Arrays;


//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class SearchInRotatedSortedArray2 {

    public boolean search(int[] nums, int target) {

        if(nums== null || nums.length == 0)
            return false;

        int l =0, r = nums.length -1;

        while(l <= r){
            int mid = (l + r) /2;
            if(nums[mid] == target)
                return true;
            else{
                if(nums[l] < nums[mid]){
                    if(target > nums[mid] || target < nums[l])
                        l = mid + 1;
                    else
                        r = mid - 1;
                }else if(nums[l] > nums[mid]){
                    if(target >= nums[mid] && target <= nums[r])
                        l = mid + 1;
                    else
                        r = mid -1;
                }else{
                    l++;
                }
            }

        }

        return false;

    }


}
