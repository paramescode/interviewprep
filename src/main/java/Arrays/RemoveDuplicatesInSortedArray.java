package Arrays;

public class RemoveDuplicatesInSortedArray {


    //removes duplicates and returns the size of the non duplicate array
    //and it dose copy the non repeating elements to repeating index
    //operates in the same array and size stays same
    public int removeDuplicates(int[] nums){

        if(nums == null || nums.length ==0)
            return 0;

        int num = 0;
        for(int i = 1; i < nums.length ; i++){
            if(nums[num] < nums[i])
                nums[++num] = nums[i];
        }
        return num + 1;
    }

    private void printArray(int nums[]){
        for (int n: nums) {
            System.out.print( n + " ");
        }
        System.out.println();
        System.out.println("Length of duplicate array " + nums.length );
        System.out.println();

    }

    public static void main(String[] args) {
        RemoveDuplicatesInSortedArray removeDuplicatesInSortedArray = new RemoveDuplicatesInSortedArray();
        int nums[] = new int[]{ 0,1,2,3,4,5};
        removeDuplicatesInSortedArray.printArray(nums);
        int res = removeDuplicatesInSortedArray.removeDuplicates(nums);
        System.out.println("Length of non duplicate array " + res );
        removeDuplicatesInSortedArray.printArray(nums);

        System.out.println();

         nums = new int[]{ 0,1,1,1,2,3,4,5};
        removeDuplicatesInSortedArray.printArray(nums);
         res = removeDuplicatesInSortedArray.removeDuplicates(nums);
        System.out.println("Length of non duplicate array " + res );
        removeDuplicatesInSortedArray.printArray(nums);

        System.out.println();

        nums = new int[]{ 0,0,0,1,2,3,3,3,4,5};
        removeDuplicatesInSortedArray.printArray(nums);
         res = removeDuplicatesInSortedArray.removeDuplicates(nums);
        System.out.println("Length of non duplicate array " + res );
        removeDuplicatesInSortedArray.printArray(nums);
    }
}
