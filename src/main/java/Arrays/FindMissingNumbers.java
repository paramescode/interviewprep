package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindMissingNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length ==0)
            return new ArrayList();

        List<Integer> res = new ArrayList<>();

        for(int i=0; i < nums.length; i ++){
            if(nums[Math.abs(nums[i]) - 1] > 0){
                nums[Math.abs(nums[i]) - 1] = - nums[Math.abs(nums[i]) - 1];
            }
        }

        for(int i=0; i < nums.length; i ++){
            if(nums[i] > 0){
                res.add(i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> res = findDisappearedNumbers(a);
        for(Integer i : res){
            System.out.println(i);
        }

    }
}
