package Sorting;

/**
 * Created by m655222 on 5/27/2017.
 */
public class InsertionSort {

    public int[] sort(int a[]){

        if(a == null || a.length < 2){
            return a;
        }
        int temp;
        for(int i = 1; i < a.length ; i++){
            for(int j = i; j > 0 ; j --){
                if(a[j] < a[j-1]){
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
                printArray(a);
                System.out.println(" ");
            }

        }
        return a;


    }

    public void printArray(int [] a){
        for(int i : a){
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static void main (String arg[]){

        int a[] = new int [] {4,2,5,8,1,9,3,6,7};

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(a);
        System.out.println("********** ");
        insertionSort.printArray(a);
    }
}
