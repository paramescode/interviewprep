package Arrays;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null )
            return null;

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        backTrack1(results, result , nums, 0);
        return results;
    }
    // will not work when there is a duplicate because of the continue check at line 27
    // so use
    private void backTrack1(List<List<Integer>> list, List<Integer> tempList, int [] nums, int index){
        if(index == nums.length){
            list.add(new ArrayList<>(tempList));
            return;
        }

        for(int i =0;i < nums.length;i++){
            if(tempList.contains(nums[i])) //// will not work when there is a duplicate
                continue;
            tempList.add(nums[i]);
            backTrack1(list, tempList, nums, index+1);
            tempList.remove(tempList.size() - 1);
        }
    }

    //
    //https://medium.com/hackernoon/14-patterns-to-ace-any-coding-interview-question-c5bb3357f6ed
    //BFS
    public static List<List<String>> combinationSsingSubSets(int[] nums){
        if(nums == null || nums.length == 0)
                return null;

        List<List<String>> result = new ArrayList<>();
        List<String> temp  = new ArrayList<>();
        temp.add("e");
        result.add(0,temp);
        for(int i=0; i < nums.length;   i ++){
            temp = result.get(i);
            List<String> t = new ArrayList<>();
            t.addAll(temp);
            for(int j=0; j < temp.size(); j ++){
                t.add(temp.get(j) +" " +nums[i]);
            }
            result.add(i +1,t);
        }

        return result;

    }
    // DFS
    public static List<List<Integer>> permutation(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        perm(nums, 0, result);
        return result;

    }

    private static void perm(int [] nums, int start, List<List<Integer>> result){

        if(start == nums.length){
            List<Integer> t = new ArrayList<>();
            for (Integer i: nums) {
                t.add(i);
            }
            result.add(t);
            return;
        }

        for(int i = start ; i < nums.length ; i ++){
            swap(nums, start, i);
            perm(nums, start + 1, result);
            swap(nums, start, i);
        }
    }

    private static void swap(int[] nums, int start, int i) {

        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
        return;

    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();

        int [] nums = new int[]{1,2,3,4,5};

        List<List<Integer>> results = permutation.permute(nums);
        //results will be !n = 3 * 2 * 1 = 6
        for(List<Integer> list : results){
            for(Integer value : list){
                System.out.print(value + " " );

            }
            System.out.println();
        }

        List<List<String>> result = combinationSsingSubSets(nums);
        //result.stream().forEach(x -> System.out.println(x));

        List<List<Integer>> res = permutation(nums);
        res.stream().forEach(x -> System.out.println(x));
    }



}
