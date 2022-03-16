package Arrays;


public class ArrayCopyInArray {

    public static int[] copy(int[] A, int[] B){

        int aEnd = A.length  - 1;

        int indexBeforeZero = (A.length - B.length) - 1;

        int bEnd = B.length -1;

        while (indexBeforeZero >=0 && bEnd>=0 ){
            if(A[indexBeforeZero] > B[bEnd]){
                A[aEnd] = A[indexBeforeZero];
                indexBeforeZero --;
                aEnd --;
            }else{
                A[aEnd] = B[bEnd];
                aEnd --;
                bEnd --;
            }
        }

        while(bEnd >= 0 ){
            A[bEnd] = B[bEnd];
            aEnd --;
            bEnd--;
        }

        return A;
    }

    public static void main(String[] args) {
        int[] A = {1,3,5,7,9,0,0,0,0,0};
        int[] B = {2,4,6,8,10};

        A = copy(A,B);

        for (int v : A)
            System.out.print(v + " ");

         A = new int[] {2,2,2,0,0,0};
         B = new int[]{1,1,1};

        A = copy(A,B);

        for (int v : A)
            System.out.print(v + " ");
    }
}
