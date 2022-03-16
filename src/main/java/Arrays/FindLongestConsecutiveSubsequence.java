package Arrays;

import java.util.HashSet;

/***'
 *    Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
 Output: 4
 The subsequence 1, 3, 4, 2 is the longest subsequence
 of consecutive elements

 Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
 Output: 5
 The subsequence 36, 35, 33, 34, 32 is the longest subsequence
 of consecutive elements.
 *
 *
 * **/
public class FindLongestConsecutiveSubsequence {

    public static int longestSubSquence(int[] nums){

        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1)
            return 1;

        HashSet<Integer> set = new HashSet<>();
        int ans =0;
        for(int num : nums){
            set.add(num);
        }

        for(int i =0; i < nums.length; i ++){
            if(!set.contains(nums[i] - 1)){ // look the previous element of a[i], to find the start of the seq, for ex,
                                            // if a[i]  =100 then a[i] - 1 = 99, look for it , if its not there then look for
                                            //elements next to it , 101, 102,
                int j = nums[i];
                while(set.contains(j)){
                    j ++;
                }

                ans = ans < j - nums[i]? j - nums[i] : ans; // end of seq - start of seq = length;

            }
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(longestSubSquence(new int[] {1, 100, 101, 102, 103, 200, 2,4,5,3}));
    }
}
