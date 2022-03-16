package Arrays;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        if(nums == null ){
            return null;
        }

        if(nums.length <=2)
            return new ArrayList();
        Arrays.sort(nums);

        Set<LinkedList <Integer>> set = new HashSet<>();
        for(int i=0 ; i < nums.length - 2; i ++){
            System.out.println("inside for....");
            int l = i + 1;
            int r = nums.length -1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if( sum == 0){
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);

                    set.add(list);
                    l++;
                    r--;
                }else if(sum < 0){
                    l ++;
                }else{
                    r --;
                }
            }

        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(a);
        res.stream().forEach(x-> System.out.println(x));

    }

}
