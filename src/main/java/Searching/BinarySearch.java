package Searching;

public class BinarySearch {

    //nums is a sorted array
    //return the index postion of the target if found in the given array
    //else return -1
    public int find(int nums[] , int target){
        if(nums == null )
            return -1;
        if(nums.length < 2){
            if(target == nums[0])
                return 0;
            else
                return -1;
        }

        return binarySearch(nums, target, 0, nums.length - 1);

    }

    private int binarySearch(int[] nums, int target, int start, int end) {

        if(end >= start){

            int mid = start + (end - start) / 2 ;

            if(target == nums[mid]){
                return mid;

            }
            if(target < nums[mid])
                return binarySearch(nums, target, start, mid - 1 );


            return binarySearch(nums, target, mid + 1 , end );
        }
        return -1;


    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;
        System.out.println( binarySearch.find(arr, x) );

    }

}
