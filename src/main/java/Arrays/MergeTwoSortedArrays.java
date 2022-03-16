package Arrays;

/**
 * Created by M655222 on 11/9/2017.
 */
public class MergeTwoSortedArrays {

    public int [] merge(int []a, int []b){
        if(a == null && b== null){
            return null;
        }
        if(a.length ==0 && b.length ==0){
            return null;
        }
        if(a == null && b != null){
            return b;
        }

        if(a != null && b ==null){
            return a;
        }

        int [] result = new int[a.length +  b.length];
        int i=0,j=0, k=0;

        while( i < a.length && j < b.length ){
            if(a[i] == b [j]){
                result[k] = a[i];
                i++;
                j++;
            }else if(a[i] < b[j]){
                result[k] = a[i];
                i ++;
            }else {
                result[k] = b[j];
                j ++;
            }
            k++;
        }
        while(i < a.length ){
            result[k] = a[i];
            i++;
            k++;
        }
        while(j < b.length){
            result[k] = b[j];
            j++;
            k++;
        }
        return result;
    }

    public static void main(String arg[]){
        MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
        int[] resultEmpty = mergeTwoSortedArrays.merge(new int[]{},new int[]{});
        int[] result = mergeTwoSortedArrays.merge(new int[]{3,5,8,9,20},new int[]{1,2,4,6,7,8,10,11,12,13});
        for (int n:result) {
            System.out.println(n);
        }
        int[] result1 = mergeTwoSortedArrays.merge(new int[]{3,5,8,9},new int[]{1,2,4,6,7,8,10,11,12,13});
        for (int n:result1) {
            System.out.println(n);
        }


    }
}
