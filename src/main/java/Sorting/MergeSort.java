package Sorting;

/**
 * Created by m655222 on 5/27/2017.
 */
public class MergeSort {


    public int[] mergeSort(int [] array){

        if(array == null || array.length <=1){
            return array;

        }
        int middle = array.length /2;

        int[] left = new int[middle];
        int[] right ;
        if(array.length % 2 == 0){
            right = new int[middle];
        }else{
            right = new int[middle + 1];
        }

        for(int i = 0; i < left.length ; i ++){
            left[i] = array[i];
        }

        for(int j = 0; j < right.length ; j++){
            right[j] = array[middle + j];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        int [] result ;

        result = merge(left, right);

        return result;

    }

    private int[] merge(int[] left, int[] right) {

        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer =0;

        int[] result = new int [left.length + right.length];

        while(leftPointer < left.length || rightPointer < right.length){

            if(leftPointer < left.length && rightPointer < right.length){

                if(left[leftPointer] < right[rightPointer]){
                    result[resultPointer ++ ] = left[leftPointer ++];
                }else{
                    result[resultPointer ++] = right[rightPointer ++];
                }


            }else if(leftPointer < left.length){
                result[resultPointer ++ ] = left[leftPointer ++];

            }else if(rightPointer < right.length) {
                result[resultPointer ++] = right[rightPointer ++];
            }

        }
        return result;


    }

    public void printArray(int [] a){
        for(int i : a){
            System.out.print(i + " ");

        }
    }

    public static void main(String a[]){
        int input[] = new int [] {4,2,5,8,1,9,3,6,7};

        MergeSort mergeSort = new MergeSort();
        mergeSort.printArray(input);
        System.out.println();
        int[] result = mergeSort.mergeSort(input);
        mergeSort.printArray(result);

    }
}
